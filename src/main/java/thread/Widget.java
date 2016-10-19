package thread;

public class Widget {
	public Object obj = new Object();

	public void doSomething() {
		synchronized (obj) {
			System.out.println("this is parent");
		}
	}
}
