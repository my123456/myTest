package design;
import java.io.Serializable;

public class Singleton implements Serializable {
	private String name = "SheepMu";
	private int age = 24;

	/**
	 * 
	 */
	private static final long serialVersionUID = -8234435401007920773L;
	public static Singleton INSTANCE = new Singleton();

	protected Singleton() {

	}

	public static final Singleton getInstance() {
		return INSTANCE;
	}

	private Object readResolve() {
		return INSTANCE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
