package practice.string;

import org.apache.commons.lang.StringUtils;

public class Palindrome {
	
	public static String[] makePalindromes(String[] strings) {

		String[] palindromesEverywhere = new String[strings.length];

		for (int i = 0; i < strings.length; i++) {
			if (couldBePalindrome(strings[i])) {
				String res = makePalindrome(strings[i]);
				palindromesEverywhere[i] = res;
			} else {
				palindromesEverywhere[i] = strings[i] + " IS NOT A PALINDROME !";
			}
		}

		return palindromesEverywhere;
	}

	public static String makePalindrome(String s) {

		int length = s.length();
		char[] result = new char[length];
		StringBuilder builder = new StringBuilder(s);

		if (length % 2 != 0) {
			char center = getPalindromeCenter(s);
			result[length / 2] = center;
			builder.deleteCharAt(builder.lastIndexOf("" + center));
		}

		for (int i = 0; i < length / 2; i++) {
			char c = builder.charAt(0);
			result[i] = result[length - i - 1] = c;
			builder.deleteCharAt(0);
			builder.deleteCharAt(builder.lastIndexOf("" + c));
		}

		return new String(result);
	}

	public static char getPalindromeCenter(String s) {

		for (int i = 0; i < s.length(); i++) {
			if (StringUtils.countMatches(s, "" + s.charAt(i)) % 2 != 0) {
				return s.charAt(i);
			}
		}
		return 0;
	}

	public static boolean couldBePalindrome(String s) {
		boolean centerUsed = false;
		int count = 0;

		if (s.length() % 2 == 0) {
			centerUsed = true;
		}

		for (int i = 0; i < s.length(); i++) {
			count = StringUtils.countMatches(s, "" + s.charAt(i));

			if (count % 2 != 0) {
				if (centerUsed == true) {
					return false;
				} else {
					centerUsed = true;
				}
			}

		}

		return true;
	}

}
