package designpattern.interpreter;

public class Client {
    public static void main(String[] args) {
        String sourse = "<+> 10 <+> 1 4 8 5 1 <+> 1 7 </+> 1 </+> 10 1 </+>";
        Context context = new Context(sourse);
        AbstractExpression expression = new NonterminalExpression();
        System.out.println(expression.Interpret(context));
        System.out.println(expression.toString());
    }
}