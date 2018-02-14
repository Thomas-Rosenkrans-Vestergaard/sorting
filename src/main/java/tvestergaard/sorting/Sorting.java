package tvestergaard.sorting;

public class Sorting
{

	/**
	 * Sorts the provided array of integers in ascending order using the quicksort algorithm.
	 *
	 * @param array The array to sort in ascending order.
	 */
	public static void quicksort(int[] array)
	{
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
		int i     = left;
		int j     = right;
		int pivot = array[right];

		while (i <= j) {

			while (array[i] < pivot)
				i++;

			while (array[j] > pivot)
				j--;

			if (i <= j)
				swap(array, i++, j--);
		}

		if (left < j)
			quicksort(array, left, j);

		if (i < right)
			quicksort(array, i, right);
	}

	/**
	 * Swaps the integer values at index <code>i</code> and index <code>j</code> in the provided array.
	 *
	 * @param array The array where the values are swapped.
	 * @param i     The index of the first value to swap.
	 * @param j     The index of the second value to swap.
	 */
	private static void swap(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
