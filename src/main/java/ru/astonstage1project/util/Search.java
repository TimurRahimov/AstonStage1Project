package ru.astonstage1project.util;

import java.util.List;

public class Search<T extends Comparable<T>> {
	public static <T> int binary(List<T> list, T target) {
		int start = 0;
		int end = list.size() - 1;

		while (start <= end) {
			// find the middle element
			// int mid = (start + end) / 2;
			// Problem: might be possible that (start + end) exceeds the range of int in
			// Java

			int mid = start + ((end - start) / 2);

			@SuppressWarnings({"unchecked"})
			Comparable<T> midVal = (Comparable<T>) list.get(mid);

			if (midVal.compareTo(target) > 0) {
				end = mid - 1;
			} else if (midVal.compareTo(target) < 0) {
				start = mid + 1;
			} else {
				// ans found
				return mid;
			}
		}

		return -1;
	}
}
