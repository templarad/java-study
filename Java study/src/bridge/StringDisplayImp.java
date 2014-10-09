package bridge;

public class StringDisplayImp extends DisplayImp{
	private String startStr;
	private String str;
	private String endStr;

	public StringDisplayImp(String start,String string,String end){
		this.startStr=start;
		this.str=string;
		this.endStr=end;
	}
	@Override
	public void rawOpen() {
		System.out.print("\n"+startStr);
	}

	@Override
	public void rawPrint() {
		System.out.print(str);
	}

	@Override
	public void rawClose() {
		System.out.print(endStr);
	}

}
