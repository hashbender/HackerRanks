package com.nick.algorithms.implementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author nick.hansen
 *
 */
public class FindDigits {

	static void solveFindDigits(int digits) {
		int digitCount = 0;
		String digitString = Integer.toString(digits);
		for (char c : digitString.toCharArray()) {
			int digit = Character.getNumericValue(c);
			if (digit <= 0)
				continue;
			if (digits % digit == 0)
				digitCount++;
		}
		System.out.println(digitCount);
	}

	/* Tail starts here */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			br.readLine();
			String line;
			while ((line = br.readLine()) != null && line.length() > 0) {
				int toFind = Integer.parseInt(line);
				solveFindDigits(toFind);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
