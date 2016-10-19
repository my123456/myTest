package thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

import com.alibaba.fastjson.JSON;

public class ThreadTest {

	public void test() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add("name" + i);
		}

		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
		Collection<InnerThread> tasks = new ArrayList<InnerThread>();
		tasks.add(new InnerThread(map, list, 0, 3));
		tasks.add(new InnerThread(map, list, 3, 4));
		tasks.add(new InnerThread(map, list, 4, 10));

		try {
			// List<Future<Object>> result =
			// ThreadPool.getThreadPool().invokeAll(tasks);
			ThreadPool.getThreadPool().invokeAll(tasks);
			// ThreadPool.getThreadPool().shutdown();
			// for (Future<Object> future : result) {
			// System.out.println(JSON.toJSON(future));
			// }
			System.out.println("end");
			ThreadPool.getThreadPool().shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public class InnerThread implements Callable<Object> {
		private ConcurrentHashMap<String, Integer> map;
		private List<String> list;
		private int begin;
		private int end;

		public InnerThread(ConcurrentHashMap<String, Integer> map, List<String> list, int begin, int end) {
			this.map = map;
			this.list = list;
			this.begin = begin;
			this.end = end;
		}

		public Object call() throws Exception {
			for (int pos = begin; pos < end; pos++) {
				map.put(list.get(pos), pos);
			}
			System.out.println("threadId " + Thread.currentThread().getId() + " sleep");
			Thread.sleep(2000);
			System.out.println("threadId " + Thread.currentThread().getId() + " sleep over");
//			System.out.println("thread end");
			return begin;
		}
	}

	public static void main(String[] args) {
		new ThreadTest().test();
		System.out.println("main end");
	}
}
