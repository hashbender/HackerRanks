package com.nick.algorithms.sorting;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 
 * @author nick.hansen
 *
 */
public class InsertionSortPart2 {
	public static void insertionSortPart2(int[] ar) {
		IntStream.range(1, ar.length).forEach(in -> {
			printArray(sortSub(ar, in));
		});
	}

	static public int[] sortSub(int[] ar, int endIndex) {
		if (endIndex == 0)
			return ar;
		int end = endIndex;
		int insertVal = ar[end];
		end--;
		boolean swapped = false;
		while (insertVal < ar[end]) {
			if (end - 1 < 0) {
				ar[end + 1] = ar[end];
				ar[end] = insertVal;
				swapped = true;
				break;
			}
			ar[end + 1] = ar[end];
			end--;
		}
		if (!swapped)
			ar[end + 1] = insertVal;
		return ar;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertionSortPart2(ar);

	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
