package thread;

import java.text.ParseException;
import java.util.concurrent.Callable;

public class OverDueInsertLabelThread implements Callable<Object> {

	/**
	 * 数据集
	 */
	int i = 0;
	String name = "";

	/**
	 * @param start
	 *            线程负责区域的起始位置
	 * @param end
	 *            线程负责区域的结束位置
	 */
	public OverDueInsertLabelThread(String name) {
		this.name = name;
	}

	public Object call() throws ParseException {
		while (i < 10) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + "  " + i++);
		}
		return null;
	}
}
