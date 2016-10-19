import design.User;

public class GC {
	public static void main(String[] args) {
		Runtime.getRuntime().gc();
		long start = Runtime.getRuntime().freeMemory();
		User u1 = new User();
		u1.setAge(1);
		u1.setName("1");
		Runtime.getRuntime().gc();
		long end = Runtime.getRuntime().freeMemory();
		long difference = (start - end);
		System.out.println(difference + " bytes be used!");
	}
}
