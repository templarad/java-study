package designpattern.builder;

public class TestBuilder {

	public TestBuilder(){
		TextBuilder textbuilder = new TextBuilder();
		Director director = new Director(textbuilder);
		director.construct();
		System.out.println(textbuilder.getResult());
		HTMLBuilder htmlbuilder = new HTMLBuilder();
		director.setBuilder(htmlbuilder);
		director.construct();
		System.out.println(textbuilder.getResult());
	}
}
