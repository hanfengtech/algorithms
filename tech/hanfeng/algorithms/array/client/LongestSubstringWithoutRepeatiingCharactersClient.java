package tech.hanfeng.algorithms.array.client;

import tech.hanfeng.algorithms.array.LongestSubstringWithoutRepeatingCharacters;

public class LongestSubstringWithoutRepeatiingCharactersClient {

	/*
	 * @output 
	 * 
	 * 3
	 * 1
	 * 3
	 * 0
	 * 1
	 * 0
	 * 
	 */
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(solution.longestSubstringWithoutRepeatingCharacters("abcabcbb"));
		System.out.println(solution.longestSubstringWithoutRepeatingCharacters("bbbbb"));
		System.out.println(solution.longestSubstringWithoutRepeatingCharacters("pwwkew"));
		System.out.println(solution.longestSubstringWithoutRepeatingCharacters(""));
		System.out.println(solution.longestSubstringWithoutRepeatingCharacters("a"));
		System.out.println(solution.longestSubstringWithoutRepeatingCharacters(null));
			
	}
}
