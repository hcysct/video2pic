package com.demo.video2pic.test;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Test {
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
		boolean transfer = Test.transfer(inFile, outFile,"0");
		System.out.print(transfer);
	}
	

}
