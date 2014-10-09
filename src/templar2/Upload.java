package templar2;

import java.io.*;
//import java.awt.*;

import javax.activation.FileTypeMap;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Upload extends JPanel{
	/**
	 * ??
	 */
	private static final long serialVersionUID = 1L;
	
	int User;
	String Filename;
	private File UploadFile;
	
	
	public Upload() {
		try {
			UploadFile=Uppanel();
		} catch (IOException e) {
			e.printStackTrace();			
		} catch (Exception e) {
			System.out.println("Unknown　Exception!");
			e.printStackTrace();
			}
	}
	
	public File Getfile(){
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
			
				if(map.getContentType(uploadf).equals("text/html")){//File type =?
					return uploadf;
				}
				else{
					JOptionPane.showMessageDialog(null,"Please select a \"HTML/HTM\" file!","注意！",2);				
				}
				
			}
		else System.exit(0);//未選択
		return null;
	}
	
	
	public static void main(String[] args){
		JFrame dialog=new JFrame();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Upload aa=new Upload();
		dialog.add(aa);
		File tt=aa.Getfile();
		try{
			System.out.println(tt.getName());
		}
		catch(Exception e){
			System.out.println("wrong!");
			e.printStackTrace();
		}
	}
}