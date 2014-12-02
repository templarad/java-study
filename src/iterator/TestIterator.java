package iterator;

import java.util.ArrayList;
import java.util.Iterator;


public class TestIterator {

	
	public void run(){
		ArrayList<String> ss = new ArrayList<String>();
		ss.add("aa");
		ss.add("bb");
		
		Iterator<String> it = ss.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	}
}
