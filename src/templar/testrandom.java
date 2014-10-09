package templar;
import java.io.*;
import java.util.Random;

public class testrandom {
	
	public testrandom(){
		Random random = new Random(System.currentTimeMillis());
		int tempname =Math.abs(random.nextInt())%1000;
		String kk=String.valueOf(tempname);
	System.out.println(kk);
	
	
	}
	public static void main(String[] args){
		testrandom aa=new testrandom();
	}
}
