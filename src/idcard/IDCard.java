
package idcard;

import factorypattern.*;
public class IDCard extends Product{
	private String owner;
	private int num;
	IDCard(String owner){
		System.out.print(owner+" is created!");
		this.owner=owner;
	}

	public void use() {
		System.out.print(owner+" use this card.");
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	public String getOwner() {
		return this.owner;
	}
}
