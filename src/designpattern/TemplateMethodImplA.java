package designpattern;

public class TemplateMethodImplA extends TemplateMethods{

	@Override
	protected void before() {
		System.out.println("before");
		
	}

	@Override
	protected void execute() {
		System.out.println("start");
		
	}

	@Override
	protected void after() {
		System.out.println("after");
		
	}

}
