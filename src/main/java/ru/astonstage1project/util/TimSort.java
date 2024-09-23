package ru.astonstage1project.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class TimSort<T extends Comparable<T>> {
    static int RUN = 32;

    @SuppressWarnings({"unchecked"})
	private static <T> T[] createArrayT(int size, T defaultVal) {
		T[] arr = (T[]) Array.newInstance(defaultVal.getClass(), size);
		Arrays.fill(arr, defaultVal);
		return arr;
	}


    // this function sorts array from left index to
    // to right index which is of size atmost THREASHOLD
    private static <T extends Comparable<T>> void insertionSort(T[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            T temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(temp) > 0 && j >= left) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // merge function merges the sorted runs
    private static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {

        int leftArrLen = mid - left + 1, rightArrLen = right - mid;
		T[] leftArr = createArrayT(leftArrLen, null);
		T[] rightArr = createArrayT(rightArrLen, null);


        for (int x = 0; x < leftArrLen; x++) {
            leftArr[x] = arr[left + x];
        }

        for (int x = 0; x < rightArrLen; x++) {
            rightArr[x] = arr[mid + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftArrLen && j < rightArrLen) {
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // copy remaining elements of left, if any
        while (i < leftArrLen) {
            arr[k] = leftArr[i];
            k++;
            i++;
        }

        // copy remaining element of right, if any
        while (j < rightArrLen) {
            arr[k] = rightArr[j];
            k++;
            j++;
        }
    }

    public static <T extends Comparable<T>> void sort(List<T> list) {
        @SuppressWarnings({"unchecked"})
		T[] arr = (T[]) list.toArray();

        int length = arr.length;

        // Sort individual subarrays of size THRESHOLD
        for (int i = 0; i < length; i += RUN) {
            // perform insertion sort
            insertionSort(arr, i, Math.min((i + 31), (length - 1)));
        }

        for (int size = RUN; size < length; size = 2 * size) {
            for (int left = 0; left < length; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (length - 1));
                // perform merge sort
                merge(arr, left, mid, right);
            }
        }
    }
}
