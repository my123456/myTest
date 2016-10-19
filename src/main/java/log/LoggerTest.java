package log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggerTest {
	private static Logger log = LoggerFactory.getLogger("MESSAGE_PRODUCER_INFO_LOG");
	static{
		log.info("abc");
	}
	public static void main(String[] args) {
		new LoggerTest();
	}
}
