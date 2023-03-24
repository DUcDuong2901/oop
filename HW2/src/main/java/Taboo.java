
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {

	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 *
	 * @param rules rules for new Taboo
	 */
	private final Map<T, Set<T>> noFollowMap;

	public Taboo(List<T> rules) {
		noFollowMap = new HashMap<>();
		for (int i = 0; i < rules.size() - 1; i++) {
			T current = rules.get(i);
			T next = rules.get(i + 1);
			if (!current.equals(next)) {
				if (!noFollowMap.containsKey(current)) {
					noFollowMap.put(current, new HashSet<>());
				}
				noFollowMap.get(current).add(next);
			}
		}
	}

	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 *
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		return noFollowMap.getOrDefault(elem, Collections.emptySet());
	}

	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 *
	 * @param list collection to reduce
	 */
	public List<T> reduce(List<T> list) {
		List<T> result = new ArrayList<>();
		if (list.isEmpty()) return result;

		T prev = list.get(0);
		result.add(prev);
		for (int i = 1; i < list.size(); i++) {
			T current = list.get(i);
			Set<T> taboos = noFollowMap.getOrDefault(prev, Collections.emptySet());
			if (!taboos.contains(current)) {
				result.add(current);
				prev = current;
			}
			else {
				// If the current element is taboo, skip it and any subsequent elements that are also taboo.
				while (i < list.size() - 1 && taboos.contains(list.get(i + 1))) {
					i++;
				}
				// If the current element is not the last element of the list, add the next valid element.
				if (i < list.size() - 1) {
					prev = list.get(i + 1);

				}
			}


		}
		list.clear();
		list.addAll(result);
		return list;

	}
}