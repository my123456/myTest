package time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CalendarTest extends Thread {
	private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			CalendarTest c = new CalendarTest();
			c.start();
		}
	}

	public void run() {
		int num = 0;
		for (int i = 0; i < 5; i++) {
			CalendarTest ct = new CalendarTest();
			ct.test1(num++);
		}
	}

	public void test1(int num) {
		Calendar c = Calendar.getInstance();
		Random r = new Random();
		int tmp = r.nextInt(2);
		System.out.println(Thread.currentThread().getId() + ":" + tmp + ":" + num);
		if (tmp % 2 == 0) {
			c.set(Calendar.HOUR_OF_DAY, 1);
		}
		if (Calendar.AM == c.get(Calendar.AM_PM)) {
			c.setTime(new Date());
			c.add(Calendar.DATE, 1);
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);
		} else {
			c.setTime(new Date());
			c.add(Calendar.DATE, 1);
			c.set(Calendar.HOUR_OF_DAY, 12);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);
		}
		System.out.println(Thread.currentThread().getId() + ":" + c.getTime() + ":" + (num));
	}

	public void test() {
		Date d;
		try {
			d = df.parse("2015-10-22");
			System.out.println(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CalendarTest.getBetweenDay();

		System.out.println(getBeginTime(0));
		System.out.println((int) ((11 * 0.6)));
		CalendarTest ct = new CalendarTest();
		System.out.println(ct.getName());
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new Date());
		c1.add(Calendar.DATE, 30);
		c1.set(2015, 6, 26, 00, 00, 00);
		Date date = c1.getTime();
		System.out.println(CalendarTest.df.format(date));
		System.out.println(CalendarTest.df.format(date).compareTo(CalendarTest.df.format(new Date())));
		System.out.println(c1.getTime());
		System.out.println(c1.get(Calendar.DAY_OF_YEAR));
	}

	// public String getName() {
	// return CalendarTest.class.getName();
	// }

	public static Date getBeginTime(int dayAmount) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 0 - dayAmount);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static void getBetweenDay() {
		Long time1 = new Date().getTime();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long time2 = new Date().getTime();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		System.out.println(Integer.parseInt(String.valueOf(between_days)));
	}

}
