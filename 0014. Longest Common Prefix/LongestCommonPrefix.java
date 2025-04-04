import java.util.Arrays;

/**
 * @Author: chz
 * @Date: 2025/3/25 18:17
 * @Description: TODO
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters if it is non-empty.
 **/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // Sort the array of strings
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));

        // Get the first and last strings after sorting
        String first = strs[0];
        String last = strs[strs.length - 1];
        int minLength = Math.min(first.length(),
                last.length());

        // Find the common prefix between the first
        // and last strings
        int i = 0;
        while (i < minLength &&
                first.charAt(i) == last.charAt(i)) {
            i++;
        }

        // Return the common prefix
        return first.substring(0, i);

    }

    public static void main(String[] args) {
        String[] strs = {"floawker", "flow", "flo","flowww"};
        System.out.println("a:"+new LongestCommonPrefix().longestCommonPrefix(strs));
    }

}
