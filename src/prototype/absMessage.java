package prototype;

public abstract class absMessage implements Product{
	@Override
	public Product createClone() {
		Product p = null;
		try {
			p= (Product)clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

}
