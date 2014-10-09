package templar;

import java.io.*;


public class ExEncode{

	static String f = "E:/apache-tomcat-7.0.27-windows-x64/531.html";
	static String temporary = "E:/apache-tomcat-7.0.27-windows-x64/outtest.html";
	
	public static void main(String[] args)
	{
		try{
			//ファイル準備
			System.out.println("a");
			FileInputStream inFile = new FileInputStream(f);
			System.out.println("b");
			FileOutputStream outFile = new FileOutputStream(temporary);
			System.out.println("c");

			System.out.println("1");
			InputStreamReader in = new InputStreamReader(inFile,"UTF-16");
			System.out.println(in.getEncoding());
			System.out.println("2");
			OutputStreamWriter out = new OutputStreamWriter(outFile,"UTF-8");
			System.out.println("3");			
			int s;
			while((s = in.read()) != -1){
				//SAM.txtに書き込み
				out.write(s);
			}
			//ファイルを閉じる
			in.close();
			out.close();
		}catch(IOException e){
			System.out.println("IO error");
		}
	}
}