package com.tswift242.ciphersum;

import com.tswift242.ciphersum.history.HistoryStore;
import com.tswift242.ciphersum.utils.CipherUtils;

import java.util.Set;
import java.util.Scanner;

public class CipherSum
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HistoryStore historyStore = new HistoryStore();

		while(true) {
			System.out.print("Enter a word: ");
			String word = scan.nextLine();
			word = word.toLowerCase(); // standardize casing

			try {
				int sum = CipherUtils.cipherSum(word);
				System.out.println("Letter-numeric sum: " + sum);

				Set<String> matchingWords = historyStore.recordWordSum(word, sum);
				if(!matchingWords.isEmpty()) {
					System.out.print("Words with matching sums: ");
					for(String matchingWord : matchingWords) {
						System.out.print(matchingWord + " ");
					}
					System.out.println();
				}
			} catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

			System.out.println();
		}
	}
}
