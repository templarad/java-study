package designpattern.Iterator;

public class IDcardIterator implements Iterator{

	private IDcards cards;
	private int index = 0;
	public IDcardIterator(IDcards newcards) {
		cards = newcards;
	}
	@Override
	public boolean hasNext() {
		if(index < cards.getSize()){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object next() {
		return cards.getItemAt(index++);
	}

}
