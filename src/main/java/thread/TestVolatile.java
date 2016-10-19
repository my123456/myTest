package thread;

public class TestVolatile {
	private static long _longVal = 0;

	private static class LoopVolatile implements Runnable {
		public void run() {
			long val = 0;
			while (val < 10000000L) {
				_longVal++;
				val++;
			}
		}
	}

	private static class LoopVolatile2 implements Runnable {
		public void run() {
			long val = 0;
			while (val < 10000000L) {
				_longVal++;
				val++;
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new LoopVolatile());
		t1.start();

		Thread t2 = new Thread(new LoopVolatile2());
		t2.start();

		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("final val is: " + _longVal);
	}
}
