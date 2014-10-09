package templar;

import java.io.*;
//import java.awt.*;

import javax.activation.FileTypeMap;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class test extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int User;
	String Filename;
	private File UploadFile;
	
	File Upload() {
		try {
			UploadFile=Uppanel();
		} catch (IOException e) {
			e.printStackTrace();			
		} catch (Exception e) {
			System.out.println("Unknown　Exception!");
			e.printStackTrace();
			}
		
		return UploadFile;
	}

	private File Uppanel() throws IOException{
		JFileChooser filec=new JFileChooser();
		String uploadType[] = {"html","htm"};
		filec.setFileFilter(new FileNameExtensionFilter("HTML&HTM",uploadType));
		int res=filec.showOpenDialog(null);
		if(res==JFileChooser.APPROVE_OPTION){//選択
			//Filename=filec.getSelectedFile().getPath();
			File uploadf=filec.getSelectedFile();
			FileTypeMap map=FileTypeMap.getDefaultFileTypeMap();
			//System.out.println(map.getContentType(uploadf));
			
			if(map.getContentType(uploadf).equals("text/html")){//File type =?
				//JOptionPane.showMessageDialog(null, map.getContentType(uploadf));
				return uploadf;
			}
				
			else{
				JOptionPane.showMessageDialog(null,"Please select a \"HTML/HTM\" file!","注意！",2);
				
			}
			
//			FileReader uploadfR=new FileReader(filec.getSelectedFile());
//			
//			char c;
//			while((c=(char)uploadfR.read())!=-1){
//				//char c=(char)uploadfR.read();
//				System.out.print(c);
//			}
//			System.out.println("read ok!");
		}
		else System.exit(0);//未選択
		return null;
	}
	
	void testtemp(){
		
	}
	
	public static void main(String[] args){
		test aa=new test();
		//aa.testtemp();
		File tt=aa.Upload();
		try{
			System.out.println(tt.getName());
		}
		catch(Exception e){
			System.out.println("wrong!");
			e.printStackTrace();
		}
	}
}