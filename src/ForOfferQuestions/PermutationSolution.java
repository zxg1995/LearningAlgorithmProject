package ForOfferQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Paul Z on 2020/3/19
 */
public class PermutationSolution {

    private static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;
        ArrayList<String> strList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++)
            strList.add(str.substring(i,i+1));
        res = process(strList);
        Collections.sort(res);
        return res;
    }

    private static ArrayList<String> process(ArrayList<String> strList) {
        HashSet<String> sum = new HashSet<>();
        if (strList.isEmpty())
            return strList;
        for (int i = 0; i < strList.size(); i++){
            String c = strList.remove(i);
            ArrayList<String> sub = process(strList);
            if (sub.isEmpty())
                sum.add(c);
            else {
                for (String s : sub)
                    sum.add(c + s);
            }
            strList.add(i, c);
        }
        return new ArrayList<>(sum);
    }

    private static ArrayList<String> Permutation1(String str){
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;
        char[] cs = str.toCharArray();
        process1(res, cs, 0);
        Collections.sort(res);
        return res;
    }

    private static void process1(ArrayList<String> res, char[] cs, int i) {
        if (i == cs.length)
            res.add(String.valueOf(cs));
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < cs.length; j++){
            if (!set.contains(cs[j])){
                set.add(cs[j]);
                swap(cs, i, j);
                process1(res, cs, i + 1);
                swap(cs, i, j);
            }
        }
    }

    private static void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "abcac";
        System.out.println(Permutation(s));
        System.out.println(Permutation1(s));
    }
}
