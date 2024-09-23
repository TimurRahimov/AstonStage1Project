package ru.astonstage1project.util;

import java.util.List;
import java.util.ListIterator;

public class TimSort<T extends Comparable<T>> {
    static int RUN = 32;

    /*
    @SuppressWarnings({"unchecked"})
	private static <T> T[] createArrayT(int size, T defaultVal) {
		T[] arr = (T[]) Array.newInstance(defaultVal.getClass(), size);
		Arrays.fill(arr, defaultVal);
		return arr;
	}

    private static <T> T[] listToArray(List<T> list) {
        var len = list.size();
        T[] arr = createArrayT(len, null);
        for (int i = 0; i < len; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    */


    // this function sorts array from left index to
    // to right index which is of size atmost THREASHOLD
    @SuppressWarnings({"unchecked"})
    private static void insertionSort(Object[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            Object tempI = arr[i];
            int j = i - 1;
            Comparable tempJ = (Comparable) arr[j];
            while (j >= 0 && tempJ.compareTo(tempI) > 0 && j >= left) {
                arr[j + 1] = arr[j];
                j--;
                tempJ = j >= 0 ? (Comparable) arr[j] : null;
            }
            arr[j + 1] = tempI;
        }
    }

    // merge function merges the sorted runs
    @SuppressWarnings({"unchecked"})
    private static void merge(Object[] arr, int left, int mid, int right) {

        int leftArrLen = mid - left + 1;
        int rightArrLen = right - mid;
		Object[] leftArr = new Object[leftArrLen];
		Object[] rightArr = new Object[rightArrLen];


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
            Comparable tmp = (Comparable) leftArr[i];
            if (tmp.compareTo(rightArr[j]) <= 0) {
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

    @SuppressWarnings({"unchecked"})
    public static <T extends Comparable<T>> void sort(List<T> list) {
		Object[] arr = list.toArray();

        int length = list.size();

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

        // write sorted array to list
        ListIterator<T> i = list.listIterator();
        for (Object e : arr) {
            i.next();
            i.set((T) e);
        }
    }
}
