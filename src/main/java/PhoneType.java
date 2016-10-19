
public enum PhoneType {
	/**
	 * 手机
	 */
	MOBILE_PHONE(1),
	
	/**
	 * 家庭电话
	 */
	HOME_PHONE(2),
	
	/**
	 * 办公电话
	 */
	OFFICE_PHONE(3);

	private Integer type ;

	private PhoneType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}
}
