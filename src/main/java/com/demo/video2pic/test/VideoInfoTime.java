package com.demo.video2pic.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;


public class VideoInfoTime {
	public static void main(String[] args) {  
		  
	    String result =    processFLV("d:\\test\\gee.mp4");  
	     
	     
	    PatternCompiler compiler =new Perl5Compiler();  
	    try {  
	        String regexDuration ="Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s";  
	        String regexVideo ="Video: (.*?), (.*?), (.*?)[,\\s]";  
	        String regexAudio ="Audio: (\\w*), (\\d*) Hz";  
	     
	        Pattern patternDuration = compiler.compile(regexDuration,Perl5Compiler.CASE_INSENSITIVE_MASK);  
	        PatternMatcher matcherDuration = new Perl5Matcher();  
	        if(matcherDuration.contains(result, patternDuration)){  
	            MatchResult re = matcherDuration.getMatch();  
	  
	            System.out.println("提取出播放时间  ===" +re.group(1));  
	            System.out.println("开始时间        =====" +re.group(2));  
	            System.out.println("bitrate 码率 单位 kb==" +re.group(3));  
	        }  
	         
	        Pattern patternVideo = compiler.compile(regexVideo,Perl5Compiler.CASE_INSENSITIVE_MASK);  
	        PatternMatcher matcherVideo = new Perl5Matcher();  
	         
	        if(matcherVideo.contains(result, patternVideo)){  
	            MatchResult re = matcherVideo.getMatch();  
	            System.out.println("编码格式  ===" +re.group(1));  
	            System.out.println("视频格式 ===" +re.group(2));  
	            System.out.println(" 分辨率  == =" +re.group(3));  
	        }  
	         
	        Pattern patternAudio = compiler.compile(regexAudio,Perl5Compiler.CASE_INSENSITIVE_MASK);  
	        PatternMatcher matcherAudio = new Perl5Matcher();  
	         
	        if(matcherAudio.contains(result, patternAudio)){  
	            MatchResult re = matcherAudio.getMatch();  
	            System.out.println("音频编码             ===" +re.group(1));  
	            System.out.println("音频采样频率  ===" +re.group(2));  
	        }  
	  
	    } catch (MalformedPatternException e) {  
	        e.printStackTrace();  
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
	  
	    }  
	     
	  
	//  ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）  
	    private static String processFLV(String inputPath) {  
	/* 
	      if (!checkfile(inputPath)){ 
	          _log.warn(inputPath+" is not file"); 
	          return false; 
	         } 
	*/  
	        List<String> commend=new java.util.ArrayList<String>();  
	         
//	        commend.add("e:\\videoconver\\ffmpeg\\ffmpeg ");//可以设置环境变量从而省去这行  
	       commend.add("ffmpeg");  
	        commend.add("-i");  
	        commend.add(inputPath);  
	        
	        try {  
	  
	            ProcessBuilder builder = new ProcessBuilder();  
	            builder.command(commend);  
	            builder.redirectErrorStream(true);  
	            Process p= builder.start();  
	  
	           //1. start  
	            BufferedReader buf = null; // 保存ffmpeg的输出结果流  
	            String line = null;  
	          //read the standard output  
	  
	            buf = new BufferedReader(new InputStreamReader(p.getInputStream()));  
	             
	            StringBuffer sb= new StringBuffer();  
	            while ((line = buf.readLine()) != null) {  
	             System.out.println(line);  
	             sb.append(line);  
	             continue;  
	                 }  
	            int ret = p.waitFor();//这里线程阻塞，将等待外部转换进程运行成功运行结束后，才往下执行  
	            //1. end  
	            return sb.toString();  
	        } catch (Exception e) {  
//	            System.out.println(e);  
	            return null;  
	        }  
	    }  
}
