public class Replace {
	public static void main(String[] args) {
		String phone = "138-123-14 123 123";
		phone = phone.replaceAll("-", "").replaceAll("\\s*", "");
		System.out.println(phone);
	}
}
