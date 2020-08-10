package basic_class_03;

import java.util.HashSet;

/**
 * Created by Paul Z on 2019/12/27
 */
public class ListIntersectProblem {

    static class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    private static Node judgeListIntersect(Node head1, Node head2){
        if (head1 == null || head2 == null)
            return null;
        Node loop1 = judgeListHasLoop2(head1);
        Node loop2 = judgeListHasLoop2(head2);
        if (loop1 == null && loop2 == null)
            return judgeNoLoopListIntersect(head1, head2);
        else if (loop1 != null && loop2 != null)
            return judgeListWithLoopIntersect(head1, loop1, head2, loop2);
        else
            return null;
    }

    private static Node judgeListHasLoop1(Node head){
        HashSet<Node> set = new HashSet<>();
        Node p = head;
        while (p != null){
            if (!set.add(p))
                break;
            p = p.next;
        }
        return p;
    }

    private static Node judgeListHasLoop2(Node head){
        if (head == null)
            return null;
        Node fast = head;
        Node slow = head;
        while (fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (fast.next == null)
            return null;
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    private static Node judgeNoLoopListIntersect(Node head1, Node head2){
        Node p1 = head1;
        Node p2 = head2;
        int len1 = 0;
        int len2 = 0;
        while (p1.next != null){
            len1 ++;
            p1 = p1.next;
        }
        len1 ++;
        while (p2.next != null){
            len2 ++;
            p2 = p2.next;
        }
        len2 ++;
        if (p1 != p2)
            return null;
        p1 = head1;
        p2 = head2;
        if (len1 > len2){
            for (int i = 0; i < len1-len2; i++)
                p1 = p1.next;
            while (p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }
        } else {
            for (int i = 0; i < len2-len1; i++)
                p2 = p2.next;
            while (p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return p1;
    }

    private static Node judgeListWithLoopIntersect(Node head1, Node loop1, Node head2, Node loop2){
        if (loop1 == loop2){
            Node p1 = head1;
            Node p2 = head2;
            int len1 = 0;
            int len2 = 0;
            while (p1 != loop1){
                len1 ++;
                p1 = p1.next;
            }
            while (p2 != loop2){
                len2 ++;
                p2 = p2.next;
            }
            p1 = head1;
            p2 = head2;
            if (len1 > len2){
                for (int i = 0; i < len1-len2; i++)
                    p1 = p1.next;
                while (p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
            } else {
                for (int i = 0; i < len2-len1; i++)
                    p2 = p2.next;
                while (p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
            }
            return p1;
        } else {
            Node cur = loop1.next;
            while (cur != loop1){
                if (cur == loop2)
                    return loop1;
                cur = cur.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(judgeListIntersect(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(judgeListIntersect(head1, head2).value);

        // 0->9->8->6->7->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(judgeListIntersect(head1, head2).value);
    }
}
