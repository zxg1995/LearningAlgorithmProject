package advanced_class_01;

/**
 * Created by Paul Z on 2020/5/26
 */
public class KMP_Algorithm {
    public static void main(String[] args) {
        String a = "asdfdfdfssdf";
        String b = "dfss";
        System.out.println(strStr(a, b));
    }

    private static int strStr(String haystack, String needle){
        if (haystack == null || needle == null)
            return -1;
        if (needle.length() == 0)
            return 0;
        int[] next = getNextArray(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()){
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            else if (next[j] == -1){
                i++;
            }
            else {
                j = next[j];
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    private static int[] getNextArray(String str){
        int[] next = new int[str.length()];
        if (str.length() == 1){
            next[0] = -1;
            return next;
        }
        next[0] = -1;
        if (str.length() == 2){
            next[1] = 0;
            return next;
        }
        next[1] = 0;
        for (int i = 2; i < str.length(); i++){
            int index = next[i-1];
            while (index > -1){
                if (str.charAt(i-1) == str.charAt(index)){
                    next[i] = index + 1;
                    break;
                }
                index = next[index];
            }
        }
        return next;
    }
}
