package print;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class RandomDataUtil {

	/**
	 * 生成11位整数随机字符串
	 * 
	 * @param length
	 *            表示生成字符串的长度
	 */
	public static String getRandomNumber(int length) {
		String base = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 生成随机字符串
	 * 
	 * @param length
	 *            表示生成字符串的长度
	 */
	public static String getRandomString(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 生成随机日期
	 */
	public static Date getRandomDate() {
		Calendar calendar = Calendar.getInstance();
		Random random = new Random();
		calendar.add(Calendar.DATE, -random.nextInt(30));
		return calendar.getTime();
	}
}
