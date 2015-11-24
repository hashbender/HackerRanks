package com.nick.algorithms.sorting;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 
 * @author nick.hansen
 *
 */
public class InsertIntoSorted {

	public InsertIntoSorted() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		insertIntoSorted(new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 });
	}

	public static void insertIntoSorted(int[] ar) {
		int end = ar.length - 1;
		int insertVal = ar[end];
		end--;
		boolean swapped = false;
		while (insertVal < ar[end]) {
			if (end - 1 < 0) {
				ar[end + 1] = ar[end];
				printArray(ar);
				ar[end] = insertVal;
				swapped = true;
				break;
			}
			ar[end + 1] = ar[end];
			end--;
			printArray(ar);
		}
		if (!swapped)
			ar[end + 1] = insertVal;
		printArray(ar);
	}

	public static void printArray(int[] ints) {
		Arrays.stream(ints).forEach(out -> System.out.print(out + " "));
		System.out.print('\n');
	}

}
