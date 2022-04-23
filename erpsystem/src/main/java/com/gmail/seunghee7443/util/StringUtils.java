/* 
 * 정보 수정을 위한 필요 Class
 * 역할 : 정보를 수정할 경우 항목에 null or white space가 있을 경우 수정되지 않도록 함
 * 사용할 곳 : User, Client Modify에 사용 
 * 참고 자료 : https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html
 */

package com.gmail.seunghee7443.util;

public class StringUtils {
	// CharSequence에 null or white space가 포함되어있나 Check하기 위한 class
	public static boolean isBlank(final CharSequence cs) {
		int strLen;
		
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		
		for (int i = 0; i < strLen; i = i + 1) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	// CharSequence에 null or white space가 포함되어있나 Check하기 위한 class
	public static boolean isNotBlank(final CharSequence cs) {
		return !isBlank(cs);
	}
}
