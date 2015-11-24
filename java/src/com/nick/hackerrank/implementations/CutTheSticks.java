package com.nickh.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CutTheSticks {


	public static void solveCutTheSticks(int[] array){
		boolean hasCuts = true;
		while (hasCuts) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < array.length; i++) {
				if (array[i] < min && array[i] > 0)
					min = array[i];
			}
			boolean foundCuts = false;
			int numCuts = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] > 0) {
					foundCuts = true;
					numCuts ++;
					array[i] -= min;
				}
			}
			if (!foundCuts)
				hasCuts = false;
			if (numCuts > 0)
				System.out.println(numCuts);
		}
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
			solveCutTheSticks(intArray);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
