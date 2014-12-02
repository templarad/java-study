package designpattern;

public abstract class TemplateMethods {

	public final void foo(){
		before();
		execute();
		after();
	}
	protected abstract void before();
	protected abstract void execute();
	protected abstract void after();
}
