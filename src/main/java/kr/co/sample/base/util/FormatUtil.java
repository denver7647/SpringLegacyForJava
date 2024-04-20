package kr.co.sample.base.util;

import org.apache.commons.lang3.StringUtils;

/**
 * format 관련 util
 */
public class FormatUtil {
	
	/**
	 * 계좌  account
	 * 카드 card
	 * 현금 cashcard
	 * 숫자 numeric , number
	 * 이름 name
	 * 폰  phone
	 * 주민번호 resident
	 * 사업자번호 business
	 * 날짜 ( 년월일 , 시간 , 년월일시간 ~~ )
	 * date , dateym , time , datetime
	 * 
	 * 
	 */
	
	public static String format(String type , String value) {
		
		String format = "";
		
		switch (type) {
		case "ACCOUNT":  break;
		case "CARD":  break;
		case "CASHCARD":  break;
		case "NUMBER":  break;
		case "NAME":  break;
		case "PHONE":  break;
		case "RESIDENT":  break;
		case "DATE":  break;
		case "DATEYN":  break;
		case "TIME":  break;
		case "DATETIME":  break;
		default:
			throw new IllegalArgumentException("올바르지않는 변환 타입입니다." );
		}
		
		return format;
		
	}
	
	//계좌번호
	// 1234-1234-1234-1
	//1234-12-12-1234-1
	private String account(String value) {
		
		String result = "";
		
		if(StringUtils.isBlank(value)) return result;
		
		value = StringUtils.trimToEmpty(value);
		
		if(StringUtils.startsWith(value, "9")) {
			result = value.replaceAll("^[0-9]{4})-?([0-9]{4})-?([0-9]{4})-?([0-9]{1})$", "$1-$2-$3-$4");
		} else {
			result = value.replaceAll("^[0-9]{4})-?([0-9]{2})-?([0-9]{2})-?([0-9]{4})-?([0-9]{1})$", "$1-$2-$3-$4-$5");
		}
		
		return result;
	}
	/**
	 * 카드 
	 * 1234-1234-1234-1234
	 * @param value
	 * @return
	 */
	private String card(String value) {
		
		String result = "";
		
		if(StringUtils.isBlank(value)) return result;
		
		value = StringUtils.trimToEmpty(value);
		
		result = value.replaceAll("^[0-9]{4})-?([0-9]{4})-?([0-9]{4})-?([0-9]{4})$", "$1-$2-$3-$4");
		
		return result;
	}
	
	//현금카드
	//1234-12-123456-1-12
	private String cashCard(String value) {
		
		String result = "";
		
		if(StringUtils.isBlank(value)) return result;
		
		value = StringUtils.trimToEmpty(value);
		
		result = value.replaceAll("^[0-9]{4})-?([0-9]{2})-?([0-9]{6})-?([0-9]{6})-?([0-9]{1})$", "$1-$2-$3-$4-$5");
		
		return result;
	}
	
	//숫자콤마
	private String number(String value) {
		
		String result = "0";
		
		if(StringUtils.isBlank(value)) return result;
		
		value = StringUtils.trimToEmpty(value);
		
		result = value.replaceAll("\\B(?<!\\.\\d)(?=(\\d{3})+(d?!\\d))", ",");
		
		return result;
	}
	
	//이름
	private String name(String value) {
		return value;
	}
	
	//전화번호
	private String phone(String value) {
		
		String result = "";
		
		return result;
	} 
	
}
