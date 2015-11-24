package com.nick.quicksort;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Quicksort2 {

	public Quicksort2() {
		// TODO Auto-generated constructor stub
	}

	static void quickSort(int[] ar) {
		sort(ar, 0, ar.length);
		printArray(ar);
	}
	
	static void sort(int[] ar, int left, int right){
		if (right - left == 0 ){
			return;
		}
		int mid = ((right - left)/2) + left;
		int pivot = ar[mid];
		
		int[] leftList = Arrays.stream(ar).filter(in -> in <= pivot).toArray();
		int[] rightList = Arrays.stream(ar).filter(in -> in > pivot).toArray();
		System.arraycopy(leftList, 0, ar, 0, leftList.length);
		System.arraycopy(rightList, 0, ar, leftList.length, rightList.length);

		sort(ar, left, mid);
		sort(ar, mid+1, right);
		
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		quickSort(ar);
	}

}
