package prototype;

public class UnderlinePen extends absMessage{
	private char decochar;
	
	public UnderlinePen(char ulchar){
		this.decochar=ulchar;
	}
	@Override
	public void use(String s) {
		int length = s.getBytes().length;
		System.out.print(s+"\n");
		for (int i=0;i<length;i++){
			System.out.print(decochar);
		}
		
	}

}
