package com.train.auth.constant;

public class CommonConstant {
	
	public static enum AccountStatus {
		
		NOT_ACTIVATED("01-01"), ACTIVATED("01-02"), DISABLED("01-03");
		
		private String value;

		private AccountStatus(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

	}
	
	public static final String USER_INFO_REDIS_HASH_KEY = "USER_INFO_KEY";
}
