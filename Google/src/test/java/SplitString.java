import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SplitString {
    /*
    https://leetcode.com/discuss/interview-question/352460/Google-Online-Assessment-Questions

    Given a string S, we can split S into 2 strings: S1 and S2.
    Return the number of ways S can be split such that the number of unique characters between S1 and S2 are the same.

        Example 1:

        Input: "aaaa"
        Output: 3
        Explanation: we can get a - aaa, aa - aa, aaa- a
        Example 2:

        Input: "bac"
        Output: 0
        Example 3:

        Input: "ababa"
        Output: 2
        Explanation: ab - aba, aba - ba


     */

    @Test
    public void splitString(){
        Assert.assertEquals(countResults("aaaa"), 3);
        Assert.assertEquals(countResults("bac"), 0);
        Assert.assertEquals(countResults("ababa"), 2);

    }

    private int countResults(String str) {
        int count = 0;
        for(int i = 0; i< str.length()-1; i++){
            if(isUniqueEquals(str.substring(0, i+1), str.substring(i+1))){
                count++;
            }
        }
        return count;
    }

    public boolean isUniqueEquals(String s1, String s2){
        final Map<String, Integer> mapS1 = getStringAsMap(s1);
        final Map<String, Integer> mapS2 = getStringAsMap(s2);
        return mapS1.keySet().containsAll(mapS2.keySet()) && mapS2.keySet().containsAll(mapS1.keySet());
    }

    private  Map<String, Integer> getStringAsMap(String str) {
        final Map<String, Integer> mapS = new HashMap<>();
        for(int i = 0; i< str.length(); i++){
            mapS.put(String.valueOf(str.charAt(i)), 1);
        }
        return mapS;
    }

}
