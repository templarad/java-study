package designpattern;

public abstract class TemplateMethods {

	public final void foo(){
		before();
		execute();
		after();
	}
	protected void before(){//Annotation
		System.out.println("before");
		//log
	}
	protected abstract void execute();
	protected void after(){
		System.out.println("after");
	}
}
