package designpattern.facade;

public class ClassA {
	private String feeling;
	public ClassA(String param){
		this.feeling = param;
	}
	public void head(){//param
		if(feeling.equals("angry")){
			System.out.println(" (*~*)");	
		} else if (feeling.equals("happy")) {
			System.out.println(" (*w*)");
		} else if (feeling.equals("sleepy")) {
			System.out.println(" (-_-)");
		} else {
			System.out.println(" (→_→)?");
		}
		
	}
}
