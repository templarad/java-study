package designpattern.abstractfactory;

public abstract class AbstractFactory {
    public static AbstractFactory createWizardFactory(){
    	return new WizardFactory();
    }
    public static AbstractFactory createKnightFactory(){
    	return new KnightFactory();
    }

    public abstract Weapon createWeapon();
    public abstract Armor createArmor();

}
