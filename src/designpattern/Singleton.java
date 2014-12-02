package designpattern;

public class Singleton {

	private static Singleton singleton = new Singleton();
	private int count = 1;
	private Singleton(){
		count ++;
	}
	
	public static Singleton getInstance(){
		return singleton;
	}
	
	public void showCount(){
		System.out.println("count = "+count);
	}
}
