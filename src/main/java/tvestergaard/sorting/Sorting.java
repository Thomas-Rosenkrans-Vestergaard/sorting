package tvestergaard.sorting;

import java.util.Comparator;
import java.util.List;

public class Sorting
{

	/**
	 * Sorts the provided array using the merge-sort algorithm. The merge sort algorithm is stable meaning that equal
	 * values in the array retain their order when sorted.
	 *
	 * @param array      The array to be sorted.
	 * @param comparator The comparator that dictates the sorting of the array.
	 * @param <T>        The type of value to sort.
	 */
	public static <T> void mergesort(T[] array, Comparator<T> comparator)
	{

		if (array.length < 2)
			return;

		int mid   = array.length / 2;
		T[] left  = (T[]) new Object[mid];
		T[] right = (T[]) new Object[array.length - mid];

		int index = 0;
		for (int x = 0; x < left.length; x++)
			left[x] = array[index++];

		for (int x = 0; x < right.length; x++)
			right[x] = array[index++];

		mergesort(left, comparator);
		mergesort(right, comparator);
		merge(array, left, right, comparator);
	}

	/**
	 * Merges the sorted array <code>left</code> and <code>right</code> into <code>array</code>. The arrays are
	 * merged in <code>O(n)</code> time.
	 *
	 * @param array      The array to merge <code>left</code> and <code>right</code> into.
	 * @param left       The first array to merge from.
	 * @param right      The second array to merge from.
	 * @param comparator The comparator to use when merging.
	 * @param <T>        The type of the values in the arrays.
	 */
	private static <T> void merge(T[] array, T[] left, T[] right, Comparator<T> comparator)
	{
		int l = 0;
		int r = 0;
		for (int x = 0; x < array.length; x++) {
			if (l == left.length)
				array[x] = right[r++];
			else if (r == right.length)
				array[x] = left[l++];
			else
				array[x] = comparator.compare(left[l], right[r]) < 1 ? left[l++] : right[r++];
		}
	}

	/**
	 * Sorts the provided array using the merge-sort algorithm. The merge sort algorithm is stable meaning that equal
	 * values in the array retain their order when sorted.
	 *
	 * @param list       The list to be sorted.
	 * @param comparator The comparator that dictates the sorting of the list.
	 * @param <T>        The type of value to sort.
	 */
	public static <T> void mergesort(List<T> list, Comparator<T> comparator)
	{
		int size = list.size();

		if (size < 2)
			return;

		int mid   = size / 2;
		T[] left  = (T[]) new Object[mid];
		T[] right = (T[]) new Object[size - mid];

		int index = 0;
		for (int x = 0; x < left.length; x++)
			left[x] = list.get(index++);

		for (int x = 0; x < right.length; x++)
			right[x] = list.get(index++);

		mergesort(left, comparator);
		mergesort(right, comparator);
		merge(list, left, right, comparator);
	}

	/**
	 * Merges the sorted array <code>left</code> and <code>right</code> into <code>array</code>. The arrays are
	 * merged in <code>O(n)</code> time.
	 *
	 * @param list       The list to merge <code>left</code> and <code>right</code> into.
	 * @param left       The first array to merge from.
	 * @param right      The second array to merge from.
	 * @param comparator The comparator to use when merging.
	 * @param <T>        The type of the values in the arrays.
	 */
	private static <T> void merge(List<T> list, T[] left, T[] right, Comparator<T> comparator)
	{
		int size = list.size();
		int l    = 0;
		int r    = 0;
		for (int x = 0; x < size; x++) {
			if (l == left.length)
				list.set(x, right[r++]);
			else if (r == right.length)
				list.set(x, left[l++]);
			else
				list.set(x, comparator.compare(left[l], right[r]) < 1 ? left[l++] : right[r++]);
		}
	}

	/**
	 * Sorts the provided array of integers in ascending order using the quicksort algorithm.
	 *
	 * @param array The array to sort in ascending order.
	 */
	public static void quicksort(int[] array)
	{
		if (array.length < 2)
			return;

		quicksort(array, 0, array.length - 1);
	}

	/**
	 * Sorts the provided array of integers in ascending order using the quicksort algorithm. The array is sorted from
	 * the provided index <code>left</code> and <code>right</code> inclusive.
	 *
	 * @param array The array to be sorted.
	 * @param left  The index from where to sort.
	 * @param right The index to search to (inclusive).
	 */
	private static void quicksort(int[] array, int left, int right)
	{
		int l     = left;
		int r     = right;
		int pivot = array[(left + right) / 2];

		while (l < r) {
			while (array[l] < pivot)
				l++;
			while (array[r] > pivot)
				r--;
			if (l <= r)
				swap(array, l++, r--);
		}

		if (left < r)
			quicksort(array, left, r);
		if (right > l)
			quicksort(array, l, right);
	}

	/**
	 * Swaps the values at index <code>a</code> and <code>b</code> in the provided <code>array</code>.
	 *
	 * @param array The array to swap values in.
	 * @param a     The first index.
	 * @param b     The second index.
	 */
	private static void swap(int[] array, int a, int b)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
