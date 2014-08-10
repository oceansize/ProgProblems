package problems;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Vector;

public class MySelectionSort {

	public static <T extends Comparable> void sort(AbstractList<T> values) {
		int length = values.size(), comparisonResult;
		T minValue = null;
		T currValue = null;
		int minValueIndex = 0;

		for (int j = 0; j < length; j++) {
			minValue = values.get(j);
			for (int i = j+1; i < length; i++) {
				currValue = values.get(i);
				comparisonResult = minValue.compareTo(currValue);
				if (comparisonResult == 0) {
					continue;
				} else if (comparisonResult > 0) {
					minValue = currValue;
					minValueIndex = i;
				}
			}
			swap(values, j, minValueIndex, minValue);
		}
	}

	/**
	 * 
	 * @param <T>
	 */
	public static <T extends Comparable> void swap(AbstractList<T> values, int minIndex, int swapIndex, T minValue) {
		values.set(swapIndex, values.get(minIndex));
		values.set(minIndex, minValue);
	}

	public static <T extends Comparable> int compare(T a, T b) {
		return a.compareTo(b);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = new In(args[0]).readAllInts();
		AbstractList<Integer> vectorValues = new Vector<Integer>();
		for (int i = 0; i < values.length; i++) {
			vectorValues.add(values[i]);
		}
		
		MySelectionSort.sort(vectorValues);
		System.out.println(vectorValues.toString());
	}

}
