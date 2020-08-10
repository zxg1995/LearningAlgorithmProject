package basic_class_05;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Paul Z on 2020/2/11
 */
public class RandomPool {

    static class Pool<K>{
        private HashMap<K, Integer> map1;
        private HashMap<Integer, K> map2;
        private int size;

        Pool(){
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            size = 0;
        }

        void insert(K key){
            if (!map1.containsKey(key)) {
                map1.put(key, size);
                map2.put(size, key);
                size ++;
            }
        }

        K getRandom(){
            if (size == 0)
                return null;
            Random r = new Random();
            return map2.get(r.nextInt(size));
        }

        void delete(K key){
            if (size == 0 || !map1.containsKey(key))
                return;
            map2.put(map1.get(key), map2.get(size - 1));
            map1.put(map2.get(size - 1), map1.get(key));
            size --;
            map1.remove(key);
            map2.remove(size);
        }
    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        pool.delete("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
    }
}
