package designpattern.builder;

public class Director {
	private Builder builder;
	public Director(Builder builder){
		this.builder = builder;
	}
	public void construct(){
		builder.makeTitle("Hello world!");
		builder.makeString("This is a example of Builder pattern.");
		builder.makeItems(new String[]{"java","design","pattern"});
		builder.makeString("You can make new items here.");
		builder.makeItems(new String[]{"apple","banana","orange"});
		builder.close();
	}

	public void setBuilder(Builder builder){
		this.builder = builder;
	}
}
