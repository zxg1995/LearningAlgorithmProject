package ForOfferQuestions;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Paul Z on 2020/8/24
 *
 *  LeetCode 438. 找到字符串中所有字母异位词
 *  题目：
 *      给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *      字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *      说明：
 *          字母异位词指字母相同，但排列不同的字符串。
 *          不考虑答案输出的顺序。
 */
public class FindAnagrams {
    public static void main(String[] args) {
        FindAnagrams f = new FindAnagrams();
        String a = "abaacbabc";
        String b = "abc";
        System.out.println(f.findAnagrams(a, b));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0)
            return list;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++)
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        int l = 0;
        int r = 0;
        int valid = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(map.get(c)))
                    valid++;
            }
            r++;
            if (r - l > p.length()){
                c = s.charAt(l);
                if (window.containsKey(c)) {
                    window.put(c, window.get(c) - 1);
                    if (window.get(c) < map.get(c))
                        valid--;
                }
                l++;
            }
            if (valid == map.size())
                list.add(l);
        }
        return list;
    }
}
