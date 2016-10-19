package thread;

public class LoggingWidget extends Widget {
	@Override
	public void doSomething() {
		synchronized (obj) {
			System.out.println("this is children");
			super.doSomething();
		}
	}

	public static void main(String[] args) {
		new LoggingWidget().doSomething();
	}
}
