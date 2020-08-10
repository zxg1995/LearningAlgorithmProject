package basic_class_05;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Paul Z on 2020/2/14
 */
public class UnionFind {

    static class Node{
        //随便定义
    }

    static class UnionFindSet{
        private HashMap<Node, Node> fatherMap;
        private HashMap<Node, Integer> sizeMap;

        UnionFindSet(){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        void initializeSets(List<Node> nodes){
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes){
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        Node findHead(Node node){
            Node father = fatherMap.get(node);
            if (father != node)
                father = findHead(father);
            fatherMap.put(node, father);
            return father;
        }

        boolean isSameSet(Node node1, Node node2){
            return findHead(node1) == findHead(node2);
        }

        void unionSets(Node a, Node b){
            if (a == null || b == null)
                return;
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead){
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if (aSetSize <= bSetSize){
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                }
                else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }
    }


    public static void main(String[] args) {

    }
}
