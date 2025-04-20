import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode-solutions-java
 * @package: PACKAGE_NAME
 * @className: RabbitsinForest
 * @author: chz
 * @description: TODO
 * @date: 2025/4/20 14:34
 * @version: 1.0
 * There is a forest with an unknown number of rabbits. We asked n rabbits "How many rabbits have the same color as you?" and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.
 *
 * Given the array answers, return the minimum number of rabbits that could be in the forest.
 *
 *
 *
 * Example 1:
 *
 * Input: answers = [1,1,2]
 * Output: 5
 * Explanation:
 * The two rabbits that answered "1" could both be the same color, say red.
 * The rabbit that answered "2" can't be red or the answers would be inconsistent.
 * Say the rabbit that answered "2" was blue.
 * Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
 * The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
 * Example 2:
 *
 * Input: answers = [10,10,10]
 * Output: 11
 *
 *
 * Constraints:
 *
 * 1 <= answers.length <= 1000
 * 0 <= answers[i] < 1000
 */
public class RabbitsinForest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int answer : answers) {
            frequencyMap.put(answer, frequencyMap.getOrDefault(answer, 0) + 1);
        }
        int totalRabbits = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int otherRabbits = entry.getKey();
            int frequencyOfClaim = entry.getValue();
            int groupsOfRabbits = (int) Math.ceil(frequencyOfClaim / ((otherRabbits + 1) * 1.0));
            totalRabbits += groupsOfRabbits * (otherRabbits + 1);
        }
        return totalRabbits;
    }
    public int numRabbits1(int[] answers) {

        int n = answers.length;
        int[] count = new int[1000];

        int ans = 0;
        for(int x:answers){
            if(++count[x] == 1)
                ans += x + 1;
            if(count[x] == x + 1)
                count[x] = 0;
        }

        return ans;
    }
    public int numRabbits2(int[] answers) {
        int[] cnt = new int[1001];
        int ans = 0;

        for (int a : answers) {
            cnt[a]++;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) {
                ans += (int)Math.ceil((double)cnt[i] / (i + 1)) * (i + 1);
            }
        }
        return ans;
    }
    //?
    public int numRabbits3(int[] answers) {
        Arrays.sort(answers);
        int result = 0;
        int n = answers.length;
        int i = 0;
        while(i<n){
            if(answers[i]==0){
                result++;
                i++;
                continue;
            }
            if(i+answers[i] < n  && answers[i + answers[i]] == answers[i]){
                result += (answers[i]+1);
                i = answers[i]+i+1;
            }else{
                result += (answers[i]+1);
                int j = i;
                while(j<n && answers[j]==answers[i]){
                    j++;
                }
                i=j;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ans = {10,10,10};
        int result = new RabbitsinForest().numRabbits3(ans);
        System.out.println(result);
    }
}
