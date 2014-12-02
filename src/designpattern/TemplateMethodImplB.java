package designpattern;

public class TemplateMethodImplB extends TemplateMethods{

	@Override
	protected void before() {
		System.out.println("-----------");
	}

	@Override
	protected void execute() {
		System.out.println("Hello world");		
	}

	@Override
	protected void after() {
		System.out.println("===========");		
	}

}
