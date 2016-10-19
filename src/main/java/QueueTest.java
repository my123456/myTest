import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.lianjia.common.exception.BusinessException;
import com.lianjia.common.exception.BusinessNoStackTraceException;

public class QueueTest{

	public static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();

	// public static ArrayBlockingQueue<String> queue = new
	// ArrayBlockingQueue<String>(10);

	public static void main(String[] args) {

		try {
			throw new BusinessNoStackTraceException(-1, "ac");
		} catch (BusinessException e) {
			System.out.println("abc");
			e.printStackTrace();
		}
	}

}
