package Turtle;
public class HTurtle extends Turtle{
	public void polygon(int n,int s)
	{
		int a = 360/n;
		for(int j=0;j<n;j++)
		{
			fd(s);
			rt(a);
		}
	}
	public void house(int s){
		polygon(4,s);
		fd(s);
		rt(30);
		polygon(3,s);
		lt(30);bk(s);		
	}
}//Turtle拡張する