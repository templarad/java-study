package designpattern.interpreter;

import java.util.ArrayList;
import java.util.List;

public class NonterminalExpression extends AbstractExpression {

	private String startMark = "<+>";
	private String endMark = "</+>";
	int result;
	private List<AbstractExpression> list = new ArrayList<AbstractExpression>();
	@Override
	public int Interpret(Context context) {
		
		AbstractExpression expression;
		context.nextContext();
		while(context.hasNext()){
			if(context.getToken().equals(startMark)){
				expression = new NonterminalExpression();
				
			} else if (context.getToken().equals(endMark)){
				context.nextContext();
				break;
			} else {
				expression = new TerminalExpression();
			}
			result += expression.Interpret(context);
			list.add(expression);
		}
		return result;
	}

	public String toString(){
		
		return "+" + list.toString();
		
	}
}
