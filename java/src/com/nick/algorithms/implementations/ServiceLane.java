package com.nick.algorithms.implementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author nick.hansen
 *
 */
public class ServiceLane {

	public ServiceLane() {
		// TODO Auto-generated constructor stub
	}

	public static void solveServiceLane(int[] array, int index1, int index2) {
		int min = 3;
		for (int i = index1; i <= index2; i++) {
			if (min > array[i])
				min = array[i];
		}
		System.out.println(min);
	}

	/* Tail starts here */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			br.readLine();
			String line;
			line = br.readLine();
			String[] widthArray = line.split(" ");
			int[] intArray = new int[widthArray.length];
			for (int i = 0; i < intArray.length; i++)
				intArray[i] = Integer.parseInt(widthArray[i]);
			while ((line = br.readLine()) != null && line.length() > 0) {
				int index1 = Integer.parseInt(line.split(" ")[0]);
				int index2 = Integer.parseInt(line.split(" ")[1]);
				solveServiceLane(intArray, index1, index2);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
