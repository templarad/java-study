package designpattern.facade;

public class Facade {

	public void makepeople(String feeling){
		(new ClassA(feeling)).head();
		(new ClassB()).body();
		(new ClassC()).foot();
	}
}
