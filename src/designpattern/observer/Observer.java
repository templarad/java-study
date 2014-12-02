package designpattern.observer;

public class Observer {

	private Subject subject;

	public Observer(Subject subject) {
		this.subject = subject;
	}

	public void update() {
		System.out.println("Observer state change to " + subject.getState());
		State state = subject.getState();
	}
}
