import java.math.BigDecimal;
import java.util.Random;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal a = new BigDecimal(0.01);
		BigDecimal b = new BigDecimal(2);
		System.out.println(a.compareTo(b));
	}
}
