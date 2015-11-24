package com.nick.insertionsort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GetIndex {

	public GetIndex() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int toFind;
		try {
			toFind = Integer.parseInt(br.readLine());
			br.readLine();
			String[] inputArray = br.readLine().split(" ");
			int[] ints = Arrays.stream(inputArray).mapToInt(n -> Integer.parseInt(n)).toArray();
			for (int index = 0; index < ints.length; index++){
				if (ints[index] == toFind) System.out.print(index);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
