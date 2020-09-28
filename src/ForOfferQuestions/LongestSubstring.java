package ForOfferQuestions;

import java.util.HashSet;

/**
 * Created by Paul Z on 2020/8/22
 *  题目： LeetCode 3. 无重复字符的最长子串
 *      给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *      “滑动窗口方法应用典型题目”
 */
public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstring l = new LongestSubstring();
        String a = "abcabcbb";
        System.out.println(l.lengthOfLongestSubstring(a));
        String b = "bbbbb";
        System.out.println(l.lengthOfLongestSubstring(b));
        String c = "pwwkew";
        System.out.println(l.lengthOfLongestSubstring(c));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int r = 1;
        set.add(s.charAt(l));
        int ans = 1;
        while (r < s.length()){
            while (set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            r++;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
