package templar;
import Turtle.*;
import java.io.*;
import java.awt.Color;
public class Unit2{
	void kill(){
	}
	void kill(char a){
		System.out.println(a);
		}

	void dataInOut() throws IOException{//キーボードからインポート
		String k;
		BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
		k="";
		k=din.readLine();
		while(k.length()!=0){
			System.out.println(k);
			k=din.readLine();
			}
		char a;
		a=k.charAt(0);
		kill(a);
		System.out.println(k);
		System.out.println("k=1:"+(k==null));
		din.close();
	}
	public static void main(String[] args) {//main関数
		Unit2 test= new Unit2();
		try {
			test.dataInOut();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IO error");
			}catch (StringIndexOutOfBoundsException e){
			System.out.println("k==null");
			}		
	TurtleFrame f;
	f=new TurtleFrame();
	Turtle m=new Turtle();
	Turtle m1= new Turtle();
	Turtle [] tt=new Turtle[10]; 

	for(int i=0;i<10;i++){
		tt[i]=new Turtle(i*50+25,100,0);
		f.add(tt[i]);		
	}
	
	for(int i=0;i<10;i++){
		tt[i].rt(180);
		tt[i].fd(100);
	}
	f.add(m);
	f.add(m1);
	m1.setColor(Color.red);
	m.fd(100);
	m1.rt(90);
	m1.fd(50);
	double r=30*(2*Math.PI/360);//30°求sin
	r= Math.sin(r);
	System.out.println(r);
}
}
