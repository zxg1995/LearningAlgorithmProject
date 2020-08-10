package ForOfferQuestions;


/**
 * Created by Paul Z on 2020/3/11
 */
public class ReverseSentenceWords {

    private static String reverseSentence(String str){
        if (str == null || str.length() < 1)
            return "";
        String[] ss = str.split(" ");
        if (ss.length < 1)
            return str;
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length-1; i >= 0; i--){
            if (i == 0)
                sb.append(ss[i]);
            else
                sb.append(ss[i]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = " ";
        System.out.println(s.length());
        System.out.println(reverseSentence(s));
    }
}
