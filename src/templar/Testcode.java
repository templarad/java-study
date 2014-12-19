package templar;
import java.io.*;

public class Testcode {
// �t�@�C������o�C�g�P�ʂœǂݍ��ޗ�
	public Testcode(String OPENFILENAME,String Outputfile){
	File outtest=new File(Outputfile);

	try {
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outtest), "MS932"));//Shift_JIS	UTF-8
	out.write(read(OPENFILENAME,getCode(OPENFILENAME)));	
    out.close();
    } catch (Exception ex) {
    	ex.printStackTrace();
    	}

	}//Testcode()
	
	public String getCode(String Filename) throws Exception{
		InputStream inputStream = new FileInputStream(Filename);  
	    byte[] head = new byte[3];  
	    inputStream.read(head);   
	    String code = "";
	        code = "MS932";
	        System.out.println(head[0]+", "+ head[1]+", " + head[2]);
	    if (head[0] == -1 && head[1] == -2 )
	        code = "UTF-16";  
	    else if (head[0] == -2 && head[1] == -1 )  
	        code = "Unicode";
	    else if(head[0]==-17 && head[1]==-69 && head[2] ==-65)  
	        code = "UTF-8";
	    inputStream.close();
	    return code;
	}

    public static String read(String fileName, String encoding) {
        String string = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), encoding));
            String str = "";
            while ((str = in.readLine()) != null) {
                string += str + "\n";
            }
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return string;
    }
	public static void main(String[] args){
		Testcode aa=new Testcode("E:/apache-tomcat-7.0.27-windows-x64/228.html","E:/apache-tomcat-7.0.27-windows-x64/outtest.html");
		try {
			System.out.println(aa.getCode("E:/apache-tomcat-7.0.27-windows-x64/228.html"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
