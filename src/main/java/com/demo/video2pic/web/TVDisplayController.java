package com.demo.video2pic.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.video2pic.bean.Result;
import com.demo.video2pic.utils.Constant;

import net.sf.json.JSONObject;

/** 
 * <Description>勇刚总电视可视化<br> 
 *  
 * @author zyh<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2017年7月11日 <br>
 */
@Controller
@RequestMapping("/TVDisplay")
public class TVDisplayController {
    
    /**
     * 日志记录
     */
    private static final Logger logger = Logger.getLogger(TVDisplayController.class);
    
    /**
     * 是否需要加缓存
     * 如果加 多长时间
     */
    
    
    /**
     * 1、天翼用户规模1-1
     * 折线图
     * 去年完成量
     * 今年完成量
     * 今年指标量
     */
    /**
     * 
     * 
     * {"msg":"操作成功","resultCode":0,"resultObj":{"currentYear":[11,12,13,14,15,16,17,18,19],"lastYear":[1,2,3,4,5,6,7,8,9],"target":[21,22,23,24,25,26,27,28,29]},"success":true}
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/esUserScale")
    @ResponseBody
    public String esUserScale(HttpServletResponse response, HttpServletRequest request) {
       	Result result=new Result();
       	result.setMsg("操作成功");
       	result.setResultCode(Constant.SUCCESS);
       	result.setSuccess(true);
        Map map=new HashMap();
        map.put("lastYear", new Integer[]{1,2,3,4,5,6,7,8,9});
        map.put("currentYear", new Integer[]{11,12,13,14,15,16,17,18,19});
        map.put("target", new Integer[]{21,22,23,24,25,26,27,28,29});
        result.setResultObj(map);
       	return JSONObject.fromObject(result).toString();
    }
    /**
     * 2、天翼用户规模1-2
     * 饼图列表
     * 当月套餐结构
     * 当月户均通话时长
     * 当月户均收入
     * 当月户均流量消费
     */
    /**
     * 
     * {"msg":"操作成功","resultCode":0,"resultObj":{"currentYear":[11,12,13,14,15,16,17,18,19],"lastYear":[1,2,3,4,5,6,7,8,9],"target":[21,22,23,24,25,26,27,28,29]},"success":true}
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/esUserScaleMonthly")
    @ResponseBody
    public String esUserScaleMonthly(HttpServletResponse response, HttpServletRequest request) {
       	Result result=new Result();
       	result.setMsg("操作成功");
       	result.setResultCode(Constant.SUCCESS);
       	result.setSuccess(true);
       	
        Map resultObj=new HashMap();
        
        Map packageStructure=new HashMap();
        packageStructure.put("hiCard", "10");
        packageStructure.put("dailyRentCard", "20");
        packageStructure.put("iFreeCard", "30");
        packageStructure.put("other", "40");
        resultObj.put("packageStructure", packageStructure);
        
        Map talkTime=new HashMap();
        talkTime.put("0-120", "10");
        talkTime.put("120-480", "20");
        talkTime.put("480-1000", "30");
        talkTime.put("1000+", "40");
        resultObj.put("talkTime", talkTime);
        
        Map income=new HashMap();
        income.put("0-20", "10");
        income.put("20-100", "20");//30-100在哪里
        income.put("100-300", "30");
        income.put("300+", "40");
        resultObj.put("income", income);
        
        Map flowConsumption=new HashMap();
        flowConsumption.put("0-500M", "10");
        flowConsumption.put("500M-1G", "20");
        flowConsumption.put("1G-3G", "30");
        flowConsumption.put("3G+", "40");
        resultObj.put("flowConsumption", flowConsumption);
        
        result.setResultObj(resultObj);
       	return JSONObject.fromObject(result).toString();
    }

    /**
     *3、 宽带用户规模2-1
     * 折线图
     * 去年完成量
     * 今年完成量
     * 今年指标量
     */
    /**
     * 
     * 
     * {"msg":"操作成功","resultCode":0,"resultObj":{"currentYear":[11,12,13,14,15,16,17,18,19],"lastYear":[1,2,3,4,5,6,7,8,9],"target":[21,22,23,24,25,26,27,28,29]},"success":true}
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/bbUserScale")
    @ResponseBody
    public String bbUserScale(HttpServletResponse response, HttpServletRequest request) {
       	Result result=new Result();
       	result.setMsg("操作成功");
       	result.setResultCode(Constant.SUCCESS);
       	result.setSuccess(true);
        Map map=new HashMap();
        map.put("lastYear", new Integer[]{1,2,3,4,5,6,7,8,9});
        map.put("currentYear", new Integer[]{11,12,13,14,15,16,17,18,19});
        map.put("target", new Integer[]{21,22,23,24,25,26,27,28,29});
        result.setResultObj(map);
       	return JSONObject.fromObject(result).toString();
    }
    /**
     * 4、宽带用户规模2-2速率结构
     * 饼图列表
     * 速率结构
     */
    /**
     * 
     * {"msg":"操作成功","resultCode":0,"resultObj":{"currentYear":[11,12,13,14,15,16,17,18,19],"lastYear":[1,2,3,4,5,6,7,8,9],"target":[21,22,23,24,25,26,27,28,29]},"success":true}
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/bbUserScaleStruct")
    @ResponseBody
    public String bbUserScaleStruct(HttpServletResponse response, HttpServletRequest request) {
       	Result result=new Result();
       	result.setMsg("操作成功");
       	result.setResultCode(Constant.SUCCESS);
       	result.setSuccess(true);
       	
        Map resultObj=new HashMap();
        resultObj.put("0-20M",10);
        resultObj.put("20M", 20);
        resultObj.put("50M", 30);
        resultObj.put("100M", 40);
        resultObj.put("200M", 50);
        result.setResultObj(resultObj);
       	return JSONObject.fromObject(result).toString();
    }
    
    
    /**
     * 5、用户经营
     * 存量维系5项标准动作2017完成情况
     * 折线柱状图
     * 每月办理笔数
     * 每月目标数
     */
    /**
     * 
     * 
     * {"msg":"操作成功","resultCode":0,"resultObj":{"currentYear":[11,12,13,14,15,16,17,18,19],"lastYear":[1,2,3,4,5,6,7,8,9],"target":[21,22,23,24,25,26,27,28,29]},"success":true}
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/userOperationYearPerform")
    @ResponseBody
    public String userOperationYearFinish(HttpServletResponse response, HttpServletRequest request) {
       	Result result=new Result();
       	result.setMsg("操作成功");
       	result.setResultCode(Constant.SUCCESS);
       	result.setSuccess(true);
        Map map=new HashMap();
        map.put("handleNumber", new Integer[]{1,2,3,4,5,6,7,8,9});
        map.put("targetNumber", new Integer[]{11,12,13,14,15,16,17,18,19});
        result.setResultObj(map);
       	return JSONObject.fromObject(result).toString();
    }
    
    
    
    /**
     * 6、用户经营
     * 月存量维系5项标准动作各业务完成情况
     * 柱状图
     * 
     */
    /**
     * 
     * 
     * {"msg":"操作成功","resultCode":0,"resultObj":{"currentYear":[11,12,13,14,15,16,17,18,19],"lastYear":[1,2,3,4,5,6,7,8,9],"target":[21,22,23,24,25,26,27,28,29]},"success":true}
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/userOperationBizPerform")
    @ResponseBody
    public String userOperationBizPerform(HttpServletResponse response, HttpServletRequest request) {
       	Result result=new Result();
       	result.setMsg("操作成功");
       	result.setResultCode(Constant.SUCCESS);
       	result.setSuccess(true);
        Map map=new HashMap();
        map.put("addEsurfing", 1);
        map.put("addBraodband", 2);
        map.put("addItv", 3);
        map.put("addVicecard", 4);
        map.put("addFamilyhi", 5);
        map.put("3To4", 6);
        map.put("oldUpgrade", 7);
        map.put("broadbandSpeed", 8);
        map.put("broadbandRenewal", 9);
        result.setResultObj(map);
       	return JSONObject.fromObject(result).toString();
    }
    
    
    /**
     * 7、流量经营
     * 流量业务订购
     * 折线图
     * 去年完成量
     * 今年完成量
     * 今年指标量
     */
    /**
     * 
     * 
     * {"msg":"操作成功","resultCode":0,"resultObj":{"currentYear":[11,12,13,14,15,16,17,18,19],"lastYear":[1,2,3,4,5,6,7,8,9],"target":[21,22,23,24,25,26,27,28,29]},"success":true}
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/flowOperationBizOrder")
    @ResponseBody
    public String flowOperationBizOrder(HttpServletResponse response, HttpServletRequest request) {
       	Result result=new Result();
       	result.setMsg("操作成功");
       	result.setResultCode(Constant.SUCCESS);
       	result.setSuccess(true);
        Map map=new HashMap();
        map.put("lastYear", new Integer[]{1,2,3,4,5,6,7,8,9});
        map.put("currentYear", new Integer[]{11,12,13,14,15,16,17,18,19});
        map.put("target", new Integer[]{21,22,23,24,25,26,27,28,29});
        result.setResultObj(map);
       	return JSONObject.fromObject(result).toString();
    }
    
    /**
     * 8、流量经营
     * 月流量业务类型分布
     * 饼图列表
     * 包月包、加餐包、短大包、内容包
     */
    /**
     * 
     * {"msg":"操作成功","resultCode":0,"resultObj":{"currentYear":[11,12,13,14,15,16,17,18,19],"lastYear":[1,2,3,4,5,6,7,8,9],"target":[21,22,23,24,25,26,27,28,29]},"success":true}
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/flowOperationBizDist")
    @ResponseBody
    public String flowOperationBizDist(HttpServletResponse response, HttpServletRequest request) {
       	Result result=new Result();
       	result.setMsg("操作成功");
       	result.setResultCode(Constant.SUCCESS);
       	result.setSuccess(true);
       	
        Map resultObj=new HashMap();
        resultObj.put("monthlyPackage",10);
        resultObj.put("snacksPackage", 20);
        resultObj.put("shortBigPackage", 30);
        resultObj.put("contentPackage ", 40);
        result.setResultObj(resultObj);
       	return JSONObject.fromObject(result).toString();
    }
    
    
    /**
     * 9、活跃用户
     * 月各厅活跃用户数
     * 柱形图
     * 天翼生活、网厅、微厅、短厅、掌厅触屏
     */
    /**
     * 
     * {"msg":"操作成功","resultCode":0,"resultObj":{"currentYear":[11,12,13,14,15,16,17,18,19],"lastYear":[1,2,3,4,5,6,7,8,9],"target":[21,22,23,24,25,26,27,28,29]},"success":true}
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/activeUserMonthly")
    @ResponseBody
    public String activeUserMonthly(HttpServletResponse response, HttpServletRequest request) {
       	Result result=new Result();
       	result.setMsg("操作成功");
       	result.setResultCode(Constant.SUCCESS);
       	result.setSuccess(true);
       	
        Map resultObj=new HashMap();
        resultObj.put("elife",10);
        resultObj.put("netCafe", 20);
        resultObj.put("microHall", 30);
        resultObj.put("shortHall", 40);
        resultObj.put("palmHall", 50);
        result.setResultObj(resultObj);
       	return JSONObject.fromObject(result).toString();
    }
    
    /**
     * 10、活跃用户
     * 日各厅活跃用户数
     * 柱形图
     * 天翼生活、网厅、微厅、短厅、掌厅触屏
     */
    /**
     * 
     * {"msg":"操作成功","resultCode":0,"resultObj":{"currentYear":[11,12,13,14,15,16,17,18,19],"lastYear":[1,2,3,4,5,6,7,8,9],"target":[21,22,23,24,25,26,27,28,29]},"success":true}
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/activeUserDaily")
    @ResponseBody
    public String activeUserDaily(HttpServletResponse response, HttpServletRequest request) {
       	Result result=new Result();
       	result.setMsg("操作成功");
       	result.setResultCode(Constant.SUCCESS);
       	result.setSuccess(true);
       	Map resultObj=new HashMap();
       	
        Map currentMonthDay=new HashMap();
        currentMonthDay.put("elife",10);
        currentMonthDay.put("netCafe", 20);
        currentMonthDay.put("microHall", 30);
        currentMonthDay.put("shortHall", 40);
        currentMonthDay.put("palmHall", 50);
        resultObj.put("currentMonthDay", currentMonthDay);
        Map lastMonthDay=new HashMap();
        lastMonthDay.put("elife",10);
        lastMonthDay.put("netCafe", 20);
        lastMonthDay.put("microHall", 30);
        lastMonthDay.put("shortHall", 40);
        lastMonthDay.put("palmHall", 50);
        resultObj.put("lastMonthDay", lastMonthDay);
        
        result.setResultObj(resultObj);
       	return JSONObject.fromObject(result).toString();
    }
    
    
    /**
     * 11、月天翼生活活跃用户
     * 日活趋势
     * 折线图
     * 
     */
    /**
     * 
     * {"msg":"操作成功","resultCode":0,"resultObj":{"currentYear":[11,12,13,14,15,16,17,18,19],"lastYear":[1,2,3,4,5,6,7,8,9],"target":[21,22,23,24,25,26,27,28,29]},"success":true}
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/activeUserDailyTrend")
    @ResponseBody
    public String activeUserDailyTrend(HttpServletResponse response, HttpServletRequest request) {
    	Result result=new Result();
       	result.setMsg("操作成功");
       	result.setResultCode(Constant.SUCCESS);
       	result.setSuccess(true);
        Map map=new HashMap();
        map.put("lastMonth", new Integer[]{1,2,3,4,5,6,7,8,9});
        map.put("currentMonth", new Integer[]{11,12,13,14,15,16,17,18,19});
        result.setResultObj(map);
       	return JSONObject.fromObject(result).toString();
    }
}
