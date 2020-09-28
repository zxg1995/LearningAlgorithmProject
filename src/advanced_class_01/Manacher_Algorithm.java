package advanced_class_01;

/**
 * Created by Paul Z on 2020/5/26
 */
public class Manacher_Algorithm {
    public static void main(String[] args) {
        String a = "sadadapos";
        System.out.println(TraditionalMethod(a));
    }

    //利用双指针的传统方法，时间复杂度为O(n^2)
    private static String TraditionalMethod(String s){
        String res = "";
        for (int i = 0; i < s.length(); i++){
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private static String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }

    private static String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        char[] chars = new char[s.length()*2+1];
        for (int i = 0; i < chars.length; i++){
            chars[i] = (i & 1) == 0 ? '#' : s.charAt(i/2);
        }
        int[] arr = new int[chars.length];
        int r = 0;
        int c = 0;
        int ansL = 0;
        int ansR = 0;
        for (int i = 1; i < chars.length; i++){
            if (i > r)
                arr[i] = 0;
            else
                arr[i] = Math.min(arr[2*c-i], r-i);
            while (i-arr[i] > -1 && i+arr[i] < chars.length){
                if (chars[i-arr[i]] == chars[i+arr[i]])
                    arr[i]++;
                else
                    break;
            }
            if (i+arr[i]-1 > r){
                r = i+arr[i]-1;
                c = i;
                if (2*(arr[i]-1) > ansR-ansL){
                    ansL = i - arr[i] + 1;
                    ansR = i + arr[i] - 1;
                }
            }
        }
        return s.substring(ansL/2, ansR/2);
    }
}
