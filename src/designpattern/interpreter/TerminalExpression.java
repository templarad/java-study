package designpattern.interpreter;

public class TerminalExpression extends AbstractExpression {

	private String token;
	
	public String getToken() {
		return token;
	}
	
	@Override
	public int Interpret(Context context) {
		token = context.getToken();
		context.nextContext();
		return Integer.parseInt(token);
	}

	
}
