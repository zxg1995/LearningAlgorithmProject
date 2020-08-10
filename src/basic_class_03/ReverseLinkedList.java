package basic_class_03;

/**
 * Created by Paul Z on 2019/12/23
 */
public class ReverseLinkedList {

    //单链表节点
    static class SNode{
        int value;
        SNode next;

        SNode(int value){
            this.value = value;
        }
    }

    //双链表节点
    static class DNode{
        int value;
        DNode pre;
        DNode next;

        DNode(int value){
            this.value = value;
        }
    }

    private static SNode reverseSingleList(SNode head){
        if (head == null)
            throw new NullPointerException("head指针不能为空");
        SNode forward = head.next;
        SNode last = head;
        while (forward != null){
            SNode tmp = forward.next;
            forward.next = last;
            last = forward;
            forward = tmp;
        }
        head.next = null;
        return last;
    }

    private static void printSingleLinkedList(SNode head) {
        System.out.print("Single Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static DNode reverseDoubleList(DNode head){
        if (head == null)
            throw new NullPointerException("head指针不能为空");
        while (head.next != null){
            DNode next = head.next;
            head.next = head.pre;
            head.pre = next;
            head = next;
        }
        DNode next = head.next;
        head.next = head.pre;
        head.pre = next;
        return head;
    }

    private static void printDoubleLinkedList(DNode head){
        System.out.print("Double Linked List: ");
        DNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.pre;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SNode s1 = new SNode(1);
        SNode s2 = new SNode(2);
        s1.next = s2;
        s2.next = new SNode(3);
        printSingleLinkedList(s1);
        SNode ns = reverseSingleList(s1);
        printSingleLinkedList(ns);

        DNode d1 = new DNode(1);
        DNode d2 = new DNode(2);
        DNode d3 = new DNode(3);
        DNode d4 = new DNode(4);
        d1.next = d2;
        d2.next = d3;
        d3.next = d4;
        d4.pre = d3;
        d3.pre = d2;
        d2.pre = d1;
        printDoubleLinkedList(d1);
        DNode nd = reverseDoubleList(d1);
        printDoubleLinkedList(nd);
    }
}
