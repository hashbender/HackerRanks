package com.nick.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SetIntersection {

	public static void main(String[] args) throws IOException {
		// START boilerplate
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		//BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = buffer.readLine()) != null && line.length() > 0) {
			line = line.trim();
			// END boilerplate
			// Process line of input Here
			List<String> sets = new ArrayList<>(Arrays.asList(line.split(";")));
			Set<String> set1 = new LinkedHashSet<String>(Arrays.asList(sets.get(0).split(",")));
			Set<String> set2 = new LinkedHashSet<String>(Arrays.asList(sets.get(1).split(",")));
			set1.retainAll(set2);
			StringBuilder outLine = new StringBuilder();
			for (String s : set1)
				outLine.append(s + ",");
			if (outLine.length() > 1) outLine.deleteCharAt(outLine.length() - 1);
			System.out.println(outLine.toString());
		}
	}

}
