package designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class Prototype implements Cloneable {

	private String name;
	private int age;
	public List<String> alist;
	
	public Prototype(){
		setName("fun");
		setAge(18);
		alist = new ArrayList<String>();
		alist.add("new name");
	}
	public Prototype createClone() {
		Prototype prototype;
		try {
			prototype=(Prototype)clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			prototype = new Prototype();
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
	
	public List<String> getAlist(){
		return alist;
	}
	public void setAlist(List<String> newlist){
		this.alist = newlist;
		
	}
}
