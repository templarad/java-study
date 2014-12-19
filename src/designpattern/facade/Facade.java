package designpattern.facade;

public class Facade {

	public void makepeople(){
		(new ClassA()).head();
		(new ClassB()).body();
		(new ClassC()).foot();
	}
}
