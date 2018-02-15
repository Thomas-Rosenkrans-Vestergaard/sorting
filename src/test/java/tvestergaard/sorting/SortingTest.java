package tvestergaard.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;

public class SortingTest
{

	@Test
	public void mergesortArray() throws Exception
	{
		Integer[] actual   = {0, 5, 8, 3, 4, 1, 2, 7, 9, 6};
		Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Sorting.mergesort(actual, Integer::compare);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void mergesortArrayStability() throws Exception
	{
		Integer   first    = new Integer(9);
		Integer   second   = new Integer(9);
		Integer[] actual   = {7, 4, 5, 8, first, 1, 3, 2, 6, second};
		Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
		Sorting.mergesort(actual, Integer::compare);
		assertArrayEquals(expected, actual);
		assertSame(first, actual[8]);
		assertSame(second, actual[9]);
	}

	@Test
	public void mergesortList() throws Exception
	{
		List<Integer> actual   = toList(0, 5, 8, 3, 4, 1, 2, 7, 9, 6);
		List<Integer> expected = toList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		Sorting.mergesort(actual, Integer::compare);
		assertEquals(expected, actual);
	}

	@Test
	public void mergesortListStability() throws Exception
	{
		Integer       first  = new Integer(9);
		Integer       second = new Integer(9);
		List<Integer> actual = toList(7, 4, 5, 8, -1, 1, 3, 2, 6, -1);
		actual.set(4, first);
		actual.set(9, second);
		List<Integer> expected = toList(1, 2, 3, 4, 5, 6, 7, 8, 9, 9);
		Sorting.mergesort(actual, Integer::compare);
		assertEquals(expected, actual);
		assertSame(first, actual.get(8));
		assertSame(second, actual.get(9));
	}

	@Test
	public void quicksortArray() throws Exception
	{
		int[] actual   = {0, 5, 8, 3, 4, 1, 2, 7, 9, 6};
		int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Sorting.quicksort(actual);
		assertArrayEquals(actual, expected);
	}

	private <T> List<T> toList(T... arguments)
	{
		List<T> list = new ArrayList<>();
		for (T argument : arguments)
			list.add(argument);

		return list;
	}
}
