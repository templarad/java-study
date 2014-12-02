package designpattern.command;

public class ConcreteCommand extends UndoableCommand{
	private String previousData = null;  
	  
    public ConcreteCommand(Receiver receiver, String expr) {  
        super(receiver, expr);  
    }  
  
    @Override  
    public void execute() {  
        previousData = receiver.getData();  
        receiver.append(this.param);  
    }  
  
    @Override  
    public void undo() {  
        receiver.setData(previousData);  
    }  
}
