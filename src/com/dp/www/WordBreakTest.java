package com.dp.www;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreakTest {

	public static void main(String[] args) {
		String[] input = { "i", "like", "sam", "sung", "samsung", "mobile",
				"ice", "cream", "icecream", "man", "go", "mango" };
		List<String> inputs = Arrays.asList(input);
		String word = "ilikesamsung";
		System.out.println(createSegments(word));
		List<String> segments = createSegments(word);
		Set<String> common = segments.stream()
				.filter(segment -> inputs.contains(segment))
				.collect(Collectors.toSet());
		System.out.println(common);
	}

	public static List<String> createSegments(String word) {
		List<String> segments = new ArrayList<String>();
		int len = word.length();
		for (int i = 0; i < len; i++) {
			String str = String.valueOf(word.charAt(i));

			Optional<String> lastOp = segments.stream().reduce(
					(first, second) -> second);
			segments.add(str);
			if (lastOp.isPresent()) {
				String last = lastOp.get();
				int ll = last.length();
				for (int x = ll - 1; x >= 0; x--) {
					String sub = last.substring(x);
					segments.add(sub + str);
				}
			}
		}
		return segments;
	}
}
