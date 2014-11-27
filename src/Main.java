//import factorypattern.*;
//import idcard.*;
import iterator.TestIterator;

import java.io.IOException;
import java.util.Date;

import designpattern.builder.TestBuilder;
import mediator.LoginFrame;
import adapterpattern.FileIO;
import adapterpattern.FileProperties;
import bridge.CountDisplay;
import bridge.StringDisplayImp;
import prototype.*;
import state.SafeFrame;
import strategy.*;
/**
 * Design Pattern test class.
 * <p>
 */
public class Main {
	public int count = 0;
	public void calc(int n, int p) {
		count++;
			if (p>n) return;
			for (int i=0; i<n; i++) {
				calc(n, p+1);
			}
		}


	public static void main(String[] args){

		TestBuilder testbuilder = new TestBuilder();
//		TestIterator tt = new TestIterator();
//		tt.run();
		//mediator();
		//strategy();
		//bridge();
	}
	/**
	 * Strategy pattern
	 * <p>
	 */
	public static void strategy(){
		Date date = new Date();
		@SuppressWarnings("deprecation")
		int seed= date.getSeconds();
		Player player1 = new Player("Taofeng", new RandomStrategy(seed));
		Player player2 = new Player("Di Ai", new WinningStrategy(seed*2));
		for(int i=0;i<1000;i++){
			Hand nextHand1 = player1.nextHand();
			Hand nextHand2 = player2.nextHand();
			if(nextHand1.isStrongThan(nextHand2)){
				System.out.println("Winner: "+player1);
				player1.win();
				player2.lose();
			}else if(nextHand1.isWeakerThan(nextHand2)){
				System.out.println("Winner: "+player2);
				player1.lose();
				player2.win();
			}else{
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
	public static void bridge(){
		StringDisplayImp sdi = new StringDisplayImp("<","*",">");
		CountDisplay cd = new CountDisplay(sdi);
		cd.customDisplay(3);
	}
	
	public void prototype(){
		MessageBox a=new MessageBox('t');
		UnderlinePen udp = new UnderlinePen('-');
		Product b = a.createClone();
		b.use("test");
		MessageBox y=new MessageBox('y');
		Product yy = y.createClone();
		Product udp2 = udp.createClone();
		yy.use("fuck");
		udp2.use("under");
	}
	
	public void adapterpattern(){
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
//	public static void test(String[] args){
//		Factory factory = new IDCardFactory();//ここを切り替えるだけて，下は全部抽象クラスのメソッドを使う
//		Product card1 = factory.create("ad");
//		Product card2 = factory.create("lj");
//		Product card3 = factory.create("jjj");
//		card1.use();
//		card2.use();
//		card3.use();
//		((IDCardFactory)factory).printlist();
//		Object o = new Object();
//		
//	}
	/**
	 * 文字列結合.
	 * <p>
	 * 2つの文字列を結合する。<br>
	 * ただしnullの場合は空文字列として扱う。
	 * </p>
	 * 
	 * @param str1 文字列（null可）
	 * @param str2 文字列（null可）
	 * @return 結合した文字列（必ずnull以外）
	 */
	public void javadoc(){
		
	}
	
	public static void mediator(){
		new LoginFrame("Sample");
	}
	
	public static void state(){
		SafeFrame frame = new SafeFrame("Sample");
		while(true){
			for(int hour = 0; hour<24;hour++){
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
}
