package ForOfferQuestions;

import ForExam.Main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Paul Z on 2020/9/4
 */
public class RemoveInvalidParentheses {

    private HashSet<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(')
                left++;
            else if (s.charAt(i) == ')') {
                right = left == 0 ? right + 1 : right;
                left = left == 0 ? left : left-1;
            }
        }
        dfs(s, 0, 0, 0, left, right, new StringBuilder());
        return new ArrayList<>(set);
    }

    private void dfs(String s, int index, int lC, int rC, int lW, int rW, StringBuilder sb) {
        if (index == s.length()){
            if (lW == 0 && rW == 0)
                set.add(sb.toString());
        }
        else {
            char c = s.charAt(index);
            int len = sb.length();
            if ((c == '(' && lW > 0) || (c == ')' && rW > 0))
                dfs(s, index+1, lC, rC, lW-(c == '(' ? 1 : 0), rW-(c == ')' ? 1 : 0), sb);
            sb.append(c);
            if (c != '(' && c != ')')
                dfs(s, index+1, lC, rC, lW, rW, sb);
            else if (c == '(')
                dfs(s, index+1, lC+1, rC, lW, rW, sb);
            else if (rC < lC)
                dfs(s, index+1, lC, rC+1, lW, rW, sb);
            sb.deleteCharAt(len);
        }
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses r = new RemoveInvalidParentheses();
        String s = "()(a()))()b((";
        System.out.println(r.removeInvalidParentheses(s));
    }

}
