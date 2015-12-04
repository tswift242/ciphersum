package com.tswift242.ciphersum.history;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class HistoryStore
{
	private final Map<Integer, Set<String>> wordSums = new HashMap<>();

	public Set<String> recordWordSum(String word, int sum) {
		// after this, we'll have a mapping for sum in wordSums regardless
		if(!wordSums.containsKey(sum)) {
			wordSums.put(sum, new LinkedHashSet<String>());
		}

		// all words which hash to sum
		Set<String> words = wordSums.get(sum);

		// all words which hash to sum EXCEPT the provided word
		// need to make a copy in order to prevent the call to add() below from modifying this list
		Set<String> matchingWords = new LinkedHashSet<>();
		for(String matchingWord : words) {
			matchingWords.add(matchingWord);
		}

		// add new word
		words.add(word);

		return matchingWords;
	}
}
