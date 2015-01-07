package designpattern.prototype;

public class Prototype implements Cloneable {

	private String name;
	private int age;

	public Prototype(){
		setName("fun");
		setAge(18);
	}
	public Prototype createClone() {
		Prototype prototype = new Prototype();
		try {
			prototype=(Prototype)clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prototype;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
