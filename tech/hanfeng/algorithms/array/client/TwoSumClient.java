package tech.hanfeng.algorithms.array.client;

import java.util.Arrays;
import tech.hanfeng.algorithms.array.TwoSum;

public class TwoSumClient {

	public static void main(String[] args) {
		int[] nums = {1, 5, 8, 9};
		System.out.println(Arrays.toString(new TwoSum().twoSum(nums, 10)));
		
		int[] nums2 = {1, 5, 8, 9};
		System.out.println(Arrays.toString(new TwoSum().twoSum(nums2, 16)));
		
	}
}
