package com.nick.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author nick.hansen
 *
 */
public class DiagonalDifference {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			br.readLine();
			String input;

			int sum1 = 0;
			int sum2 = 0;
			int sumCount = 0;

			while ((input = br.readLine()) != null) {
				String[] ints = input.split(" ");
				sum1 += Integer.parseInt(ints[sumCount]);
				sum2 += Integer.parseInt(ints[ints.length - sumCount - 1]);
				sumCount++;
			}
			System.out.println(Integer.toString(Math.abs(sum1 - sum2)));
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

}
