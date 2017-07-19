package com.demo.video2pic.ffmpeg;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

/**
 * ffmpeg工具类
 * 
 * @author zyh
 *
 */
public class FFmpegUtil {
	
	private static final Log log = LogFactory.getLog(FFmpegUtil.class);
	public static String FFMPEG_PATH = null;
	public static Properties pros = new Properties();
	static {
		try {
			// 加载配置文件到内存
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config/config.properties"));
			FFMPEG_PATH = pros.getProperty("ffmpeg.path");//从配置文件获取ffmpeg的路径
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

	public static Properties getPros() {
		return pros;
	}

	/**
	 * 视频转图片
	 * @param videoPath
	 */
	public static void videoToPic(String videoPath,String targetFolder,String suffix){
		targetFolder=removeTargetFolderSuffix(targetFolder);//去除目标文件夹末尾的分隔符
		Map<String,String> fileInfo=getVideoTitleFromPath(videoPath);//视频标题 后缀
		String title=fileInfo.get("title");
		if(StringUtils.isEmpty(suffix)){
			suffix="png";
		}
		VideoInfo videoInfo=getVideoInfo(videoPath);//获取视频的信息 时长（秒）、分辨率
		int videoTime=videoInfo.getSeconds();//获取视频的时长秒
        for(int i=1;i<videoTime;i++){//i为初始位置 （秒数） 每秒一张
        	List<String> toPicCmd=new ArrayList<String>();
    		toPicCmd.add(FFMPEG_PATH);
    		toPicCmd.add("-i");
    		toPicCmd.add(videoPath);
    		toPicCmd.add("-y");
    		toPicCmd.add("-f");
    		toPicCmd.add("image2");//图片编码
    		toPicCmd.add("-ss"); // 添加参数＂-ss＂，该参数指定截取的起始时间
    		toPicCmd.add(String.valueOf(i)); // 添加起始时间为第17秒
    		toPicCmd.add("-t"); // 添加参数＂-t＂，该参数指定持续时间
            toPicCmd.add("0.001"); // 添加持续时间为1毫秒
            toPicCmd.add("-s"); // 添加参数＂-s＂，该参数指定截取的图片大小
            toPicCmd.add(videoInfo.getWidth()+"*"+videoInfo.getHeight()); // 添加截取的图片分辨率大小
            StringBuffer targetPath=new StringBuffer();//循环生成的图片地址
            targetPath.append(targetFolder);
            targetPath.append(File.separator);
            targetPath.append(title);
            targetPath.append("_");
            targetPath.append(i);
            targetPath.append(".");
            targetPath.append(suffix);
            toPicCmd.add(targetPath.toString()); // 添加截取的图片的保存路径   全路径 需带有后缀名  png
            ffmpegCmd(toPicCmd);
        	
        }
	}
	/**
	 * 如果文件夹地址最后问分隔符则去除
	 * @param videoPath
	 * @return
	 */
	public static String removeTargetFolderSuffix(String targetFolder){
		if(targetFolder==null) 
			return null;
		int lengthIndex= targetFolder.length()-1;
		if(targetFolder.lastIndexOf('\\')==lengthIndex){
			targetFolder=targetFolder.substring(0,lengthIndex);
		}else if(targetFolder.lastIndexOf('/')==lengthIndex){
			targetFolder=targetFolder.substring(0,lengthIndex);
		}
		return targetFolder;
	}

	
	/**
	 * 获取视频内容
	 * @param videoPath
	 *            视频地址- 绝对路径
	 * @return
	 */
	public static VideoInfo getVideoInfo(String videoPath) {
		VideoInfo videoInfo=new VideoInfo();
		List<String> infocmd=new ArrayList<String>();
		infocmd.add(FFMPEG_PATH);
		infocmd.add("-i");
		infocmd.add(videoPath);
		log.info(infocmd.toString());
		String result= ffmpegCmd(infocmd);
		
		PatternCompiler compiler =new Perl5Compiler();  
		String regexDuration ="Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s";  
		String regexVideo ="Video: (.*?), (.*?), (.*?)[,\\s]";  
		try {
			Pattern patternDuration = compiler.compile(regexDuration,Perl5Compiler.CASE_INSENSITIVE_MASK);
			PatternMatcher matcherDuration = new Perl5Matcher();  
		        if(matcherDuration.contains(result, patternDuration)){  
		            MatchResult re = matcherDuration.getMatch();  
		            System.out.println("提取出播放时间 ===" +re.group(1));  
		            int time = getTimelen(re.group(1)); 
		            System.out.println("提取出播放秒数 ===" +time);  
		            videoInfo.setSeconds(time);
		        }  
		} catch (MalformedPatternException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}  catch(Exception ex){
			ex.printStackTrace();
			log.error(ex.getMessage());
		}
       
		try {
			Pattern patternVideo = compiler.compile(regexVideo,Perl5Compiler.CASE_INSENSITIVE_MASK);
			  PatternMatcher matcherVideo = new Perl5Matcher();  
		        if(matcherVideo.contains(result, patternVideo)){  
		            MatchResult re = matcherVideo.getMatch();  
		            String fbl=re.group(3);
		            System.out.println(" 分辨率  == =" +re.group(3));  
		            String strs[] = fbl.split("x");  
		            int width=Integer.parseInt(strs[0]);
		            System.out.println("宽度："+width);
		            videoInfo.setWidth(width);
		            int height=Integer.parseInt(strs[1]);
		            videoInfo.setHeight(height);
		            System.out.println("高度："+height);
		        }  
		} catch (MalformedPatternException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}  catch(Exception ex){
			ex.printStackTrace();
			log.error(ex.getMessage());
		}

		return videoInfo;
	}
	/**
	 * 从文件路径中获取文件名称
	 * @param videoPath
	 * @return
	 */
	public static Map<String,String> getVideoTitleFromPath(String videoPath){
		Map<String,String> map=new HashMap<String,String>();
		if(videoPath.lastIndexOf('\\')>0){
			String title=videoPath.substring(videoPath.lastIndexOf('\\')+1, videoPath.lastIndexOf('.'));
			String suffix=videoPath.substring(videoPath.lastIndexOf('.')+1);
			System.out.println(title);
			map.put("title", title);
			map.put("suffix", suffix);
		}else if(videoPath.lastIndexOf('/')>0){
			String title=videoPath.substring(videoPath.lastIndexOf('/')+1, videoPath.lastIndexOf('.'));
			String suffix=videoPath.substring(videoPath.lastIndexOf('.')+1);
			System.out.println(title);
			map.put("title", title);
			map.put("suffix",suffix);
		}
		return map;
	}
	
	/**
	 * 执行cmd命令 返回结果集字符串
	 * @param cmd
	 * @return
	 */
	public static String ffmpegCmd(List<String> cmd){
		ProcessBuilder builder = new ProcessBuilder();
		try {
			builder.command(cmd);
			builder.redirectErrorStream(true);
			Process p = builder.start();
			// 执行命令
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line);
				log.info(line);
			}
			log.info(sb.toString());
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex.getMessage());
		}
		return null;
	}
	//格式:"00:00:10.68"  
    private static int getTimelen(String timelen){  
        int min=0;  
        String strs[] = timelen.split(":");  
        if (strs[0].compareTo("0") > 0) {  
            min+=Integer.valueOf(strs[0])*60*60;//秒  
        }  
        if(strs[1].compareTo("0")>0){  
            min+=Integer.valueOf(strs[1])*60;  
        }  
        if(strs[2].compareTo("0")>0){  
            min+=Math.floor(Float.valueOf(strs[2]));  
        }  
        return min;  
    }  
}
