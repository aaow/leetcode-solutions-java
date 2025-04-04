import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chz
 * @Date: 2025/3/23 15:24
 * @Description: TODO
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = 'III'
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = 'LVIII'
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 *
 * Input: s = 'MCMXCIV'
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 **/
public class RomantoInteger {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        // first value will always have the maximum number, thus
        // we can safely put it into res variable.
        int res = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--)
        {
            // if previous
            if (map.get(s.charAt(i + 1)) <= map.get(s.charAt(i)))
                res += map.get(s.charAt(i));
            else
                res -= map.get(s.charAt(i));
        }

        return res;
    }
    public int romanToInt2(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            if(x=='I'){
                if(i+1<s.length() && s.charAt(i+1)=='V'){
                    count+=4;i++;}
                else if(i+1<s.length() && s.charAt(i+1)=='X'){
                    count+=9;i++;}
                else
                    count+=1;
            }
            else if(x=='X'){
                if(i+1<s.length() && s.charAt(i+1)=='L'){
                    count+=40;i++;}
                else if(i+1<s.length() && s.charAt(i+1)=='C'){
                    count+=90;i++;}
                else
                    count+=10;
            }
            else if(x=='C'){
                if(i+1<s.length() && s.charAt(i+1)=='D'){
                    count+=400;i++;}
                else if(i+1<s.length() && s.charAt(i+1)=='M'){
                    count+=900;i++;}
                else
                    count+=100;
            }
            else if(x=='V')
                count+=5;
            else if(x=='L')
                count+=50;
            else if(x=='D')
                count+=500;
            else if(x=='M')
                count+=1000;
        }
        return count;
    }
    public int romanToInt3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int total = 0;
        int part = 0;
        int max = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            int cur = map.get(s.charAt(i));
            max = Math.max(max, cur);
            if(cur < max) total -= cur;
            else total += cur;
        }
        return total;
    }

    public static void main(String[] args) {
        String s = "MIMMLXIV";
        int sum = new RomantoInteger().romanToInt(s);
        int sum2 = new RomantoInteger().romanToInt2(s);
        System.out.println(sum2);
    }
}
