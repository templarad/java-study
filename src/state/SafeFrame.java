package state;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements Context, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextField textClock = new TextField(60);
	private TextArea textScreen = new TextArea(10,60);
	private Button buttonUse = new Button("金庫使用");
	private Button buttonAlarm = new Button("非常ベル");
	private Button buttonPhone = new Button("通常通話");
	private Button buttonExit = new Button("終了");
	
	private State state = DayState.getInstance();
	
	public SafeFrame(String title){
		super(title);
		setBackground(Color.lightGray);
		setLayout(new BorderLayout());
		
		add(textClock,BorderLayout.NORTH);
		textClock.setEditable(false);
		
		add(textScreen,BorderLayout.CENTER);
		textScreen.setEditable(false);
		
		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);
		add(panel,BorderLayout.SOUTH);
		pack();
		this.setVisible(true);
		
		buttonUse.addActionListener(this);
		buttonAlarm.addActionListener(this);
		buttonPhone.addActionListener(this);
		buttonExit.addActionListener(this);
			
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonUse){
			state.doUse(this);
		}else if(e.getSource() == buttonAlarm){
			state.doAlarm(this);
		}else if(e.getSource() == buttonPhone){
			state.doPhone(this);
		}else if(e.getSource() == buttonExit){
			System.exit(0);
		}else{
			System.out.println("?");
		}
	}

	@Override
	public void setClock(int hour) {
		String clockstring = "現在時刻は";
		if(hour<10){
			clockstring +="0"+hour+":00";
		}else{
			clockstring +=hour+":00";
				
		}
		System.out.println(clockstring);
		textClock.setText(clockstring);
		state.doClock(this, hour);
	}

	@Override
	public void changeState(State state) {
		this.state=state;
	}

	@Override
	public void callSecurityCenter(String msg) {
		textScreen.append("Call! "+ msg+"\n");
	}

	@Override
	public void recordLog(String msg) {
		textScreen.append("record ... "+msg+"\n");
	}

}
