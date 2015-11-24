package com.nick.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author nick.hansen
 *
 */
public class AVeryBigSum {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			br.readLine();
			String input = br.readLine();
			String[] longs = input.split(" ");
			long sum = 0;
			for (int i = 0; i < longs.length; i++)
				sum += Long.parseLong(longs[i]);
			System.out.println(Long.toString(sum));
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
}
