package prototype;

public class MessageBox extends absMessage{
	private char decochar;
	
	public MessageBox(char decochar){
		this.decochar=decochar;
	}

	@Override
	public void use(String s) {
		int length = s.getBytes().length;
		for (int i=0;i<length;i++){
			System.out.print(decochar);
		}
		System.out.print("\n"+s+"\n");
		for (int i=0;i<length;i++){
			System.out.print(decochar);
		}
		System.out.print("\n");
	}

}
