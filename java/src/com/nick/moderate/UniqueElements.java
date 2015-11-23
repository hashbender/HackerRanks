package com.nick.moderate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * in: File containing a list of sorted integers, comma delimited, one per line. E.g. 
 * 
 * @author nick.hansen
 *
 */
public class UniqueElements {

	public static void main(String[] args) throws IOException {
		// START boilerplate
		//File file = new File(args[0]);
		//BufferedReader buffer = new BufferedReader(new FileReader(file));
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = buffer.readLine()) != null && line.length() > 0) {
			line = line.trim();
			// END boilerplate
			// Process line of input Here
			Set<String> set = new LinkedHashSet<String>(Arrays.asList(line.split(",")));
			StringBuilder outLine = new StringBuilder();
			for (String s : set)
				outLine.append(s + ",");
			outLine.deleteCharAt(outLine.length() - 1);
			System.out.println(outLine.toString());
		}
	}

}
