package templar;
import Turtle.*;



public class unit1 {

	public static void main(String[] args) {//main関数
	TurtleFrame f = new TurtleFrame();
	Turtle m;
	if(args.length>0)
		m=new HTurtle();
	else
		m=new Turtle();
	f.add(m);
	m.fd(100);
	m.rt(36);
	turtleStar(m);
	}
	
	static void turtleStar(Turtle t){
		for(int i=0;i<5;i++){
			t.fd(100);t.rt(144);
		}
	}
	
}
