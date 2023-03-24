import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {

		Map<T, Integer> countA = new HashMap<>();
		Map<T, Integer> countB = new HashMap<>();

		for (T elem : a) {
			countA.put(elem, countA.getOrDefault(elem, 0) + 1);
		}

		for (T elem : b) {
			countB.put(elem, countB.getOrDefault(elem, 0) + 1);
		}

		int sameCount = 0;

		for (T elem : countA.keySet()) {
			if (countB.containsKey(elem) && countA.get(elem).equals(countB.get(elem))) {
				sameCount++;
			}
		}

		return sameCount;
	}
	
}
