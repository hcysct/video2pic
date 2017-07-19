/**************************************************************************************** 

 ****************************************************************************************/
package com.demo.video2pic.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

/** 
 * <Description> 日期工具类<br> 
 *  
 * @author zhangyuzhu<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年2月25日 <br>
 */

public class DateUtil {
    
    /**
     * SimpleDateFormat yyyyMMdd
     */
    private static DateFormat format = new SimpleDateFormat("yyyyMMdd");
    
    /**
     * SimpleDateFormat yyyy-MM-dd
     */
    private static DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
    
    /**
     * SimpleDateFormat d
     */
    private static DateFormat format3 = new SimpleDateFormat("d");
    
    /**
     * Description: 获取当前年份<br> 
     *  
     * @author zhangyuzhu<br>
     * @taskId <br>
     * @return 当前年份<br>
     */
    public static String getCurYear() {
        String curDay = format.format(new Date());
        return curDay.substring(0, 4);
    }
    
    /**
     * Description: 获取当前月份<br> 
     *  
     * @author zhangyuzhu<br>
     * @taskId <br>
     * @return 当前月份<br>
     */
    public static String getCurMonth() {
        String curDay = format.format(new Date());
        return curDay.substring(0, 6);
    }
    
    /**
     * Description: 仅获取当前月份值<br> 
     *  
     * @author zhangyuzhu<br>
     * @taskId <br>
     * @return int<br>
     */
    public static int getMonthInteger() {
        String curDay = format.format(new Date());
        return Integer.valueOf(curDay.substring(4, 6));
    }
    
    /**
     * Description: 获取当前日期<br> 
     *  
     * @author zhangyuzhu<br>
     * @taskId <br>
     * @return 当前日期<br>
     */
    public static String getCurDay() {
        String curDay = format.format(new Date());
        return curDay;
    }
    
    /**
     * Description: 获取当前日期往前推30天的日期<br> 
     *  
     * @author zhangyuzhu<br>
     * @taskId <br>
     * @return <br>
     */
    public static String getBeginDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_YEAR, -30);
        return format2.format(c.getTime());
    }
    
    /**
     * Description: 获取从30天之前到昨天的日期列表，格式如：['1','2','3','4'...]<br> 
     *  
     * @author zhangyuzhu<br>
     * @taskId <br>
     * @return <br>
     */
    public static String[] getSimpleDateArray() {
        Calendar c = Calendar.getInstance();
        
        String[] dateArray = new String[30];
        int preNum = -30;
        for (int i = 0; i < 30; i++) {
            c.setTime(new Date());
            c.add(Calendar.DAY_OF_YEAR, preNum + i);
            dateArray[i] = format3.format(c.getTime());
        }
        return dateArray;
    }
    
    /**
     * Description: <br> 
     *  
     * @author zhangyuzhu<br>
     * @taskId <br>
     * @return <br>
     */
    public static JSONArray getSimpleDateJsonArray() {
        Calendar c = Calendar.getInstance();
        
        JSONArray dateArray = new JSONArray();
        int preNum = -30;
        for (int i = 0; i < 30; i++) {
            c.setTime(new Date());
            c.add(Calendar.DAY_OF_YEAR, preNum + i);
            dateArray.add(format3.format(c.getTime()));
        }
        return dateArray;
    }
    
    /**
     * Description: 获取从30天之前到昨天的日期列表，格式如：['2016-10-01','2016-10-02','2016-10-03','2016-10-04'...]<br> 
     *  
     * @author zhangyuzhu<br>
     * @taskId <br>
     * @return <br>
     */
    public static String[] getDateArray() {
        Calendar c = Calendar.getInstance();
        
        String[] dateArray = new String[30];
        int preNum = -30;
        for (int i = 0; i < 30; i++) {
            c.setTime(new Date());
            c.add(Calendar.DAY_OF_YEAR, preNum + i);
            dateArray[i] = format2.format(c.getTime());
        }
        return dateArray;
    }
    
    public static void main(String[] args) {
        String beginDate = getBeginDate();
        System.out.println(beginDate);
        System.out.println(Arrays.toString(getSimpleDateArray()));
        System.out.println(getSimpleDateJsonArray().toString());
        System.out.println(Arrays.toString(getDateArray()));
    }
    
    /**
     * Description: 获取前一天<br> 
     *  
     * @author zhangyuzhu<br>
     * @taskId <br>
     * @return 前一天的日期<br>
     */
    public static String getPreviousDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天
        Date date = calendar.getTime();
        
        return format.format(date);
    }
    
    /**
     * Description: 截止到当前日期的每个月的最后一天及当前日期的前一天<br> 
     *  
     * @author zhangyuzhu<br>
     * @taskId <br>
     * @return String[]<br>
     */
    public static List<String> getLastDay4Months(String year) {
        if ("2016".equals(year)) {
            String[] str1 = {"20160131","20160229","20160331","20160430","20160531","20160630",
                    "20160731","20160831","20160930","20161031","20161130","20161231"};
            List<String> list_2016 = new ArrayList<String>();
            for (int i = 0; i < str1.length; i++) {
                list_2016.add(str1[i]);
            }
            return list_2016;
        } else {
            String[] str2 = {"20170131","20170228","20170331","20170430","20170531","20170630",
                    "20170731","20170831","20170930","20171031","20171130","20171231"};
            List<String> list_2017 = new ArrayList<String>();
            
            for (int i = 0; i < str2.length; i++) {
                list_2017.add(str2[i]);
            }
            return list_2017;
        }
        
    }
    
}
