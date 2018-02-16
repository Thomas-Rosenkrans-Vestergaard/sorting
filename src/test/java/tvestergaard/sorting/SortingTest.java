package tvestergaard.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class SortingTest
{

	@Test
	public void mergesortArrayNull() throws Exception
	{
		Integer[] actual = {6, 4, 2, null};
		Integer[] expected = {null, 2, 4, 6};
		Sorting.mergesort(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void mergesortArrayComparable() throws Exception
	{
		Integer[] actual   = new Integer[0];
		Integer[] expected = new Integer[0];

		assertArrayEquals(expected, actual);
		Sorting.mergesort(actual);
		assertArrayEquals(expected, actual);

		actual = new Integer[]{0, 5, 8, 3, 4, 1, 2, 7, 9, 6};
		expected = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

		Sorting.mergesort(actual);
		assertArrayEquals(expected, actual);

		actual = new Integer[]{0, 1, 2, 3, 4};
		expected = new Integer[]{0, 1, 2, 3, 4};

		Sorting.mergesort(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void mergesortArrayComparableStable() throws Exception
	{
		Integer   first    = new Integer(9);
		Integer   second   = new Integer(9);
		Integer[] actual   = {7, 4, 5, 8, first, 1, 3, 2, 6, second};
		Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9};

		Sorting.mergesort(actual);
		assertArrayEquals(expected, actual);
		assertSame(first, actual[8]);
		assertSame(second, actual[9]);
	}

	@Test
	public void mergesortArrayComparator() throws Exception
	{
		Integer[] expected = new Integer[0];
		Integer[] actual   = new Integer[0];

		Sorting.mergesort(actual, Integer::compare);
		assertArrayEquals(expected, actual);

		actual = new Integer[]{0, 5, 8, 3, 4, 1, 2, 7, 9, 6};
		expected = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

		Sorting.mergesort(actual, Integer::compare);
		assertArrayEquals(expected, actual);

		actual = new Integer[]{0, 1, 2, 3, 4};
		expected = new Integer[]{0, 1, 2, 3, 4};

		Sorting.mergesort(actual, Integer::compare);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void mergesortArrayComparatorStable() throws Exception
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
	public void mergesortListComparable() throws Exception
	{
		List<Integer> expected = new ArrayList<>();
		List<Integer> actual   = new ArrayList<>();

		assertEquals(expected, actual);
		Sorting.mergesort(actual);
		assertEquals(expected, actual);

		actual = toList(0, 5, 8, 3, 4, 1, 2, 7, 9, 6);
		expected = toList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

		assertNotEquals(expected, actual);
		Sorting.mergesort(actual);
		assertEquals(expected, actual);

		actual = toList(0, 1, 2, 3, 4);
		expected = toList(0, 1, 2, 3, 4);

		assertEquals(expected, actual);
		Sorting.mergesort(actual);
		assertEquals(expected, actual);
	}

	@Test
	public void mergesortListComparableStability() throws Exception
	{
		Integer       first  = new Integer(9);
		Integer       second = new Integer(9);
		List<Integer> actual = toList(7, 4, 5, 8, -1, 1, 3, 2, 6, -1);
		actual.set(4, first);
		actual.set(9, second);

		List<Integer> expected = toList(1, 2, 3, 4, 5, 6, 7, 8, 9, 9);

		Sorting.mergesort(actual);
		assertEquals(expected, actual);
		assertSame(first, actual.get(8));
		assertSame(second, actual.get(9));
	}


	@Test
	public void mergesortListComparator() throws Exception
	{
		List<Integer> expected = new ArrayList<>();
		List<Integer> actual   = new ArrayList<>();

		assertEquals(expected, actual);
		Sorting.mergesort(actual, Integer::compare);
		assertEquals(expected, actual);

		actual = toList(0, 5, 8, 3, 4, 1, 2, 7, 9, 6);
		expected = toList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

		assertNotEquals(expected, actual);
		Sorting.mergesort(actual, Integer::compare);
		assertEquals(expected, actual);

		actual = toList(0, 1, 2, 3, 4);
		expected = toList(0, 1, 2, 3, 4);

		assertEquals(expected, actual);
		Sorting.mergesort(actual, Integer::compare);
		assertEquals(expected, actual);
	}

	@Test
	public void mergesortListComparatorStability() throws Exception
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
