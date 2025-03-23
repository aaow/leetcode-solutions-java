/**
 * @Author: chz
 * @Date: 2025/3/21 14:03
 * @Description: TODO
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * <p>
 * Constraints:
 *
 * Follow up: Could you solve it without converting the integer to a string?
 **/
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int rev = reverse(x);
        return x == rev;
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10)
                return 0;
            if (rev < Integer.MIN_VALUE / 10)
                return 0;
            rev = rev * 10 + pop;
            System.out.println("rev: " + rev);
        }
        return rev;
    }

    //4ms
    public boolean isPalindrome2(int x) {

        int copy = x;
        int flip = 0;
        int multiple = 10;

        while(copy > 0){
            flip = (copy % 10) + (flip * multiple);
            System.out.println(flip);
            copy /= 10;
        }

        if(flip == x){
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        int a = 243169342;
        boolean palindrome = new PalindromeNumber().isPalindrome2(a);
        System.out.println(palindrome);
    }
}
