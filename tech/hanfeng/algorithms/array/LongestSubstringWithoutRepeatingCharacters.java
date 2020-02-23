package tech.hanfeng.algorithms.array;

public class LongestSubstringWithoutRepeatingCharacters {

	public int longestSubstringWithoutRepeatingCharacters(String s) {
		if (s == null) return 0;
		
		int n = s.length(), ans = 0;
		int[] index = new int[128];  // current index of character
		
		for (int j = 0, i = 0; j < n; j++) {
			i = Math.max(index[s.charAt(j)], i);
			ans = Math.max(j - i + 1, ans);
			index[s.charAt(j)] = j + 1;
		}
		
		return ans;
	}
}
