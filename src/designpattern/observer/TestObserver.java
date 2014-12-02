package designpattern.observer;

public class TestObserver {
	public TestObserver() {
		Subject subject = new Subject();
		Observer observer = new Observer(subject);
		subject.addObserver(observer);
		
		subject.setState(State.START);
		
		subject.setState(State.END);
	}
}
