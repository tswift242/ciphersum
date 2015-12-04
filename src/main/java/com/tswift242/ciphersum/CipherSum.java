package com.tswift242.ciphersum;

import com.tswift242.ciphersum.utils.CipherUtils;

import java.util.Scanner;

public class CipherSum
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.println("Enter a word: ");
			String word = scan.nextLine();

			try {
				int sum = CipherUtils.cipherSum(word);
				System.out.println("Letter-numeric sum: " + sum);
			} catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

			System.out.println();
		}
	}
}
