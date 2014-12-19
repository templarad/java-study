package designpattern;

public class Singleton {

	private static Singleton singleton;
	private int count = 1;
	private Singleton(){
		count ++;
	}
	
	public static synchronized Singleton getInstance(){
		if(singleton==null){
			singleton = new Singleton();
		}
		return singleton;
	}
	
	public void showCount(){
		count ++;
		System.out.println("count = "+count);
	}
}
//sync