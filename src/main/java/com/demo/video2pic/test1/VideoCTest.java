package com.demo.video2pic.test1;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class VideoCTest {
	// 视频缩略图截取
	// inFile 输入文件(包括完整路径)
	// outFile 输出文件(可包括完整路径)
	public static boolean transfer(String inFile, String outFile,String startTime) {
		String command = "ffmpeg -i " + inFile
				+ " -y -f image2 -ss "+startTime+" -t 00:00:01 -s  480x450 "
				+ outFile;
		try {
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(command);
			InputStream stderr = proc.getErrorStream();
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
				System.out.println(line);
		} catch (Throwable t) {
			t.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static void main(String[] arg){
		String inFile ="/home/local/test/test.mp4";
		String outFile ="/home/local/test/test.jpg";
		boolean transfer = VideoCTest.transfer(inFile, outFile,"0");
		System.out.print(transfer);
	}
	
	
	   public boolean executeCodecs(String ffmpegPath, String upFilePath, String codcFilePath,
	            String mediaPicPath) throws Exception {
	        // 创建一个List集合来保存转换视频文件为flv格式的命令
	        List convert = new ArrayList();
	        convert.add(ffmpegPath); // 添加转换工具路径
	        convert.add("-i"); // 添加参数＂-i＂，该参数指定要转换的文件
	        convert.add(upFilePath); // 添加要转换格式的视频文件的路径
	        convert.add("-qscale");     //指定转换的质量
	        convert.add("6");
	        convert.add("-ab");        //设置音频码率
	        convert.add("64");
	        convert.add("-ac");        //设置声道数
	        convert.add("2");
	        convert.add("-ar");        //设置声音的采样频率
	        convert.add("22050");
	        convert.add("-r");        //设置帧频
	        convert.add("24");
	        convert.add("-y"); // 添加参数＂-y＂，该参数指定将覆盖已存在的文件
	        convert.add(codcFilePath);

	        // 创建一个List集合来保存从视频中截取图片的命令
	        List cutpic = new ArrayList();
	        cutpic.add(ffmpegPath);
	        cutpic.add("-i");
	        cutpic.add(upFilePath); // 同上（指定的文件即可以是转换为flv格式之前的文件，也可以是转换的flv文件）
	        cutpic.add("-y");
	        cutpic.add("-f");
	        cutpic.add("image2");
	        cutpic.add("-ss"); // 添加参数＂-ss＂，该参数指定截取的起始时间
	        cutpic.add("17"); // 添加起始时间为第17秒
	        cutpic.add("-t"); // 添加参数＂-t＂，该参数指定持续时间
	        cutpic.add("0.001"); // 添加持续时间为1毫秒
	        cutpic.add("-s"); // 添加参数＂-s＂，该参数指定截取的图片大小
	        cutpic.add("800*280"); // 添加截取的图片大小为350*240
	        cutpic.add(mediaPicPath); // 添加截取的图片的保存路径

	        boolean mark = true;
	        ProcessBuilder builder = new ProcessBuilder();
	        try {
	            builder.command(convert);
	            builder.redirectErrorStream(true);
	            builder.start();
	            
	            builder.command(cutpic);
	            builder.redirectErrorStream(true);
	            // 如果此属性为 true，则任何由通过此对象的 start() 方法启动的后续子进程生成的错误输出都将与标准输出合并，
	            //因此两者均可使用 Process.getInputStream() 方法读取。这使得关联错误消息和相应的输出变得更容易
	            builder.start();
	        } catch (Exception e) {
	            mark = false;
	            System.out.println(e);
	            e.printStackTrace();
	        }
	        return mark;
	    }

}
