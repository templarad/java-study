package designpattern.command;

public abstract class UndoableCommand extends Command{
	public UndoableCommand(Receiver receiver, String expr) {  
        super(receiver, expr);  
    }  
  
    abstract public void undo(); 
}
