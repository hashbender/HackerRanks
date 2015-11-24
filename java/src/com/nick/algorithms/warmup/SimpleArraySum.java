package com.nick.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author nick.hansen
 *
 */
public class SimpleArraySum {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String input;
			br.readLine();
			input = br.readLine();
			String[] ints = input.split(" ");
			int sum = 0;
			for (int i = 0; i < ints.length; i++) {
				if (ints[i] == null)
					continue;
				sum += Integer.parseInt(ints[i]);
			}
			System.out.println(Integer.toString(sum));
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
}