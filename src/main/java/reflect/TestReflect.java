package reflect;
import java.lang.reflect.Method;

public class TestReflect {
	public static void main(String[] args) {
		String abc = "FEMALE";
		try {
			Class<SexType> clz = SexType.class;
			Method name = clz.getMethod("name");
			for (Object obj : clz.getEnumConstants()) {
				if (name.invoke(obj).equals(abc)) {
					SexType sex = (SexType) obj;
					System.out.println(sex.getType());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
