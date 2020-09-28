package ForExam;

import java.util.*;
public class Main {

    public static int openLock(String[] deadends, String target) {
        HashSet<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String str = queue.poll();
                if (deadSet.contains(str))
                    continue;
                if (target.equals(str))
                    return count;
                deadSet.add(str);
                for (int j = 0; j < 4; j++){
                    String upStr = upOne(str, j);
                    if (!deadSet.contains(upStr))
                        queue.offer(upStr);
                    String downStr = downOne(str, j);
                    if (!deadSet.contains(downStr))
                        queue.offer(downStr);
                }
            }
            count++;
        }
        return -1;
    }

    private static String upOne(String s, int j){
        char[] cs = s.toCharArray();
        if (cs[j] == '9')
            cs[j] = '0';
        else
            cs[j] += 1;
        return String.valueOf(cs);
    }

    private static String downOne(String s, int j){
        char[] cs = s.toCharArray();
        if (cs[j] == '0')
            cs[j] = '9';
        else
            cs[j] -= 1;
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        String[] strings = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        System.out.println(openLock(strings, target));
    }
}