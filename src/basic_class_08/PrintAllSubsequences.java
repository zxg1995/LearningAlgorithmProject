package basic_class_08;

/**
 * Created by Paul Z on 2020/2/23
 *
 * 打印一个字符串的全部子序列，包括空字符串
 */
public class PrintAllSubsequences {

    private static void printAllSubsequences(String str){
        char[] cs = str.toCharArray();
        process(cs, 0);
    }

    private static void process(char[] cs, int i) {
        if (i == cs.length){
            System.out.println(String.valueOf(cs));
            return;
        }
        process(cs, i + 1);
        char tmp = cs[i];
        cs[i] = 0;
        process(cs, i + 1);
        cs[i] = tmp;
    }

    public static void main(String[] args) {
        String s = "abc";
        printAllSubsequences(s);
    }
}
