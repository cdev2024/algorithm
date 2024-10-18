package day03;

import java.util.HashSet;
import java.util.Set;

public class SetEx {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int maxLength = 0;
        int i = 0, j = 0;

        while (j<s.length()){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, set.size());
            } else{
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }
}
