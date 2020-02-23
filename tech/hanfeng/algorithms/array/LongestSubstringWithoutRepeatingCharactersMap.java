package tech.hanfeng.algorithms.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersMap {
	public int longestSubstringWithoutRepeatingCharacters(String s) {
	   if (s == null) return 0;
	   
	   Map<Character, Integer> map = new HashMap<>();
	   
	   int n = s.length(), ans = 0;
	   
	   for (int j = 0, i = 0; j < n; j++) {
		   if (map.containsKey(s.charAt(j))) {
			   i = Math.max(map.get(s.charAt(j)), i);
		   }
		   ans = Math.max(j - i + 1,  ans);
		   map.put(s.charAt(j), j + 1);
	   }
	   
	   return ans;
	}
}
