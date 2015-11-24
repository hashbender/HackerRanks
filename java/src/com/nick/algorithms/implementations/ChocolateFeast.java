package com.nick.algorithms.implementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChocolateFeast {

	public static void solveChocolateFeast(int int1, int int2, int wrapperCost){
		int candy = int1/int2;
		int wrappers = candy;
		candy+=recurseWrappers(0, wrappers, wrapperCost);
		System.out.println(candy);
	}
	
	public static int recurseWrappers(int candy, int wrappers, int wrapperCost) {
		if (wrappers < wrapperCost)
			return candy;
		int newCandy = wrappers/wrapperCost;
		int leftOverWrappers = wrappers % wrapperCost;
		
		candy += newCandy;
		wrappers = newCandy + leftOverWrappers;
		return recurseWrappers(candy, wrappers, wrapperCost);
	}
	
	/* Tail starts here */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			br.readLine();
			String line;

			while ((line = br.readLine()) != null && line.length() > 0) {
				String[] widthArray = line.split(" ");
				int[] intArray = new int[widthArray.length];
				for (int i = 0; i < intArray.length; i++)
					intArray[i] = Integer.parseInt(widthArray[i]);

				int index1 = Integer.parseInt(line.split(" ")[0]);
				int index2 = Integer.parseInt(line.split(" ")[1]);
				int index3 = Integer.parseInt(line.split(" ")[2]);
				solveChocolateFeast(index1, index2, index3);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
