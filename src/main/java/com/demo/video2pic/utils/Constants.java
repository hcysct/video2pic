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
public class Constants {
	private static final Log log = LogFactory.getLog(Constants.class);
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

	public static final String PAGE_RESULT = "gosnResult";
	public static final String POP_MESSAGE = "popMessage";// 弹出消息在request的attribute属性名
	public static final String PAGE_INFORMATION = "pageInformation";// 分页数据在request的attribute属性名
	public static final String SESSION_USER = "sessionUser";// 用户在attribute属性名
	public static final String USER_TOKENID = "usertokenid";// 用户cookie中保存的tokenID
	public static final String COOKIE_TOKEN = "COOKIE_TOKEN";// 用户在cookie中暂存的令牌名
	public static final String NOTCHECK = "notcheck";// 退出后跳过7天免登陆和白名单登录拦截
	
	public static final String LOGIN_TYPE = "LOGIN_TYPE";// 用户在session中的登陆类型
	public static final String CHECK_CODE = "checkCode";// 验证码
	public static final String BASE_PATH = "basePath";// 系统地址
	public static final String TO_URL = "toUrl";// 记录上次和这次的url地址 map
	public static final String DEFAULT_PWD = "888888";// 系统默认密码
	public static final Character A = 'A';// 正常
	public static final Character U = 'U';// 失效 (暂停)
	public static final Character Z = 'Z';// 终止
	public static final String LOGGING_MSG = "loggingMsg";// 操作日志记录内容
	public static final String UV_COOKIE = "uvCookie";//UV统计
	public static final String INTERFACE_SUCCESS = "000000";// 接口返回正确编码

	public static final String INTERFACE_APPSUCCESS = "0000";// 接口返回正确编码
	public static final String INTERFACE_APPERROR = "0001";// 接口返回错误编码

	public static final Integer ADMINGROUP = 1;// 系统管理员组
	public static final Integer MOBILEGROUP = 2;// 移动管理员组
	public static final Integer CHANNELGROUP = 3;// 渠道管理员组

	public static final int NOTICE_TITLE_MAX_LENGTH = 1000; // 公告标题的最大长度
	public static final int NOTICE_ATTACHMENT_FILENAME_MAX_LENGTH = 1000; // 公告附件名称最大长度
	public static final int NOTICE_CONTENT_MAX_LENGTH = 1000; // 公告内容的最大长度

	public static final String APPROVE_CHANNELPRODUCT_YES = "1";
	public static final String APPROVE_CHANNELPRODUCT_NO = "0";
	public static final Integer READSERVICETYPE = 1;

	public static final Integer CHANNEL_WEIXIN = 0;// 线下微信分享channelId
	public static final Integer CHANNEL_CMCC_EDU = 1;// CMCC-EDU
	public static final Integer CHANNEL_FENXIANG = 2;// 线下QQ空间、新浪分享、人人分享、腾讯微博分享channelId
	public static final Integer CHANNEL_10086 = 3;// 10086微信服务号
	public static final Integer CHANNEL_YANCHENGWEIXIN = 4;// 盐城微信
	public static final Integer CHANNEL_NANJINGWEIXIN = 5;// 无锡微信
	public static final Integer CHANNEL_NANTONGWEIXIN = 6;// 南通微信
	public static final Integer CHANNEL_XIAOYUANDIAN = 7;// 校园店
	public static final Integer CHANNEL_XINWANGTEST = 88;// 欣网内部测试
	public static final Integer CHANNEL_HYLWEIXIN = 8;// “江苏和娱乐”微信
	public static final Integer CHANNEL_DUANXIN = 9;// 短信
	public static final Integer CHANNEL_1065861277DUANXIN_style1 = 10;// 短信1065861277通道板式一渠道
	public static final Integer CHANNEL_1065861277DUANXIN_style2 = 11;// 短信1065861277通道板式二渠道
	public static final Integer CHANNEL_CHONGLANG = 12;// 冲浪重定向
	public static final Integer CHANNEL_HUAIANWEIXIN = 13;// 淮安微信
	 public static final Integer CHANNEL_SUZHOUWEIXIN=14;//苏州微信
	public static final Integer CHANNEL_YANGZHOUWEIXINLIST = 15;// 扬州微信
	public static final Integer CHANNEL_ZHENJIANGWEIXINLIST = 16;// 镇江微信
	public static final Integer CHANNEL_HEYULEWEIBO = 17;// 和娱乐微博
	public static final Integer CHANNEL_HEYULEWEIXINLIST = 18;// 和娱乐微信菜单
	// public static final Integer CHANNEL_HEYULEWEIXINLIST=19;//大飞预订
	public static final Integer CHANNEL_WEIXINGUAJIDUANXIN = 20;// 移动通行证wap版
	public static final Integer CHANNEL_ZHANGTINGWAP = 21;// 掌厅换一换
	public static final Integer CHANNEL_ZHANGTINGAPK = 22;// 掌厅客户端承载

	public static final Integer CHANNEL_1065861277DUANXIN_style3 = 23;// 短信1065861277通道板式三渠道
	public static final Integer CHANNEL_1065861277DUANXIN_style4 = 24;// 短信1065861277通道板式四渠道
	public static final Integer CHANNEL_APP = 25;// 轻应用
	public static final Integer CHANNEL_SHUANGZHOUKAN1= 26;// 和娱乐双周刊短信1
	public static final Integer CHANNEL_SHUANGZHOUKAN2 = 27;// 和娱乐双周刊短信2//“又圆”大婚
	public static final Integer CHANNEL_SHUANGZHOUKAN3 = 28;// 和娱乐双周刊短信4//新剧《神雕侠侣》未播先吐槽
	public static final Integer CHANNEL_SHUANGZHOUKAN4 = 29;// 和娱乐双周刊短信5//大神答题短信
	public static final Integer CHANNEL_SHUANGZHOUKAN5 = 30;// 和娱乐双周刊短信5//大神答题彩信
	public static final Integer CHANNEL_FREEGAME = 31;// FREEGAME
	public static final Integer CHANNEL_SHUANGZHOUKAN6 = 32;// 和娱乐双周刊短信6//猛戳雷剧
	public static final Integer CHANNEL_SHUANGZHOUKAN7 = 33;// 和娱乐双周刊短信7//大神答题彩信
	public static final Integer CHANNEL_4GZHANGTING = 34;// 4G版掌厅的游戏乐园楼层
	public static final Integer CHANNEL_LIULIANGDUANXIN = 35;// 定向流量下发短信
	public static final Integer CHANNEL_HEYULENIANZHONGDAHUIKUI = 36;// 和阅读
	public static final Integer CHANNEL_ZHANGTINGKEHU = 37;// 掌厅客户端货架
	public static final Integer CHANNEL_ZHANGTINGWAPDUAN = 38;//  掌厅wap端货架
	public static final Integer CHANNEL_10086WEIXIN = 39;//  10086微信菜单
	public static final Integer CHANNEL_heshiping = 40;//  和视频
	public static final Integer CHANNEL_2015ZHANGTING = 41;//  掌厅2015新春活动
	public static final Integer CHANNEL_juhunzhuanti = 42;//  拒婚专题
	public static final Integer CHANNEL_SHUANGZHOUKAN8 = 43;// 和娱乐双周刊短信
	public static final Integer CHANNEL_heshenghuio = 44;//  和生活软件汇
	public static final Integer CHANNEL_yingyongfenfa = 45;//  应用分发
	public static final Integer CHANNEL_jufangkehuduan = 50;//  局方客户端下载测试
	public static final Integer CHANNEL_heyinyue = 51;//  和音乐
	public static final Integer CHANNEL_heyouxi = 52;//  和游戏
	public static final Integer CHANNEL_hedongman = 53;//  和动漫
	public static final Integer CHANNEL_xiaoxuntong = 54;//  校讯通
	public static final Integer CHANNEL_yindongxinwenkuaixun = 55;//  移动新闻快讯
	public static final Integer CHANNEL_qijiandain = 56;//  和娱乐旗舰店
	public static final Integer CHANNEL_changjingyinxiao = 57;//  场景营销
	public static final Integer CHANNEL_weixinjuzhen = 58;//  微信矩阵
	public static final Integer CHANNEL_xinwenzaowanbao = 59;//  新闻早晚报
	public static final Integer CHANNEL_meiriyixia = 60;//  每日一笑
	public static final Integer CHANNEL_M = 61;//  M+
	public static final Integer CHANNEL_huafeiyi = 62;//  话费易
	public static final Integer CHANNEL_zhangshangyule = 63;//  掌上娱乐
	public static final Integer CHANNEL_zimeiti = 64;//  自媒体
	public static final Integer CHANNEL_neibuqunfa = 65;//  内部群发
	public static final Integer CHANNEL_xinwenkuaibao = 66;//  新闻快报
	public static final Integer CHANNEL_gonggaolan = 67;//  滴滴打车公告栏
	public static final Integer CHANNEL_huodongjingxuan = 68;//  滴滴打车活动精选
	public static final Integer CHANNEL_shoumanwu = 69;//  滴滴打车手慢无
	public static final Integer CHANNEL_mingjiazaixian = 70;//  名家在线互动活动
	public static final Integer CHANNEL_muqinjiezhuanti = 71;//  母亲节专题活动
	public static final Integer CHANNEL_yingyongbao = 72;// 轻应用应用宝
	public static final Integer CHANNEL_wandoujia = 73;//  轻应用豌豆荚
	public static final Integer CHANNEL_360shoujizhushou = 74;//  轻应用360手机助手
	public static final Integer CHANNEL_yingyonghui = 75;//  轻应用应用汇
	public static final Integer CHANNEL_ppzhushou = 76;//  轻应用PP助手
	public static final Integer CHANNEL_maopaoshichang = 77;//  轻应用冒泡市场
	public static final Integer CHANNEL_mmshichang = 78;//  轻应用MM应用市场
	public static final Integer CHANNEL_91zhushou = 79;//  轻应用91助手
	public static final Integer CHANNEL_zhongxiaoxing = 80;//  轻应用中小型市场
	public static final Integer CHANNEL_200_300 = 200-300;// 娱乐周刊打码号段200至300
	public static final String CHANNEL_USERWEIXIN = "F10001012";// 用户微信
	public static final String CHANNEL_USERWEIBO = "F10002012";// 用户微博
	
	
	public static final Integer ACTIVITY_POLY_MAGIC_TICKET = 5;
	public static final Integer ACTIVITY_FLOW_BY_VIDEO = 6;
	public static final Integer ACTIVITY_PLAYORFEE_BY_SCRACH = 7;
	public static final Integer ACTIVITY_BOOK_MEETBEAUTIFYSELT = 8;
	public static final Integer ACTIVITY_SCRATCH = 9;// 刮刮乐
	public static final Integer ACTIVITY_BigWheel_lottery = 11;// 大转盘
	// 换一换接口和掌厅页面位置信息接口 retCode返回码
	public static final Integer OPERATION_SUCCESS = 1000;// 接口正常，数据按照预期返回
	public static final Integer PARAMETER_MISSING = 1001;// 缺少必要参数
	public static final Integer MOBILE_FORMAT_WRONG = 1002;// 手机号格式不正确
	public static final Integer AREA_TYPE_WRONG = 1003;// 区域类型不正确
	public static final Integer SERVER_ERROR = 1004;// 服务端处理错误，处理失败

	public static final String HIDDENSHARE = "hiddenShare"; // 右侧分享DIV 隐藏参数，默认显示

	public static final int FILMPAGESIZE = 4; // 影视确认每次递增展示条数
	
	public static final int INTERACTION_SUBJECT_SIZE = 5;	//和我互动：答题列表每次加载条数
	
	public static final int INTERACTION_QUESTION_SIZE = 1;	//和我互动：答题每页加载一个

	public static final String CURRENTIP = "currentIp";
	
	public static final String QUESTTION_LIST = "questionList";	//答题活动中问题IDList
	
	public static final String QUESTION_INDEX = "qIndex";	//用户答题到第几题索引
	
	public static final String QUESTION_TIME = "qTime";		//用户答题时间
	
	public static final int QUESTION_SCORE = 100;	//答题总成绩
	
	public static final String interactionTempl = "11000";	//互动功能号位

	// 解密密钥
	public static final String ENCRYPT_KEY = "A393570EDC36F6622901E128A8B74092";
	
	
	/*********************个人中心********************************************/
	public static final String CAC_USERCENTER_HASNEW = "CAC_USERCENTER_HASNEW";//用户个人中心是否有新的提示
	
	
	/*********************圣诞活动积分渠道**********************************/
	public static final int XMAS_SCORE_CHANNEL_HEBAO = 1;	//开和娱乐包
	public static final int XMAS_SCORE_CHANNEL_WEIXIN = 2;	//微信分享
	public static final int XMAS_SCORE_CHANNEL_WEIBO = 3;	//微博分享
	public static final int XMAS_SCORE_CHANNEL_HOT = 4;	//热门推荐
	public static final int XMAS_SCORE_CHANNEL_MDL = 5;	//麦当劳兑换
	public static final int XMAS_SCORE_CHANNEL_GJ = 6;		//刮奖

	public static final int XMAS_SCORE_CHANNEL_XUNBAO = 100;//寻宝
	
	/*********************圣诞活动积分返回码**********************************/
	public static final int XMAS_SCORE_CODE_ERROR = -1;		//积分添加异常
	public static final int XMAS_SCORE_CODE_RECEIVED = 0;		//用户已获得该积分
	public static final int XMAS_SCORE_CODE_SUCCESS = 1;		//用户已获得该积分
	
	/*********************分享送豪礼 豪礼确认功能返回码*********************************/
	public static final int ACT_PHONENO_NEVER = 1006;			//未查到有效手机号
	public static final int ACT_PHONENO_ACT_TIME = 1005;		//不在活动期间
	public static final int ACT_PHONENO_HAS_RECERVE = 1007;	//已领奖
	public static final int ACT_PHONENO_CODE_ERROR = 1008;		//验证码错误
	public static final int ACT_PHONENO_CODE_SUCCESS = 1000;	//校验通过	
	
	
	/**********************答题抽奖*****************************************/
	public static final String DT_ALLUSERS = "dt_allUsers";//可参与活动的用户
	public static final String DT_TOTAL_COUNT = "dt_total_count";//累计数
	public static final String DT_AWARD_NUMBER = "dt_award_number_";//累计数奖品对照表
	public static final String DT_PRE_CHECKCODE = "dt_checkcode_";//用户验证码
	public static final String DT_PRE_CHECKCODE_LIMIT = "dt_checkcode_limit_";//验证码输错次数
	public static final String DT_PRE_DRAWCOUNT = "dt_drawcount_";//用户累计抽奖次数
	public static final String DT_PRE_ISWIN = "dt_iswin_";//用户是否中奖
	public static final String DT_ACTIVITYDATE = "dt_activitydate";//活动日期 年月日
	public static final String DT_AVTIVITYTIME = "dt_activitytime";//活动时间 时分秒
	
	public static final int DT_NOTLOGIN =2001 ;//未登录返回码
	public static final int DT_WRONGTIME = 2002;//不在活动时间返回码
	public static final int DT_WRONGCHECKCODE = 2003;//错误的验证码
	public static final int DT_WRONGCHECKCODE_FREEZE =2004 ;//验证码次数超过8次  用户抽奖被冻结10分钟
	public static final int DT_NOTDRAWQUALIFICATION = 2005;//无资格抽奖
	public static final int DT_NOTHAVETIMES = 2006;//用户抽奖次数已用完
	public static final int DT_NOAWARD= 2007;//奖品不存在或奖品剩余数量为0
	
	public static final int DT_SUCCESS_YES= 1000;//用户中奖
	public static final int DT_SUCCESS_NO= 1001;//用户未中奖
	
	/**********************欢乐豆*****************************************/
	public static final String ACT_HLD_TYPE_SC= "0";//首次进入
	public static final String ACT_HLD_TYPE_QD= "1";//欢乐豆签到
	public static final String ACT_HLD_TYPE_FX= "2";//欢乐豆分享
	public static final String ACT_HLD_TYPE_HD= "3";//欢乐豆活动
	
	public static final String ACT_HLD_SIGN_STATUS_SC= "0";//欢乐豆首次
	public static final String ACT_HLD_SIGN_STATUS_FIRST= "1";//欢乐豆连续签到1天
	public static final String ACT_HLD_SIGN_STATUS_SECOND= "2";//欢乐豆连续签到2天
	public static final String ACT_HLD_SIGN_STATUS_THIRD= "3";//欢乐豆连续签到3天
	public static final String ACT_HLD_SIGN_STATUS_FORTH= "4";//欢乐豆连续签到4天
	public static final String ACT_HLD_SIGN_STATUS_FIFTH= "5";//欢乐豆连续签到5天
	
	public static final int ACT_HLD_SIGN_WEB = 5;//签到每次累加5
	public static final int ACT_HLD_SIGN_CLIENT = 10;//轻应用签到每次累加10
	
	public static final int ACT_HLD_SHARE_MAX_FX = 50;//日分享上限

	public static final String BUSINESS_SOURCE_ACT_CODE = "1"; // 业务来源活动代码
	public static final String BUSINESS_SOURCE_CONT_CODE = "2"; // 业务来源内容代码
	public static final String BUSINESS_SOURCE_DOWN_CODE = "3"; // 业务来源应用下载代码

	public static final String BUSINESS_RESULT_SUCCESS = "1"; // 业务结果办理成功
	public static final String BUSINESS_Result_FAILED = "0"; // 业务结果办理失败

	/**
	 * 掌厅订购传递接口
	 */
	public static final String ZT_ORDER_KEY = "zt0001";// 掌厅订购秘钥
	/**
	 * 用户号码在cookie中存放值  AES加密解密秘钥 
	 */
	public static final String COOKIE_PHONENO_ENCRYPKEY = "hylqwop1230980asd";
	/**
	 * 用户号码轻应用中加密
	 */
	public static final String QYY_PHONENO_ENCRYPKEY = "qyyqwop123";
	/**
	 * 轻应用调用接口,用户号码加密
	 */
	public static final String QYY_PHONENO_DESKEY = "yulehui3344";
	/**
	 * cookie抓取率过低增强方案
	 * 用户号码关联的uvcookie存入redis
	 * KEY值
	 */
	public static final String CACHE_UV_COOKIE= "CACHE_UV_COOKIE";
	
	/**
	 * 渠道数据 缓存key
	 */
	public static final String channeldata_hash_key= "channeldataHashKey";
	/**
	 * 业务信息缓存key
	 */
	public static final String businessManageTitle_hash_key= "businessManageTitleHashKey";

	/**
	 * 连接类型缓存key
	 */
	public static final String businessManageURLType_hash_key = "businessManageUrlTypeHashKey";

	/**
	 * 业务类型缓存key
	 */
	public static final String businessManageBusinessId_hash_key = "businessManageBusinessIdHashKey";

	/**
	 * 业务标签缓存key
	 */
	public static final String businessManageBusinessTag_hash_key = "businessManageBusinessTagHashKey";

	/**
	 * temp名称缓存key
	 */
	public static final String activityMiddleDataTempName_hash_key = "activityMiddleDataTempNameHashKey";

	/**
	 * 号段对应地市缓存key
	 */
	public static final String SegmentPhoneNoToCity_hash_key = "SegmentPhoneNoToCityHashKey";
	/**
	 * 字符编码转换：ISO-8859-1 => UTF
	 * 
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String iso2utf(String str) throws UnsupportedEncodingException {
		return new String(str.getBytes("ISO-8859-1"), "UTF-8");
	}

	/**
	 * java对象转jsonStr
	 * 
	 * @param javaObj
	 * @return
	 */
	public static final JSONObject getJsonObject(Object javaObj) {
		if(javaObj==null) return null;
		return JSONObject.fromObject(javaObj);
	}
	public static final String getJsonString(Object javaObj) {
		if(javaObj==null) return null;
		return JSONObject.fromObject(javaObj).toString();
	}
	
	/**
	 * jsonStr转java对象
	 * @param jsonString
	 * @param beanClass
	 * @return
	 */
	public static final Object JsonStr2Bean(String jsonString,Class beanClass){
		if(jsonString.trim().length()>0){
			//将json字符串转换为json对象
			JSONObject obj = JSONObject.fromObject(jsonString);
			//将建json对象转换为java对象
			return JSONObject.toBean(obj,beanClass);
		}
		return null;
	}
	
	/**
	 * xmlStr 转 jsonStr
	 * @param xml
	 * @return
	 */
	public static String xml2JSON(String xml){
        return new XMLSerializer().read(xml).toString();
    }
     
    public static String json2XML(String json){
        JSONObject jobj = JSONObject.fromObject(json);
        String xml =  new XMLSerializer().write(jobj);
        return xml;
    }
	public static final String getParameter(HttpServletRequest request, String paramStr, String defaultReturn) {
		return (StringUtils.isBlank(request.getParameter(paramStr))) ? defaultReturn : request.getParameter(paramStr);
	}
	public static final int getIntParameter(HttpServletRequest request, String paramStr, int defaultReturn) {
		int result=-1;
		try{
			result=(StringUtils.isBlank(request.getParameter(paramStr))) ? defaultReturn : Integer.parseInt(request.getParameter(paramStr));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	public static final String getParameter(HttpServletRequest request, String paramStr, String defaultReturn, String enc) {
		if (request.getParameter(paramStr) == null) {
			return defaultReturn;
		} else {
			try {
				return URLDecoder.decode(request.getParameter(paramStr), enc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	public static final String getAttribute(HttpServletRequest request, String attriStr, String defaultReturn) {
		return request.getAttribute(attriStr) == null ? defaultReturn : request.getAttribute(attriStr).toString();
	}
	
	/*
	 * 上个月
	 */
	public static String upMonth(){
		
		   Calendar c = Calendar.getInstance();
		   c.add(Calendar.MONTH, -1);
		   SimpleDateFormat format =  new SimpleDateFormat("yyyyMM");
		   String time = format.format(c.getTime());
		   return time;
	}

	/**
	 * 年月
	 * @return
	 */
	public static String currentYearMonth() {
		return new SimpleDateFormat("yyyyMM").format(new Date());
	}
	/**
	 * 月日
	 * @return
	 */
	public static String currentMonthDay() {
		return new SimpleDateFormat("MMdd").format(new Date());
	}
	/**
	 * 日
	 * @return
	 */
	public static String currentDay() {
		return new SimpleDateFormat("dd").format(new Date());
	}

	/**
	 * 年月日
	 * @return
	 */
	public static String currentYearMonthDay() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}

	/**
	 * 时分秒
	 * @return
	 */
	public static String currentHourMinuteSecond() {
		return new SimpleDateFormat("HHmmss").format(new Date());
	}
	/**
	 * 时分
	 * @return
	 */
	public static String currentHourMinute() {
		return new SimpleDateFormat("HHmm").format(new Date());
	}

	/**
	 * 14位日期
	 * @return
	 */
	public static String currentDate() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	

	public static String getStr(String str) {
		String strVal = null;
		if (str.contains("\\")) {
			strVal = str.replace("\\", "");
		} else if (str.contains("\'")) {
			strVal = str.replace("\'", "");
		} else {
			strVal = str;
		}
		return strVal;
	}

	/**
	 * cookie中获取渠道号
	 * 
	 * @return
	 */
	public static String getChannelId(HttpServletRequest request) {
		String channelId = null;
		Cookie[] cookies = request.getCookies();
		if (null == cookies) {
			return null;
		}
		for (Cookie c : cookies) {
			if (StringUtils.equals(c.getName(), "channelId")) {
				channelId = c.getValue();
				break;
			}
		}
		return channelId;
	}
	/**
	 * cookie中获取UV cookie标记
	 * 
	 * @return
	 */
	public static String getUvCookie(HttpServletRequest request) {
		String uvCookie = null;
		Cookie[] cookies = request.getCookies();
		if (null == cookies) {
			return null;
		}
		for (Cookie c : cookies) {
			if (StringUtils.equals(c.getName(), UV_COOKIE)) {
				uvCookie = c.getValue();
				break;
			}
		}
		return uvCookie;
	}
	/**
	 * cookie中获取uvUID 
	 * 
	 * @return
	 */
	public static String getuvUID(HttpServletRequest request) {
		String uvUIDCookie = null;
		Cookie[] cookies = request.getCookies();
		if (null == cookies) {
			return null;
		}
		for (Cookie c : cookies) {
			if (StringUtils.equals(c.getName(), "uvUID")) {
				uvUIDCookie = c.getValue();
				break;
			}
		}
		return uvUIDCookie;
	}
	/**
	 * 获取templId
	 * 
	 * @return
	 */
	public static String getTemplId(HttpServletRequest request, String tempId) {
		return Constants.getParameter(request, "templId", tempId);
	}



	/**
	 * 返回当前第几个星期
	 * @return
	 */
	public static int currentWeek(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.WEEK_OF_MONTH);
	}
	/**
	 * 返回当前第几个月
	 * @return
	 */
	public static int currentMonth(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.MONTH)+1;
	}

	/**
	 * 根据请求获取IP
	 *
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String strUserIp = "127.0.0.1";
		strUserIp = request.getHeader("X-IP-Real-JSWY");
		if (strUserIp == null || strUserIp.length() == 0
				|| "unknown".equalsIgnoreCase(strUserIp)) {
			strUserIp = request.getHeader("X-Forwarded-For");
		}
		if (strUserIp == null || strUserIp.length() == 0
				|| "unknown".equalsIgnoreCase(strUserIp)) {
			strUserIp = request.getHeader("Proxy-Client-IP");
		}
		if (strUserIp == null || strUserIp.length() == 0
				|| "unknown".equalsIgnoreCase(strUserIp)) {
			strUserIp = request.getHeader("WL-Proxy-Client-IP");
		}
		if (strUserIp == null || strUserIp.length() == 0
				|| "unknown".equalsIgnoreCase(strUserIp)) {
			strUserIp = request.getRemoteAddr();
		}
		// 解决获取多网卡的IP地址问题
		if (strUserIp != null) {
			strUserIp = strUserIp.split(",")[0];
		} else {
			strUserIp = "127.0.0.1";
		}
		// 解决获取IPv6地址 暂时改为本机地址模式
		if (strUserIp.length() > 16) {
			strUserIp = "127.0.0.1";
		}
		return strUserIp;
	}
	/**
	 * 判断是否为可执行定时任务的服务容器
	 * @return
	 */
	public static boolean isTaskServer(){
		String currentPath = (String) System.getProperties().get("catalina.base");
		if (currentPath == null) {
			currentPath = (String) System.getProperties().get("CATALINA_BASE");
		}
		if (currentPath.indexOf("app1") > -1) {
			return true;
		}
		return false;
	}

	
	/**
	 * request中获取cookie的Map
	 * @param request
	 * @return Map<String,String>
	 */
	public static Map<String,String> getUserCookieMap(HttpServletRequest request){
		Map<String,String> map=new HashMap<String, String>();
		Cookie[] cookies = request.getCookies();
		if(cookies==null) return map;
		for (Cookie c : cookies) {
			map.put(c.getName(), c.getValue());
		}
		return map;
	}
	
	/** 
	* @Fields MAP_ACT_HLD_TYPE : 欢乐豆获取类型对应积分
	*/ 
	public static final Map<String,String> MAP_ACT_HLD_TYPE = new HashMap<String, String>()
    {
		private static final long serialVersionUID = 1L;
		{
            put(ACT_HLD_TYPE_SC, "30");//首次登陆
            put(ACT_HLD_TYPE_QD, "5");//签到
            put(ACT_HLD_TYPE_FX, "2");//分享
            put(ACT_HLD_TYPE_HD, "0");//活动
        }
    };
    
    /**
	 * 获取用户手机操作系统
	 * @param userAgent Header信息
	 * @return 操作系统信息
	 */
	public static String getOsNameByAgent(String userAgent)
	{
		String[] keywords = { "iphone", "ipod", "ipad" };
		if (StringUtils.isNotBlank(userAgent)) 
		{

			// 如果找到 Android 系统标记 返回
			if (userAgent.indexOf("android") != -1) {
				return "android";
			}

			// 如果找到apple系统标记 返回 ios
			for (int i = 0; i < keywords.length; i++) {
				if (userAgent.indexOf(keywords[i]) != -1) {
					return "ios";
				}
			}
		}
		
		// 如果 user agent 为空或既不是Android系统又不是IOS系统 返回
		return "other";
	}
	
	/***
	 *  判断用户使用何种网络环境访问
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	
	public static String getBearType(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            if("x-up-bear-type".equals(key))
            {
            	return "GPRS";
            }
        }
		return "WIFI";
	}
    
	
	
	/**
     * 
     * @Title : filterNumber
     * @Type : FilterStr
     * @Description : 过滤出数字
     * @param str
     * @return
     */
    public static String filterNumber(String number)
    {
    	if(StringUtils.isEmpty(number)) return number;
        number = number.replaceAll("[^(0-9)]", "");
        return number;
    }
    
	/**
     * 
     * @Title : filterNumber
     * @Type : FilterStr
     * @Description : 过滤出手机号码
     * @param str
     * @return
     */
    public static String filterPhoneNo(String number)
    {
    	if(StringUtils.isEmpty(number)) return number;
    	Pattern mobilesp = Pattern.compile("^1\\d{10}$");
		Matcher mobilesm = mobilesp.matcher(number);
		if (mobilesm.matches()){
			return number;
		}else{
			return "";
		}
    }
     
    

    /**
     * 
     * @Title : filterAlphabet
     * @Type : FilterStr
     * @Description : 过滤出字母
     * @param alph
     * @return
     */
    public static String filterAlphabet(String alph)
    {
    	if(StringUtils.isEmpty(alph)) return alph;
        alph = alph.replaceAll("[^(A-Za-z)]", "");
        return alph;
    }
    
    
    /**
     * 
     * @Title : filterAlphabet
     * @Type : FilterStr
     * @Description : 过滤出下划线 、字母、数字
     * @param alph
     * @return
     */
    public static String filterAlphabetNumber(String alph)
    {
    	if(StringUtils.isEmpty(alph)) return alph;
        alph = alph.replaceAll("[^(_a-zA-Z0-9)]", "");
        return alph;
    }
     
    /**
     * 
     * @Title : filterChinese
     * @Type : FilterStr
     * @Description : 过滤出中文
     * @param chin
     * @return
     */
    public static String filterChinese(String chin)
    {
    	if(StringUtils.isEmpty(chin)) return chin;
        chin = chin.replaceAll("[^(\\u4e00-\\u9fa5)]", "");
        return chin;
    }
    

    /**
     * 
     * @Title : filterParam
     * @Type : FilterStr
     * @Description : 过滤出下划线、字母、数字和中文 
     * 					过滤url
     * @param character
     * @return
     */
    public static String filterParam(String character)
    {
    	if(StringUtils.isEmpty(character)) return character;
        character = character.replaceAll("[^(=_:./#?&a-zA-Z0-9\\u4e00-\\u9fa5)]", "");
        return character;
    }
    
    /**
     * JSON部分特殊符号转义
     * @param str
     * @return
     */
    public static String stringToJson(String str){
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotEmpty(str)){
			for(int i=0; i<str.length(); i++){
				char c = str.charAt(i);
				switch(c){
					case '\"':
						sb.append("\\\"");
						break;
					case '\\':
						sb.append("\\\\");
						break;
					case '/':
						sb.append("\\/");
						break;
					case '\b':
						sb.append("\\b");
						break;
					case '\f':
						sb.append("\\f");
						break;
					case '\n':
						sb.append("\\n");
						break;
					case '\r':
						sb.append("\\r");
						break;
					case '\t':
						sb.append("\\t");
						break;
					default:
						sb.append(c);
				}
			}
		}
		return sb.toString();
	}
}
