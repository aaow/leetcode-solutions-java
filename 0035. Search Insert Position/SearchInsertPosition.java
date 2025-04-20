import java.util.Arrays;

/**
 * @projectName: leetcode-solutions-java
 * @package: PACKAGE_NAME
 * @className: SearchInsertPosition
 * @author: chz
 * @description: TODO
 * @date: 2025/4/20 22:48
 * @version: 1.0
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * 给定一个不同整数的排序数组和目标值,如果找到目标,则返回索引。 如果没有,请将索引返回,如果按顺序插入。
 *
 * You must write an algorithm with O(log n) runtime complexity.
 * 必须编写具有 O(log n) 运行时复杂性的算法。
 *
 *
 *
 * Example 1:
 * 例1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * 例2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * 例3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 *
 * Constraints:
 * 制约因素:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * nums 包含按升序排序的不同值。
 * -104 <= target <= 104
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        int target = 2;
        int result = new SearchInsertPosition().searchInsert(nums, target);
        System.out.println(result);

    }
}
