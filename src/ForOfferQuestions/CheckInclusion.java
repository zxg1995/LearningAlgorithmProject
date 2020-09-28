package ForOfferQuestions;

import java.util.HashMap;

/**
 * Created by Paul Z on 2020/8/22
 * LeetCode 567. 字符串的排列
 * 题目：
 *      给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *      换句话说，第一个字符串的排列之一是第二个字符串的子串。
 */
public class CheckInclusion {
    public static void main(String[] args) {
        CheckInclusion c = new CheckInclusion();
        String a = "adc";
        String b = "dcda";
        System.out.println(c.checkInclusion(a, b));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            s1Map.put(c, s1Map.getOrDefault(c, 0)+1);
        }
        int valid = 0;
        int l = 0;
        int r = 0;
        while (r < s2.length()){
            char c = s2.charAt(r);
            if (s1Map.containsKey(c)){
                s2Map.put(c, s2Map.getOrDefault(c, 0)+1);
                if (s1Map.get(c).equals(s2Map.get(c)))
                    valid++;
            }
            r++;
            while (r - l >= s1.length()){
                if (valid == s1Map.size())
                    return true;
                c = s2.charAt(l);
                if (s1Map.containsKey(c)){
                    if (s1Map.get(c).equals(s2Map.get(c)))
                        valid--;
                    s2Map.put(c, s2Map.get(c) - 1);
                }
                l++;
            }
        }
        return false;
    }
}
