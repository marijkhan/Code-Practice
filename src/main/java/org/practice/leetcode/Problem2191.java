package org.practice.leetcode;


import java.util.Arrays;

public class Problem2191 {

	/*
1773. Count Items Matching a Rule

You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.

The ith item is said to match the rule if one of the following is true:

ruleKey == "type" and ruleValue == typei.
ruleKey == "color" and ruleValue == colori.
ruleKey == "name" and ruleValue == namei.
Return the number of items that match the given rule.

Example 1:

Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
Output: 1
Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
Example 2:

Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
Output: 2
Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.


Constraints:

1 <= items.length <= 104
1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
ruleKey is equal to either "type", "color", or "name".
All strings consist only of lowercase letters.
	 */
	public static void main(String[] args) {
		int[] m = {8,9,4,0,2,1,3,5,7,6};
		int[] n = {991,338,38};
		Arrays.stream(sortJumbled(m, n)).forEach(i -> System.out.println(i));
	}
	// mapping = [3, 1]
	// nums = [11, 10]
	public static int[] sortJumbled(int[] mapping, int[] nums) {
		int[] convertedNums = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			String digits = Integer.toString(nums[i]); // "11"
			String newNumber = "";
			for (int j = 0; j < digits.length(); j++) {
				int newDigit = mapping[Character.getNumericValue(digits.charAt(j))];
				newNumber += Integer.toString(newDigit);
			}
			convertedNums[i] = Integer.parseInt(newNumber);
		}

		return sort(convertedNums, nums);
	}

	// [1, 9, 5, 7]
	public static int[] sort(int[] mapped, int[] nums) {
		int n = nums.length;
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (mapped[j] > mapped[j + 1]) {
					// Swap nums[j] and nums[j + 1]
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					swapped = true;
				}
			}
			// If no two elements were swapped by inner loop, then the array is sorted
			if (!swapped) break;
		}
		return nums;
	}
	// mapping = [8,9,4,0,2,1,3,5,7,6],
	// nums = [991,338,38]
	// step 1 = [661,007, 07]
	// step 2 = [07, 007, 661]

}
