package basic_class_03;

import java.util.HashMap;

/**
 * Created by Paul Z on 2019/12/26
 */
public class CopyRandomList {

    static class Node{
        int value;
        Node next;
        Node rand;

        Node(int value){
            this.value = value;
        }
    }

    private static Node copyMethodOne(Node head){
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null){
            map.put(p, new Node(p.value));
            p = p.next;
        }
        p = head;
        while (p != null){
            Node cp = map.get(p);
            cp.next = map.get(p.next);
            cp.rand = map.get(p.rand);
            p = p.next;
        }
        return map.get(head);
    }

    private static Node copyMethodTwo(Node head){
        if (head == null)
            return null;
        Node p = head;
        Node q = head.next;
        while (q != null){
            Node tmp = new Node(p.value);
            p.next = tmp;
            tmp.next = q;
            p = q;
            q = q.next;
        }
        p.next = new Node(p.value);

        p = head;
        q = head.next;
        while (q.next != null){
            q.rand = p.rand == null ? null : p.rand.next;
            p = q.next;
            q.next = p.next;
            q = q.next;
        }
        q.rand = p.rand == null ? null : p.rand.next;

        return head.next;
    }

    private static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1;
        Node res2;

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyMethodOne(head);
        printRandLinkedList(res1);
        res2 = copyMethodTwo(head);
        printRandLinkedList(res2);
        System.out.println("=========================");
    }
}
