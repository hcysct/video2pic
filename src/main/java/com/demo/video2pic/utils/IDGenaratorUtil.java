/**************************************************************************************** 

 ****************************************************************************************/
package com.demo.video2pic.utils;

import java.util.UUID;

/**
 * <Description> UUID工具类.<br> 
 *  
 * @author zhangyuzhu<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年11月27日 <br>
 */
public class IDGenaratorUtil {
    
    /**
     * Description: 生成id.<br> 
     *  
     * @author zhangyuzhu<br>
     * @taskId <br>
     * @return 32位id<br>
     */
    public static String getID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
