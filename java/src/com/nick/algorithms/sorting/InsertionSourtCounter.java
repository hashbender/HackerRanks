package com.nick.algorithms.sorting;

import java.util.Scanner;

/**
 * 
 * @author nick.hansen
 *
 */
public class InsertionSourtCounter {
	public static int insertionSort(int[] A) {
		int moves = 0;
		for (int i = 1; i < A.length; i++) {
			int value = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] > value) {
				moves++;
				A[j + 1] = A[j];
				j = j - 1;
			}
			A[j + 1] = value;
		}
		System.out.println(moves);
		return moves;
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		in.close();
		insertionSort(ar);
	}
}
