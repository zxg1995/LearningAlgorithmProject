package basic_class_07;

/**
 * Created by Paul Z on 2020/2/14
 */
public class TrieTree {

    static class TrieNode{
        int path;
        int end;
        TrieNode[] next;

        TrieNode(){
            path = 0;
            end = 0;
            next = new TrieNode[26];
        }
    }

    static class Trie{
        private TrieNode root;

        Trie(){
            root = new TrieNode();
        }

        void insert(String str){
            if (str == null)
                return;
            char[] cs = str.toCharArray();
            TrieNode node = root;
            int index;
            for (char c : cs){
                index = c - 'a';
                if (node.next[index] == null)
                    node.next[index] = new TrieNode();
                node = node.next[index];
                node.path ++;
            }
            node.end ++;
        }

        void delete(String str){
            if (search(str) == 0)
                return;
            char[] cs = str.toCharArray();
            TrieNode node = root;
            int index;
            for (char c : cs){
                index = c - 'a';
                if (--node.next[index].path == 0){
                    node.next[index] = null;
                    return;
                }
                node = node.next[index];
            }
            node.end --;
        }

        //返回字符串的个数
        int search(String str){
            if (str == null)
                return 0;
            char[] cs = str.toCharArray();
            TrieNode node = root;
            int index;
            for (char c : cs){
                index = c - 'a';
                if (node.next[index] == null)
                    return 0;
                node = node.next[index];
            }
            return node.end;
        }

        int prefixNumber(String str){
            if (str == null)
                return 0;
            char[] cs = str.toCharArray();
            TrieNode node = root;
            int index;
            for (char c : cs){
                index = c -'a';
                if (node.next[index] == null)
                    return 0;
                node = node.next[index];
            }
            return node.path;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));
    }
}
