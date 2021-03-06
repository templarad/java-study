package mediator;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class LoginFrame extends Frame implements ActionListener, Mediator{

	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOK;
	private ColleagueButton buttonCancel;
	
	public LoginFrame(String title){
		super(title);
		setBackground(Color.lightGray);
		setLayout(new GridLayout(4, 2));
		createColleagues();
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username:"));
		add(textUser);
		
		add(new Label("Password:"));
		add(textPass);
		add(buttonOK);
		add(buttonCancel);
		colleagueChanged();
		pack();
		this.setVisible(true);
	}
	
	@Override
	public void createColleagues() {
		CheckboxGroup group = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", group, true);
		checkLogin = new ColleagueCheckbox("Login", group, false);
		textUser = new ColleagueTextField("", 10);
		textPass = new ColleagueTextField("", 10);
		textPass.setEchoChar('*');
		buttonOK = new ColleagueButton("Login");
		buttonCancel = new ColleagueButton("Cancel");
		
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOK.setMediator(this);
		buttonCancel.setMediator(this);
		
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOK.addActionListener(this);
		buttonCancel.addActionListener(this);
		
	}

	@Override
	public void colleagueChanged() {
		if(checkGuest.getState()){
			textUser.setColleagueEnabled(false);
			textPass.setColleagueEnabled(false);
			buttonOK.setColleagueEnabled(true);
		}else{
			textUser.setColleagueEnabled(true);
			userpassChanged();
		}
	}

	private void userpassChanged() {
		if(textUser.getText().length()>0){
			textPass.setColleagueEnabled(true);
			if(textPass.getText().length()>0){
				buttonOK.setColleagueEnabled(true);
			}else{
				buttonOK.setColleagueEnabled(false);
			}
		}else{
			textPass.setColleagueEnabled(false);
			buttonOK.setColleagueEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		System.exit(0);
	}
	
	

}
