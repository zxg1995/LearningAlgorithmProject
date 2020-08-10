package advanced_class_04;

import java.util.*;

/**
 * Created by Paul Z on 2020/7/6
 *
 * LeetCode 218. 天际线问题
 */
public class BuildingOutline {

    static class Node{
        int x;
        int h;
        boolean isUp;

        Node(int x, int h, boolean isUp){
            this.x = x;
            this.h = h;
            this.isUp = isUp;
        }
    }

    private static class MyComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.x != o2.x)
                return o1.x - o2.x;
            else if (o1.isUp != o2.isUp)
                return o1.isUp ? -1 : 1;
            else
                return 0;
        }
    }

    private static List<List<Integer>> getSkyLine(int[][] buildings){
        PriorityQueue<Node> heap = new PriorityQueue<>(new MyComparator());
        for (int[] building : buildings) {
            heap.add(new Node(building[0], building[2], true));
            heap.add(new Node(building[1], building[2], false));
        }
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        TreeMap<Integer, Integer> posMap = new TreeMap<>();
        int ph = 0;
        while (!heap.isEmpty()){
            Node a = heap.poll();
            if (treeMap.containsKey(a.h)){
                if (a.isUp)
                    treeMap.put(a.h, treeMap.get(a.h)+1);
                else{
                    if (treeMap.get(a.h) == 1)
                        treeMap.remove(a.h);
                    else
                        treeMap.put(a.h, treeMap.get(a.h)-1);
                }
            }
            else {
                if (a.isUp)
                    treeMap.put(a.h, 1);
            }
            if (treeMap.isEmpty())
                posMap.put(a.x, 0);
            else
                posMap.put(a.x, treeMap.lastKey());
        }
        int preH = 0;
        for (Integer key : posMap.keySet()){
            int curH = posMap.get(key);
            if (curH != preH){
                List<Integer> list = new ArrayList<>();
                list.add(key);
                list.add(curH);
                ans.add(list);
                preH = curH;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10},{3, 7, 15},{5,12,12},{15,20,10},{19,24,8}};
        System.out.println(getSkyLine(buildings));
    }
}
