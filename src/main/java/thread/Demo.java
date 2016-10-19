package thread;
import design.User;

public class Demo {
	public static void main(String[] args) {
		final User user = new User();
		user.setAge(1);
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				user.setAge(2);
				System.out.println("in thread "+user.getAge());
			}
		};
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("in main "+user.getAge());
	}
}

abstract class Person {
	public abstract void eat();
}
