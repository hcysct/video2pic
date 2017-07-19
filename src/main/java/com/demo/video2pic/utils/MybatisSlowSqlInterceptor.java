package com.demo.video2pic.utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.apache.log4j.Logger;

/**
 * <Description> mybatis拦截器 记录sql执行时间 1、根据执行时间 2、根据包名过滤<br>
 * 记录com.demo.video2pic包路径下的 执行时间大于1s的 sql
 * @version 1.0<br>
 * @taskId <br>
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {
                MappedStatement.class, Object.class
        }),
        @Signature(type = Executor.class, method = "query", args = {
                MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class
        })
})
public class MybatisSlowSqlInterceptor implements Interceptor {

    /**
     * logger
     */
    private static Logger logger = Logger.getLogger("MybatisSlowSqlInterceptor");

    /**
     * 默认执行时间1s
     */
    private static final int TIME_DEFAULT = 1000;

    /**
     * 默认的包
     */
    private static final String PACKAGE_DEFAULT = "com.demo.video2pic";

    /**
     * 空格分隔符
     */
    private static final String SAPACE_SPLIT_STR = "    ";

    /**
     * 引号分隔符
     */
    private static final String QUOTATION_SPLIT_STR = "'";

    /**
     * 问号分隔符
     */
    private static final String QUESTION_MARK_SPLIT_STR = "\\?";

    /**
     * 时间阀值
     */
    private static int propTime = TIME_DEFAULT;

    /**
     * 指定的包
     */
    private static String propPacekage = PACKAGE_DEFAULT;

    /**
     * Description: <br>
     * 
     * @author lenovo<br>
     * @taskId <br>
     * @param invocation invocation
     * @return Object
     * @throws Throwable <br>
     */
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = null;
        if (invocation.getArgs().length > 1) {
            parameter = invocation.getArgs()[1];
        }
        String sqlId = mappedStatement.getId();
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        Configuration configuration = mappedStatement.getConfiguration();
        Object returnValue = null;
        long start = System.currentTimeMillis();
        returnValue = invocation.proceed();
        long end = System.currentTimeMillis();
        long time = (end - start);

        if (time >= propTime && sqlId.indexOf(propPacekage) != -1) {
            String sql = getSql(configuration, boundSql, sqlId, time);
            logger.error(sql);

        }
        return returnValue;
    }

    /**
     * Description: 拼装sql<br>
     * 
     * @author shiming<br>
     * @taskId <br>
     * @param configuration configuration
     * @param boundSql boundSql
     * @param sqlId sqlId
     * @param time time
     * @return <br>
     */
    public static String getSql(Configuration configuration, BoundSql boundSql, String sqlId, long time) {
        String sql = showSql(configuration, boundSql);
        StringBuilder str = new StringBuilder();
        str.append("\r\n    class:<" + sqlId + ">\r\n");
        str.append(SAPACE_SPLIT_STR);
        str.append("sql:[" + sql + "]\r\n");
        str.append(SAPACE_SPLIT_STR);
        str.append("time:" + time);
        str.append("ms");
        return str.toString();
    }

    /**
     * Description: <br>
     * 
     * @author shiming<br>
     * @taskId <br>
     * @param obj obj
     * @return <br>
     */
    private static String getParameterValue(Object obj) {
        String value = null;
        if (obj instanceof String) {
            value = QUOTATION_SPLIT_STR + obj.toString() + QUOTATION_SPLIT_STR;
        } else if (obj instanceof Date) {
            DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
            value = QUOTATION_SPLIT_STR + formatter.format(obj) + QUOTATION_SPLIT_STR;
        } else {
            if (obj != null) {
                value = obj.toString();
            } else {
                value = "";
            }

        }
        return value;
    }

    /**
     * Description: showSql<br>
     * 
     * @author shiming<br>
     * @taskId <br>
     * @param configuration configuration
     * @param boundSql boundSql
     * @return <br>
     */
    public static String showSql(Configuration configuration, BoundSql boundSql) {
        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
        if (parameterObject != null && !parameterMappings.isEmpty()) {
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                sql = sql.replaceFirst(QUESTION_MARK_SPLIT_STR, getParameterValue(parameterObject));

            } else {
                MetaObject metaObject = configuration.newMetaObject(parameterObject);
                for (ParameterMapping parameterMapping : parameterMappings) {
                    String propertyName = parameterMapping.getProperty();
                    if (metaObject.hasGetter(propertyName)) {
                        Object obj = metaObject.getValue(propertyName);
                        sql = sql.replaceFirst(QUESTION_MARK_SPLIT_STR, getParameterValue(obj));
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        Object obj = boundSql.getAdditionalParameter(propertyName);
                        sql = sql.replaceFirst(QUESTION_MARK_SPLIT_STR, getParameterValue(obj));
                    }
                }
            }
        }
        return sql;
    }

    /**
     * Description:获取属性 <br>
     * 
     * @author shiming<br>
     * @taskId <br>
     * @param properties <br>
     */
    public void setProperties(Properties properties) {
        // this.properties = properties;
        try {
            propTime = Integer.parseInt(properties.getProperty("time"));
            propPacekage = properties.getProperty("package");
        } catch (Exception ex) {
            propTime = TIME_DEFAULT;
            propPacekage = PACKAGE_DEFAULT;
        }

    }

    /**
     * Description: plugin<br>
     * 
     * @author shiming<br>
     * @taskId <br>
     * @param target Object
     * @return <br>
     */
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

}
