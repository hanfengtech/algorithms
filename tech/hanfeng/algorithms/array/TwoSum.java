package tech.hanfeng.algorithms.array;

import java.util.Map;
import java.util.HashMap;

/**
 * @problem
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * @example
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * 
 * return [0, 1].
 * 
 * @time_complexity 
 * O(N)
 *
 * @space_comlexity
 * O(N)
 *
 * @difficulty
 * Easy
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			} else {
				map.put(nums[i], i);
			}
		}

		throw new IllegalArgumentException("No two sum solution");
	}
}
