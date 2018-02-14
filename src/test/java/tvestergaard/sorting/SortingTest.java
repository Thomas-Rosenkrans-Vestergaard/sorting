package tvestergaard.sorting;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class SortingTest
{

	private int[] random(int size)
	{
		Random random = new Random();
		int[]  result = new int[size];
		for (int x = 0; x < size; x++)
			result[x] = random.nextInt();

		return result;
	}

	@Test
	public void quicksort() throws Exception
	{
		int[] data = random(10000);
		Sorting.quicksort(data);
		for (int x = 1; x < 10000; x++) {
			assertTrue(data[x - 1] < data[x]);
		}
	}
}