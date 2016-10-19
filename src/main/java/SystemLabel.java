import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public enum SystemLabel {
	INTERLINK("连环"), SOON_OVERDUE("即将逾期"), SOON_SHARE("即将共享"), SHOWING("带看"), PALM_LIANJIA("掌上链家"), LIANJIA_COM("链家网"), OTHER_RECOMMEND("他人推荐"), ME_RECOMMEND(
			"我推荐"), EARNEST_MONEY("意向金"), DEPOSIT("定金"), SIGNING("签约"), OTHER_SIGNING("他签"), ;

	private String name;

	private SystemLabel(String name) {
		this.name = name;
		// this.value = name;
	}

	public String getName() {
		return name;
	}

	public static long getLabelId() {
		return 0L;
	}

	public static SystemLabel getSystemLabel(String labelName) {
		for (SystemLabel obj : SystemLabel.values()) {
			System.out.println(obj.getName());
		}
		return null;
	}

	public static void main(String[] args) {
		SystemLabel label = (SystemLabel) SystemLabel.getType(SystemLabel.class, "INTERLINK");
		if (label != null) {
			System.out.println(label.getName());
		} else {
			System.out.println("---");
		}
	}

	// private SystemLabel(String name, String value) {
	// this.name = name;
	// this.value = value;
	// }
	// private String value;

	// public String getValue() {
	// return value;
	// }

	private static Object getType(Class<?> clz, String key) {
		try {
			Method name = clz.getMethod("name");
			for (Object obj : clz.getEnumConstants()) {
				System.out.println(name.invoke(obj));
				if (name.invoke(obj).equals(key)) {
					return obj;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
