package designpattern.abstractfactory;

public class Weapon {
	private String name;
	private int damage;
	
	public Weapon(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
