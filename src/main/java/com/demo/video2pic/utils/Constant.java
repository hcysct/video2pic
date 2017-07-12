package com.demo.video2pic.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

/**
 * 公共常量类
 */
@SuppressWarnings({"unused","rawtypes"})
public class Constant {
	private static final Log log = LogFactory.getLog(Constant.class);
    public static final int SUCCESS = 0;//操作成功
    public static final int FAILURE = -1;//操作失败
	/**
	 * pv日志记录
	 */
	public static final int PV_ACTIVITYDATA = 1;
	public static final int PV_LINKDATA = 2;
	public static final int PV_FREEGAME = 3;
	/**
	 * WAIT_TIME 获取不到redis资源,等待500ms
	 */
	public static final int WAIT_TIME = 500;

	/**
	 * CYCLE_TIMES 连续获取3次失败,则不再获取
	 */
	public static final int CYCLE_TIMES = 3;
	public static final int ACTION_SUCCESS = 0;// 操作成功返回码
	public static final int ACTION_FAILED = -1;// 操作失败返回码

	
}
