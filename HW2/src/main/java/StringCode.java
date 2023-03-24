import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adjacent chars that are the same.
	 *
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int maxSubstringLength = 0;
		int currentSubstringLength = 1;
		if (str.length()==0)
		{
			System.out.println("empty string");
			return 0;
		}
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				currentSubstringLength++;
			} else {
				maxSubstringLength = Math.max(maxSubstringLength, currentSubstringLength);
				currentSubstringLength = 1;
			}
		}
		// Check the last substring
		maxSubstringLength = Math.max(maxSubstringLength, currentSubstringLength);
		return maxSubstringLength;


		// YOUR CODE HERE
	}


	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 *
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {

			StringBuilder sb = new StringBuilder();
			if (str.length()==0 || (str.length()==1 && Character.isDigit(str.charAt(0))))
			{
				return "";
			}
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (Character.isDigit(c)) {
					int num = Character.getNumericValue(c);

					if (i == str.length() - 1) { // check if c is the last character
						continue;
					}
					else {
						char nextChar = str.charAt(i + 1);
						for (int j = 0; j < num; j++) {
							sb.append(nextChar);
						}
					}
				} else {
					sb.append(c);
				}
			}
			return sb.toString();
		}






	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		if (len<=0)
		{
			return false;
		}

			Set<String> setA = new HashSet<>();
			for (int i = 0; i <= a.length() - len; i++) {
				setA.add(a.substring(i, i + len));
			}
			for (int i = 0; i <= b.length() - len; i++) {
				if (setA.contains(b.substring(i, i + len))) {
					return true;
				}
			}


			return false; // YOUR CODE HERE
		}
}


