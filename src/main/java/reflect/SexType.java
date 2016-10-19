package reflect;


public enum SexType {
	/**
	 * 男
	 */
	MALE(1),
	
	/**
	 * 女
	 */
	FEMALE(2);

	private int type ;

	private SexType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
