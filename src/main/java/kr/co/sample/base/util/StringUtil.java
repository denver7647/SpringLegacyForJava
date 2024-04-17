package kr.co.sample.base.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;

public class StringUtil {
	
	/**
	 * null 관련 함수
	 * contains 관련 함수
	 * equals 관련 함수
	 */
	
	
	/**
	 * @methodName      : isEmpty
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 16.
	 * @description     : null 또는 값이 없는경우(공백포함) 
	 * 					  true 반환
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(@Nullable CharSequence  str) {
		
		return StringUtils.isAnyEmpty(str);
	}
	
	public static boolean isEmpty(@Nullable Object obj) {
		
		return obj == null || isEmpty(obj.toString());
	}
	
	/**
	 * @methodName      : isNotEmpty
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 16.
	 * @description     : 값이 있는경우(공백 미포함) 
	 * 					  true 반환
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(@Nullable CharSequence  str) {
		
		return !StringUtils.isAnyEmpty(str);
	}
	
	/**
	 * @methodName      : contains
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 16.
	 * @description     : 대소문자를 구분하여 해당 문자열(strArr)이 있으면
	 * 					  true를 반환한다
	 * @param str
	 * @param strArr
	 * @return
	 */
	public static boolean contains(@Nullable CharSequence  str , CharSequence ... strArr) {
		
		boolean result = false;
		
		for(CharSequence st : strArr) {
			result = StringUtils.contains(str, st);
			if(result) break;
		}

		return result;
	}
	
	/**
	 * @methodName      : containsIgnoreCase
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 16.
	 * @description     : 대소문자 구분하지 않고 해당 문자열(strArr)이 있으면
	 * 					  true를 반환한다
	 * @param str
	 * @param strArr
	 * @return
	 */
	public static boolean containsIgnoreCase(@Nullable CharSequence  str , CharSequence ... strArr) {
		
		boolean result = false;
		
		for(CharSequence st : strArr) {
			result = StringUtils.containsIgnoreCase(str, st);
			if(result) break;
		}
		
		return result;
	}
	
	/**
	 * @methodName      : equals
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 16.
	 * @description     : 
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean equals(@Nullable CharSequence str1 , @Nullable CharSequence str2) {
		
		return StringUtils.equals(str1, str2);
	}
	
	/**
	 * @methodName      : equalsIgnoreCase
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 16.
	 * @description     : 
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean equalsIgnoreCase(@Nullable CharSequence str1 , @Nullable CharSequence str2) {
		
		return StringUtils.equalsIgnoreCase(str1, str2);
	}
	
	
}
