package basic_class_03;

/**
 * Created by Paul Z on 2019/12/24
 */
public class PrintCommonList {

    static class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    private static void printCommon(Node head1, Node head2){
        while (head1 != null && head2 != null){
            if (head1.value == head2.value){
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
            else if (head1.value < head2.value)
                head1 = head1.next;
            else
                head2 = head2.next;
        }
    }

    private static void printSingleLinkedList(Node head) {
        System.out.print("Single Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node h1 = new Node(1);
        Node node1 = new Node(2);
        h1.next = node1;
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printSingleLinkedList(h1);
        printSingleLinkedList(node2);
        printCommon(h1, node2);
    }
}
