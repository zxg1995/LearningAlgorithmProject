package ForOfferQuestions;


import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * Created by Paul Z on 2020/1/31
 * 题目要求：
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicationListNode {

    static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }

    //打印单链表
    private static void printSingleLinkedList(ListNode head) {
        System.out.print("Single Linked List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static ListNode deleteDuplication(ListNode pHead){
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode pre = null;
        ListNode cur = pHead;
        while (cur != null){
            ListNode post = cur.next;
            while (post != null && post.val == cur.val)
                post = post.next;
            if (post == cur.next){
                pre = cur;
            } else if (pre == null){
                pHead = post;
            } else {
                pre.next = post;
            }
            cur = post;
        }
        return pHead;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next.next = new ListNode(5);
        printSingleLinkedList(head1);
        printSingleLinkedList(deleteDuplication(head1));
    }
}
