package tech.hanfeng.algorithms.array.client;

import java.util.Arrays;
import tech.hanfeng.algorithms.array.TwoSum;

public class TwoSumClient {

	/**
	 * @output
	 * 
	 *  [0, 1]
	 *  Exception in thread "main" java.lang.IllegalArgumentException: No two sum solution
	 *          at tech.hanfeng.algorithms.array.TwoSum.twoSum(TwoSum.java:40)
	 *          at tech.hanfeng.algorithms.array.client.TwoSumClient.main(TwoSumClient.java:21)
	 */
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		System.out.println(Arrays.toString(new TwoSum().twoSum(nums, 9)));
		
		int[] nums2 = {2, 7, 11, 15};
		System.out.println(Arrays.toString(new TwoSum().twoSum(nums2, 16)));
	}
}
