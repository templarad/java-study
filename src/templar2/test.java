package templar2;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class test extends JApplet implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label;
	JButton a1,a2;
	public void init(){
		label=new JLabel("");
		a1=new JButton("Select");
		a1.addActionListener(this);
		add(label,BorderLayout.NORTH);
		add(a1,BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new Upload();
	}
}
