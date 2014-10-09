package idcard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import adapterpattern.FileIO;
import adapterpattern.FileProperties;
import factorypattern.*;
public class IDCardFactory extends Factory{

	private List<String> owners = new ArrayList<String>();
	private int num = 0;
	FileIO f = new FileProperties();


	protected void registerProduct(Product p) {
		owners.add(((IDCard)p).getOwner());
		((IDCard)p).setNum(num);
		f.setValue(String.valueOf(num), ((IDCard)p).getOwner());
		this.num++;
	}


	protected Product createProduct(String owner) {
		return new IDCard(owner);
		
	}

	public List<String> getOwners(){
		return owners;
	}
	
	public void printlist(){		
		try {
			f.writeToFile("newfile.txt");
			System.out.print("Write ok!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
