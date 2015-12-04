package com.tswift242.ciphersum.utils;

public final class CipherUtils
{
	private static int aAsciiValue = (int)'a';

	public static int cipherSum(String word) {
		int sum = 0;

		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(!Character.isLetter(c)) {
				throw new IllegalArgumentException("Input is not a word.");
			}

			sum += toAlphabeticOrdinal(c);
		}

		return sum;
	}

	public static int toAlphabeticOrdinal(char c) {
		return ((int)c - aAsciiValue + 1);
	}
}
