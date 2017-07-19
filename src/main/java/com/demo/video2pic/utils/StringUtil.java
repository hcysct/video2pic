/**************************************************************************************** 

 ****************************************************************************************/
package com.demo.video2pic.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * <Description> 字符串工具类<br> 
 *  
 * @author zhangyuzhu<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年2月26日 <br>
 */

public class StringUtil {
    
    /**
     * Description: 判断是否为空<br> 
     *  
     * @author zhangyuzhu<br>
     * @taskId <br>
     * @param str String
     * @return boolean<br>
     */
    public static boolean isNull(String str) {
        boolean flag = false;
        if (null == str || "".equals(str)) {
            flag = true;
        }
        return flag;
    }
    
    /**
     * Description: 判断是否是"null"字符串<br> 
     *  
     * @author zhangyuzhu<br>
     * @taskId <br>
     * @param str String
     * @return boolean<br>
     */
    public static boolean isNullStr(String str) {
        boolean flag = false;
        if ("null".equals(str)) {
            flag = true;
        }
        return flag;
    }
    
    /**
     * Description: 校验用户输入参数 :清除掉所有特殊字符, 只允许字母和数字<br> 
     *  
     * @author zhangyuzhu<br>
     * @taskId <br>
     * @param str String
     * @return String
     */
    public static String stringFilter(String str) {
        if (null == str) {
            return "";
        }
        // 清除掉所有特殊字符, 只允许字母和数字
        String regEx = "[`~!#$%^&*()+=|{}':;',\\[\\]<>/?~！#￥%……&*（）——+|{}【】‘；：\"”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

}
