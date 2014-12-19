package designpattern.Iterator;

import java.util.ArrayList;
import java.util.List;

public class IDcards implements Aggregate {
	private List<IDcard> cards = new ArrayList<IDcard>();
	public void addItem(IDcard card) {
		cards.add(card);
    }
    public int getSize() {
        return cards.size();
    }
    public IDcard getItemAt(int index) {
        return (IDcard) cards.get(index);
    }
    public Iterator iterator() {
        return new IDcardIterator(this);
    }
}
