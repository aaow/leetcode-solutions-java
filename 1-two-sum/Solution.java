/*
1. Two Sum
Easy
Topics
Companies
Hint
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

输入： nums = [2,7,11,15], target = 9
输出： [0,1]
解释：因为 nums[0] + nums[1] == 9，所以我们返回 [0, 1]。
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
* */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == result) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
//0ms
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i=1;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[j]+nums[j-i] == target){
                    return new int[]{j-i, j};
                }
            }
        }
        return new int[]{};
    }
}
