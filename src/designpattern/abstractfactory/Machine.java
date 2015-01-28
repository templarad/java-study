package designpattern.abstractfactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Machine {

	public Machine(){
		
	}
	public void createCharacter(){
		List<AbstractFactory> factorys = new ArrayList<AbstractFactory>();
        factorys.add(AbstractFactory.createWizardFactory());//ウィザードを作成
        factorys.add(AbstractFactory.createKnightFactory());//騎士を作成
        Iterator<AbstractFactory> it = factorys.iterator();
        while (it.hasNext()){
        	AbstractFactory factory = it.next();
        	Armor armor = factory.createArmor();
        	Weapon weapon = factory.createWeapon();
        	System.out.println("キャラのジョブは："+factory.getClass().getSimpleName());
        	System.out.println("武器:"+weapon.getName()+", 攻撃力："+weapon.getDamage());
        	System.out.println("防具:"+armor.getName()+", 防御力:"+armor.getDefense());
        	System.out.println("");
        }
	}
	
	
}
