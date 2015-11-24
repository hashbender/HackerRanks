package com.nick.algorithms.implementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @author nick.hansen
 *
 */
public class AngryProfessorSolution {

	public static void solveClassProblem(int minNumberStudents,
			int[] arrivalTimes) {

		int numOnTimeStudents = 0;
		for (int arrivalTime : arrivalTimes) {
			if (arrivalTime <= 0)
				numOnTimeStudents++;
			if (numOnTimeStudents >= minNumberStudents) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	/* Tail starts here */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			br.readLine();
			String line;
			while ((line = br.readLine()) != null && line.length() > 0) {
				int minNumStudents = Integer.parseInt(line.split(" ")[1]);

				int[] ints = Arrays.stream(br.readLine().split(" "))
						.mapToInt(n -> Integer.parseInt(n)).toArray();

				solveClassProblem(minNumStudents, ints);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
