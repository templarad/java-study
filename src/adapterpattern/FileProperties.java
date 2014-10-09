package adapterpattern;

import java.io.*;
import java.util.Properties;

public class FileProperties implements FileIO{
	Properties properties = new Properties();

	@Override
	public void readFromFile(String filename) throws IOException {
		InputStream input = new FileInputStream(filename); 

		properties.load(input);
		
	}

	@Override
	public void writeToFile(String filename) throws IOException {
		OutputStream output = new FileOutputStream(filename); 
		String comments = "written by FileProperties";
		properties.store(output, comments);
	}

	@Override
	public void setValue(String key, String value) {
		properties.setProperty(key, value);
		
	}

	@Override
	public String getValue(String key) {
		
		return properties.getProperty(key);
	}

}
