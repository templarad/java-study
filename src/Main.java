import idcard.IDCardFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import mediator.LoginFrame;
import prototype.MessageBox;
import prototype.Product;
import prototype.UnderlinePen;
import state.SafeFrame;
import strategy.Hand;
import strategy.Player;
import strategy.RandomStrategy;
import strategy.WinningStrategy;
import adapterpattern.FileIO;
import adapterpattern.FileProperties;
import bridge.CountDisplay;
import bridge.StringDisplayImp;
import designpattern.Singleton;
import designpattern.TemplateMethodImplA;
import designpattern.TemplateMethodImplB;
import designpattern.Iterator.IDcard;
import designpattern.Iterator.IDcards;
import designpattern.Iterator.Iterator;
import designpattern.abstractfactory.Machine;
import designpattern.builder.TestBuilder;
import designpattern.command.Command;
import designpattern.command.CommandManager;
import designpattern.command.ConcreteCommand;
import designpattern.command.Receiver;
import designpattern.facade.Facade;
import designpattern.observer.Observer;
import designpattern.observer.State;
import designpattern.observer.Subject;
import designpattern.prototype.Prototype;
import factorypattern.Factory;;

/**
 * Design Pattern test class.
 * <p>
 */
@SuppressWarnings("unused")
public class Main {
	public int count = 0;

	public void calc(int n, int p) {
		count++;
		if (p > n)
			return;
		for (int i = 0; i < n; i++) {
			calc(n, p + 1);
		}
	}

	public static void main(String[] args) {
//		 (new Facade()).makepeople("");
		 iterator();
		//observer();
		 //command();
		// builder();
		// singleton();
		// templatemethods();
		// TestIterator tt = new TestIterator();
		// tt.run();
		// mediator();
		// strategy();
		// bridge();
		//prototype2();
		//abstractFactory();
	}
	private static void lambda(){
		Optional<String> hogeOpt = Optional.ofNullable(getHoge()); // 値をラップする
		hogeOpt.ifPresent(System.out :: println);
		hogeOpt.map(String :: length)
				.ifPresent(aa -> {System.out.println(aa);
				System.out.println(aa);});
		Collections.sort(Arrays.asList(Collections.class.getMethods()), 
				(a,b) -> 
					{
						return a.getName().compareTo(b.getName());
					});
	}
	private static void iterator() {
		//Data set
		IDcard carda = new IDcard();
		carda.setColor("green");
		carda.setId(1);
		IDcard cardb = new IDcard();
		cardb.setColor("blue");
		cardb.setId(2);
		IDcard cardc = new IDcard();
		cardc.setColor("yellow");
		cardc.setId(3);
		IDcard cardd = new IDcard();
		cardd.setColor("red");
		cardd.setId(4);
		//Add to list
		IDcards cards = new IDcards();
		cards.addItem(carda);
		cards.addItem(cardb);
		cards.addItem(cardc);
		cards.addItem(cardd);
		// ここまでは準備...
		// ここからはパターンの使用
		Iterator it = cards.iterator();
		while (it.hasNext()) {
			IDcard card = (IDcard) it.next();
			System.out.println("ID :" + card.getId());
			System.out.println("Color :" + card.getColor());
		}
	}

	public static void abstractFactory(){
		Machine game = new Machine();
		game.createCharacter();
	}
	/**
	 * Observer pattern
	 */
	public static void observer() {
		Subject subject = new Subject();
		Observer observer = new Observer(subject);
		subject.addObserver(observer);

		subject.setState(State.START);
		subject.setState(State.END);
	}

	/**
	 * Singleton pattern
	 */
	public static void singleton() {
		Singleton singleton = Singleton.getInstance();
		singleton.showCount();
		Singleton singleton2 = Singleton.getInstance();
		singleton2.showCount();
	}
	
	/**
	 * Template method pattern
	 */
	public static void templatemethods() {
		TemplateMethodImplA tmp = new TemplateMethodImplA();
		TemplateMethodImplB tmpb = new TemplateMethodImplB();
		System.out.println("templateA:");
		tmp.foo();
		System.out.println("");
		System.out.println("templateB:");
		tmpb.foo();

	}

	/**
	 * Builder pattern
	 */
	public static void builder() {
		TestBuilder testbuilder = new TestBuilder();
	}

	/**
	 * Command pattern
	 * 
	 */
	public static void command() {
		CommandManager commandMgr = new CommandManager();
		Receiver receiver = new Receiver();

		System.out.println("--- execute command ---");
		Command commandAaa = new ConcreteCommand(receiver, "aaa");
		commandMgr.executeCommand(commandAaa);

		Command commandBbb = new ConcreteCommand(receiver, "bbb");
		commandMgr.executeCommand(commandBbb);

		Command commandCcc = new ConcreteCommand(receiver, "ccc");
		commandMgr.executeCommand(commandCcc);

		Command commandDdd = new ConcreteCommand(receiver, "ddd");
		commandMgr.executeCommand(commandDdd);

		System.out.println(receiver.getData());

		System.out.println("-- undo ---");
		commandMgr.undoCommand();
		commandMgr.undoCommand();
		System.out.println(receiver.getData());
	}

	/**
	 * Strategy pattern
	 * <p>
	 */
	public static void strategy() {
		Date date = new Date();
		@SuppressWarnings("deprecation")
		int seed = date.getSeconds();
		Player player1 = new Player("Taofeng", new RandomStrategy(seed));
		Player player2 = new Player("Di Ai", new WinningStrategy(seed * 2));
		for (int i = 0; i < 1000; i++) {
			Hand nextHand1 = player1.nextHand();
			Hand nextHand2 = player2.nextHand();
			if (nextHand1.isStrongThan(nextHand2)) {
				System.out.println("Winner: " + player1);
				player1.win();
				player2.lose();
			} else if (nextHand1.isWeakerThan(nextHand2)) {
				System.out.println("Winner: " + player2);
				player1.lose();
				player2.win();
			} else {
				System.out.println("Even...");
				player1.even();
				player2.even();
			}
		}
		System.out.println("Totle result: ");
		System.out.println(player1.toString());
		System.out.println(player2.toString());
	}

	/**
	 * Bridge pattern
	 * <p>
	 */
	public static void bridge() {
		StringDisplayImp sdi = new StringDisplayImp("<", "*", ">");
		CountDisplay cd = new CountDisplay(sdi);
		cd.customDisplay(3);
	}

	public static void prototype() {
		MessageBox a = new MessageBox('t');
		UnderlinePen udp = new UnderlinePen('-');
		Product b = a.createClone();
		a.use("message box");
		b.use("clone box");
		MessageBox x = new MessageBox('y');
		Product y = x.createClone();
		Product udp2 = udp.createClone();
		y.use("clone box from y");
		udp2.use("clone under line");
	}

	public void adapterpattern() {
		FileIO f = new FileProperties();
		try {
			f.readFromFile("file.txt");
			f.setValue("year", "2004");
			f.setValue("month", "4");
			f.setValue("day", "21");
			f.writeToFile("newfile.txt");
			System.out.print("ok");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Factory pattern
	 * <p>
	 */
	 public static void test(String[] args){
	 Factory factory = new IDCardFactory();//ここを切り替えるだけて，下は全部抽象クラスのメソッドを使う
	 factorypattern.Product card1 = factory.create("ad");
	 factorypattern.Product card2 = factory.create("lj");
	 factorypattern.Product card3 = factory.create("jjj");
	 card1.use();
	 card2.use();
	 card3.use();
	 ((IDCardFactory)factory).printlist();
	 Object o = new Object();
	
	 }
	/**
	 * 文字列結合.
	 * <p>
	 * 2つの文字列を結合する。<br>
	 * ただしnullの場合は空文字列として扱う。
	 * </p>
	 * 
	 * @param str1
	 *            文字列（null可）
	 * @param str2
	 *            文字列（null可）
	 * @return 結合した文字列（必ずnull以外）
	 */
	public void javadoc() {

	}

	public static void mediator() {
		new LoginFrame("Sample");
	}

	public static void state() {
		SafeFrame frame = new SafeFrame("Sample");
		while (true) {
			for (int hour = 0; hour < 24; hour++) {
				frame.setClock(hour);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
	
	public static void prototype2() {
		Prototype a = new Prototype();
		Prototype b = a.createClone();
		a.setName("ok");
		a.setAge(88);
		System.out.println("----a----");
		System.out.println(a.getName());
		System.out.println(a.getAge());
		System.out.println("----b----");
		System.out.println(b.getName());
		System.out.println(b.getAge());
	}
	private static String getHoge(){
		return "aa";
	}
	
}
