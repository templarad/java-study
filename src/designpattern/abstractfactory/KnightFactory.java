package designpattern.abstractfactory;

public class KnightFactory extends AbstractFactory {

	@Override
	public Weapon createWeapon() {
		return new Weapon("剣", 70);
	}

	@Override
	public Armor createArmor() {
		return new Armor("騎士鎧", 60);
	}

}
