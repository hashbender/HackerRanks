package com.nickh.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SherlockBeast {

	static void solveSherlockProblem(int in) {
		int tempIn = in;
		StringBuilder builder = new StringBuilder();
		while(tempIn > 0){
			if (tempIn % 3 == 0)
				break;
			tempIn -= 5;
		}
		if (tempIn < 0)
			builder.append("-1");
		else {
			for (int i = 0; i < tempIn; i++)
				builder.append("5");
			for (int i = 0; i < in - tempIn; i++)
				builder.append("3");
		}
		String s = builder.toString();
		assert s.length() == in;
		System.out.println(s);
	}
	
	/* Tail starts here */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			br.readLine();
			String line;
			while ((line = br.readLine()) != null && line.length() > 0) {
				int toFind = Integer.parseInt(line);
				solveSherlockProblem(toFind);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
