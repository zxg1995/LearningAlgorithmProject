package ForOfferQuestions;

import java.util.ArrayList;

/**
 * Created by Paul Z on 2020/1/13
 */
public class PrintListFromTailToHead_3 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null)
            return null;
        ArrayList<Integer> al = new ArrayList<>();
        ListNode rear = null;
        ListNode prior = listNode.next;
        while (prior != null){
            listNode.next = rear;
            rear = listNode;
            listNode = prior;
            prior = prior.next;
        }
        listNode.next = rear;
        while (listNode != null){
            al.add(listNode.val);
            listNode = listNode.next;
        }
        return al;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(7);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(8);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(2);
        head1.next.next.next.next.next.next = new ListNode(5);

        System.out.println(printListFromTailToHead(head1));
    }
}
