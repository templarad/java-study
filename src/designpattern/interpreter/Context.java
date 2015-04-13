package designpattern.interpreter;

import java.util.StringTokenizer;

public class Context {
	private StringTokenizer tokens;
	public String getToken() {
		return curContext;
	}

	private String curContext;
	public Context(String sourse) {
		tokens = new StringTokenizer(sourse);

	}

	public void nextContext(){
		if(hasNext()){
			curContext = tokens.nextToken();
		}
		
	}
	
	public boolean hasNext(){
		if(tokens.hasMoreElements()){
			return true;
		} else {
			return false;
		}
		
	}
}
