package kr.co.sample.base.util;

import org.apache.commons.lang3.StringUtils;

/**
 *  정합성 체크 관련 Util
 */
public class ValidateUtil {
	
	/**
	 *  1. 주민체크
	 */
	
	//주민체크
	public static boolean isResident(String resident) {
		
		boolean result = false;

		if(StringUtils.isEmpty(resident)) {
			return result;
		}	
		
		resident = resident.replaceAll("[^0-9]", "");
		
		if(resident.length() != 13) return result;

		String[] residentArr = resident.split("");
		
		int[] temp = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		
		int sum = 0;
		
		sum = (11 - (sum % 11)) % 10;
		
		if(sum == Integer.parseInt(residentArr[12])) {
			result = true;
		}
		
		return result;
	}
	
	//숫자체크
	public static boolean isNumber(String str) {
		
		boolean result = false;
		
		return result;
	}
}
