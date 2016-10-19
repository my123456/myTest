package thread;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 处理即将逾期的标签
 */
public class OverDueService {

	public static void main(String[] args) {

		Collection<OverDueInsertLabelThread> tasks = new ArrayList<OverDueInsertLabelThread>();
		tasks.add(new OverDueInsertLabelThread("thread1"));
		tasks.add(new OverDueInsertLabelThread("thread2"));
		try {
			ThreadPool.getThreadPool().invokeAll(tasks);
		} catch (InterruptedException e) {
		}
		System.out.println("end");

	}
}
