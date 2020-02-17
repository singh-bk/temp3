package com.dp.www;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreakTest {

	public static void main(String[] args) {
		final String[] input = { "i", "like", "sam", "sung", "samsung", "mobile",
				"ice", "cream", "icecream", "man", "go", "mango" };
		final List<String> inputs = Arrays.asList(input);
		final String word = "ilikesamsung";
		System.out.println(createSegments(word));
		final List<String> segments = createSegments(word);
		final Set<String> common = segments.stream()
				.filter(segment -> inputs.contains(segment))
				.collect(Collectors.toSet());
		System.out.println(common);
	}

	public static List<String> usingBits(String word){
	    final List<String> op = new ArrayList<String>();
	    final char[] ch = word.toCharArray();
	    final int len = ch.length;
	    final int total = 1<<len;
	    
	    return op;
	}
	
	public static List<String> createSegments(String word) {
		final List<String> segments = new ArrayList<String>();
		final int len = word.length();
		for (int i = 0; i < len; i++) {
			final String str = String.valueOf(word.charAt(i));

			final Optional<String> lastOp = segments.stream().reduce(
					(first, second) -> second);
			segments.add(str);
			if (lastOp.isPresent()) {
				final String last = lastOp.get();
				final int ll = last.length();
				for (int x = ll - 1; x >= 0; x--) {
					final String sub = last.substring(x);
					segments.add(sub + str);
				}
			}
		}
		return segments;
	}
}
