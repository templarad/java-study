package bridge;

public class Display {
	private DisplayImp displayimp;
	public Display(DisplayImp impl){
		this.displayimp=impl;
	}
	public void open(){
		displayimp.rawOpen();
	}
	public void print(){
		displayimp.rawPrint();
	}
	public void close(){
		displayimp.rawClose();
	}
	public final void display(){
		open();
		print();
		close();
	}

}
