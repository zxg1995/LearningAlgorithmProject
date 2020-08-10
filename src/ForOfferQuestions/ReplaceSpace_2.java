package ForOfferQuestions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Paul Z on 2020/1/12
 */
public class ReplaceSpace_2 {

    public static String replaceSpace(StringBuffer str) {
        if (str == null)
            return null;
        char[] cs = str.toString().toCharArray();
        List<String> list = new LinkedList<>();
        for (char c : cs){
            if (c == ' ')
                list.add("%20");
            else
                list.add(String.valueOf(c));
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list)
            sb.append(s);
        return sb.toString();
    }


    public static void main(String[] args) {
        StringBuffer s = new StringBuffer(" ddd dd dd  dd ");
        System.out.println(replaceSpace(s));
    }
}
