package bridge;

public class CountDisplay extends Display{
	public CountDisplay(DisplayImp imp){
		super(imp);		
	}
	public void multiDisplay(int times){
		open();
		for(int i=0;i<times;i++){
			print();
		}
		close();
	}
	public void customDisplay(int times){
		for(int i = 0 ; i < times ; i++){
			multiDisplay(i);
		}
	}

}
