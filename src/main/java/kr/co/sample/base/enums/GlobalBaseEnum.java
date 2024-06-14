package kr.co.sample.base.enums;

public enum GlobalBaseEnum {

	SAMPLE_LOGIN_SUCCESS(1000, "LOGIN SUCCESS"),
	SAMPLE_LOGIN_FAIL(0001 , "LOGIN FAIL");
	
	private final int code;
	private final String message;
	
	GlobalBaseEnum(int code , String message) {
		
		this.code = code;
		this.message = message;
	}
	
	public int code() {
		return this.code;
	}
	
	public String message() {
		return this.message;
	}
	
	public String codeToString() {
		return String.valueOf(this.code);
	}
	
	public String toString() {
		return code() + " " + message();
	}
	
	public static GlobalBaseEnum valueOf(int code) {
		GlobalBaseEnum error = resolve(code);
		
		if(error == null) {
			throw new IllegalArgumentException("No matching constant for [" + code + "]");
		}
		return error;
	}
	
	//@Nullable
	public static GlobalBaseEnum resolve(int code) {
		
		for (GlobalBaseEnum error : GlobalBaseEnum.values()) {
			if(error.code == code) return error;
		}
		
		return null;
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		for(GlobalBaseEnum temEnum : GlobalBaseEnum.values()) {
		
			 System.out.println("상수 이름: " + temEnum.toString());
			
		}
		
	}

}
