package designpattern.abstractfactory;

public class WizardFactory extends AbstractFactory {

	@Override
	public Weapon createWeapon() {
		return new Weapon("杖", 100);
	}

	@Override
	public Armor createArmor() {
		return new Armor("マント", 20);
	}

}
