package ForOfferQuestions;

/**
 * Created by Paul Z on 2020/2/26
 */
public class FirstNotRepeatingChar {

    private static int process(String str){
        if (str == null || str.length() == 0)
            return -1;
        if (str.length() == 1)
            return 0;
        str = "0" + str;
        char[] cs = str.toCharArray();
        int[] array = new int[52];
        for (int i = 1; i < cs.length; i++){
            int j = cs[i] - 'a';
            int k = cs[i] - 'A';
            if (j >= 0)
                array[j] = array[j] == 0 ? i : -1;
            else
                array[26 + k] = array[26 + k] == 0 ? i : -1;
        }
        int res = array.length;
        for (int x : array){
            if (x > 0 && x < res)
                res = x;
        }
        return res - 1;
    }

    public static void main(String[] args) {
        String s = "zAsWsszmdmdmsmdmsmslaslaps";
        System.out.println(process(s));
    }
}
