package gc;

public class GCtestModel {
	private String a = "------------START------------¥n";
	private String b = "-------GAME-------HELP-------¥n";
	private String c = "-----------CONTINUE----------¥n";
	private String d = "-------------END-------------¥n";
	private String e = "------------CREDIT-----------¥n";
	private String f = "------------OPTION-----------¥n";
	private String g = "------------ABOUT------------¥n";
	
	GCtestModel(String input){
		a = input;
	}

	public String getA(){
		return this.a;
	}
	
	public void printf(){
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
	}
}
