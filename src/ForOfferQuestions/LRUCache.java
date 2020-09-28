package ForOfferQuestions;

import java.util.*;

/**
 * Created by Paul Z on 2020/5/25
 */
public class LRUCache {

//    HashMap<Integer, Integer> map = new HashMap<>();
//    HashMap<Integer, Integer> keyToCount = new HashMap<>();
//    TreeMap<Integer, Integer> countToKey = new TreeMap<>();
//    int size;
//    int count = 0;
//
//    public LRUCache(int capacity) {
//        size = capacity;
//    }
//
//    public int get(int key) {
//        if (map.containsKey(key)){
//            countToKey.remove(keyToCount.get(key));
//            keyToCount.put(key, count);
//            countToKey.put(count++, key);
//            return map.get(key);
//        }
//        else
//            return -1;
//    }
//
//    public void put(int key, int value) {
//        if (map.containsKey(key)){
//            map.put(key, value);
//            countToKey.remove(keyToCount.get(key));
//            keyToCount.put(key, count);
//            countToKey.put(count++, key);
//        }
//        else {
//            if (keyToCount.size() < size){
//                map.put(key, value);
//                keyToCount.put(key, count);
//                countToKey.put(count++, key);
//            }
//            else {
//                Map.Entry<Integer, Integer> tmp = countToKey.pollFirstEntry();
//                keyToCount.remove(tmp.getValue());
//                map.remove(tmp.getValue());
//                map.put(key, value);
//                keyToCount.put(key, count);
//                countToKey.put(count++, key);
//            }
//        }
//    }

    class KVNode{
        int key;
        int value;
        KVNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, KVNode> map = new HashMap<>();
    LinkedList<KVNode> list = new LinkedList<>();
    int size;

    public LRUCache(int size){
        this.size = size;
    }

    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        int v = map.get(key).value;
        list.remove(map.get(key));
        put(key, v);
        return v;
    }

    public void put(int key, int value){
        if (map.containsKey(key)){
            map.get(key).value = value;
            list.remove(map.get(key));
            list.addFirst(map.get(key));
            return;
        }
        KVNode node = new KVNode(key, value);
        if (list.size() == size){
            KVNode t = list.removeLast();
            map.remove(t.key);
        }
        list.addFirst(node);
        map.put(key, node);
    }

    //使用LinkedHashMap实现LRU缓存机制
    //注意：必须重写removeEldestEntry()方法
    static Map<String, String> linkMap = new LinkedHashMap<String, String>(5, 0.75f, true){
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
            return size() > 5;
        }
    };

    public static void main(String[] args) {
        linkMap.put("1", "1");
        linkMap.put("2", "2");
        linkMap.put("3", "3");
        linkMap.put("4", "4");
        linkMap.put("5", "5");
        System.out.println(linkMap.toString());

        linkMap.put("6", "6");
        System.out.println(linkMap.toString());
        linkMap.get("3");
        System.out.println(linkMap.toString());
    }
}
