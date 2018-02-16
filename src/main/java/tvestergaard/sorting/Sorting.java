package tvestergaard.sorting;

import java.util.Comparator;
import java.util.List;

public class Sorting
{

	/**
	 * Sorts the provided array of <code>comparable</code> values using the merge-sort algorithm. Null values are
	 * considered smaller than all other values.
	 *
	 * @param array The array to sort.
	 * @param <T>   The type of value in the array to sort.
	 */
	public static <T extends Comparable<T>> void mergesort(T[] array)
	{
		mergesort(array, (o1, o2) -> {

			if (o1 == null && o2 == null)
				return 0;

			if (o1 == null)
				return -1;

			if (o2 == null)
				return 1;

			return o1.compareTo(o2);
		});
	}

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

		T[] auxiliary = (T[]) new Object[array.length];
		mergesort(array, auxiliary, 0, array.length - 1, comparator);
	}

	/**
	 * Recursive method that sorts the provided array from index <code>low</code> to index <code>high</code>
	 * (inclusive) using the merge sort algorithm.
	 *
	 * @param array      The array to be sorted.
	 * @param auxiliary  The array used for auxiliary storage during the sorting.
	 * @param from       The index to sort from (inclusive).
	 * @param to         The index to sort to (inclusive).
	 * @param comparator The comparator that dictates the sorting of the array.
	 * @param <T>        The type of value in the array to sort.
	 */
	private static <T> void mergesort(T[] array, T[] auxiliary, int from, int to, Comparator<T> comparator)
	{
		if (from < to) {
			int mid = from + (to - from) / 2;
			mergesort(array, auxiliary, from, mid, comparator);
			mergesort(array, auxiliary, mid + 1, to, comparator);
			merge(array, auxiliary, from, mid, to, comparator);
		}
	}

	/**
	 * Merges the two sections in the provided array <code>auxiliary</code>, bounded by <code>from</code>,
	 * <code>mid</code> and <code>to</code>, into <code>array</code>.
	 *
	 * @param array      The array to merge into.
	 * @param auxiliary  The array to merge from.
	 * @param from       The index of the first section in auxiliary.
	 * @param mid        The index of the end of the first section in auxiliary.
	 * @param to         The index of the end of the last section in auxiliary.
	 * @param comparator The comparator dictating the order of the merge.
	 * @param <T>        The type of the values in the array.
	 */
	private static <T> void merge(T[] array, T[] auxiliary, int from, int mid, int to, Comparator<T> comparator)
	{
		for (int i = from; i <= to; i++)
			auxiliary[i] = array[i];

		int i = from;
		int j = mid + 1;
		int k = from;

		while (i <= mid && j <= to)
			array[k++] = comparator.compare(auxiliary[i], auxiliary[j]) < 1 ? auxiliary[i++] : auxiliary[j++];
		while (i <= mid)
			array[k++] = auxiliary[i++];
	}

	/**
	 * Sorts the provided list using the merge-sort algorithm. The merge sort algorithm is stable meaning that equal
	 * values in the array retain their order when sorted.
	 *
	 * @param list The list to be sorted.
	 * @param <T>  The type of value to sort.
	 */
	public static <T extends Comparable<T>> void mergesort(List<T> list)
	{
		mergesort(list, (o1, o2) -> {
			if (o1 == null && o2 == null)
				return 0;

			if (o1 == null)
				return -1;

			if (o2 == null)
				return 1;

			return o1.compareTo(o2);
		});
	}

	/**
	 * Sorts the provided list using the merge-sort algorithm. The merge sort algorithm is stable meaning that equal
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

		T[] auxiliary = (T[]) new Object[size];
		mergesort(list, auxiliary, 0, size - 1, comparator);
	}

	/**
	 * Sorts the provided list from index <code>from</code> to <code>to</code> (inclusive) using the merge-sort
	 * algorithm. The merge sort algorithm is stable meaning that equal values in the array retain their order when
	 * sorted.
	 *
	 * @param list       The list to be sorted.
	 * @param auxiliary  The array used for auxiliary storage during the sorting.
	 * @param from       The index to sort from (inclusive).
	 * @param to         The index to sort to (inclusive).
	 * @param comparator The comparator that dictates the sorting of the list.
	 * @param <T>        The type of value in the list to sort.
	 */
	private static <T> void mergesort(List<T> list, T[] auxiliary, int from, int to, Comparator<T> comparator)
	{
		if (from < to) {
			int mid = from + (to - from) / 2;
			mergesort(list, auxiliary, from, mid, comparator);
			mergesort(list, auxiliary, mid + 1, to, comparator);
			merge(list, auxiliary, from, mid, to, comparator);
		}
	}

	/**
	 * Merges the two sections in the provided array <code>auxiliary</code>, bounded by <code>from</code>,
	 * <code>mid</code> and <code>to</code>, into <code>list</code>.
	 *
	 * @param list       The list to merge into.
	 * @param auxiliary  The array to merge from.
	 * @param from       The index of the first section in auxiliary.
	 * @param mid        The index of the end of the first section in auxiliary.
	 * @param to         The index of the end of the last section in auxiliary.
	 * @param comparator The comparator dictating the order of the merge.
	 * @param <T>        The type of the values in the list.
	 */
	private static <T> void merge(List<T> list, T[] auxiliary, int from, int mid, int to, Comparator<T> comparator)
	{
		for (int i = from; i <= to; i++)
			auxiliary[i] = list.get(i);

		int i = from;
		int j = mid + 1;
		int k = from;

		while (i <= mid && j <= to)
			list.set(k++, comparator.compare(auxiliary[i], auxiliary[j]) < 1 ? auxiliary[i++] : auxiliary[j++]);
		while (i <= mid)
			list.set(k++, auxiliary[i++]);
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
