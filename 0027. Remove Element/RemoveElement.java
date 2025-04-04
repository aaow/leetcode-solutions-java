import java.util.Arrays;

/**
 * @projectName: leetcode-solutions-java
 * @package: PACKAGE_NAME
 * @className: RemoveElement
 * @author: chz
 * @description: TODO
 * @date: 2025/4/4 18:51
 * @version: 1.0
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int x : nums) {
            if (x != val) {
                nums[k++] = x;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7};
        int i = new RemoveElement().removeElement(nums, 3);
        System.out.println(Arrays.toString(nums)+", i="+i);
    }
}
