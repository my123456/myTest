package thread;
/**
 * 
 */


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池类
 */
public class ThreadPool {
	
	/**
	 * 线程池，采用的是cachedThrealPool
	 */
	private static final ExecutorService THREAD_POOL = Executors.newCachedThreadPool();
	
	/**
	 * 初始化线程池
	 */
	public static ExecutorService getThreadPool() {
		return THREAD_POOL;
	}
}
