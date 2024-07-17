package com.train.auth.constant;

public enum RoleEnum {
	
	NORMAIL_USER("ROLE_NORMAL"), ADMIN_USER("ROLE_ADMIN");
	
	private String value;

	private RoleEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
