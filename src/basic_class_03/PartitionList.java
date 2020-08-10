package basic_class_03;

/**
 * Created by Paul Z on 2019/12/24
 */
public class PartitionList {

    static class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    private static Node partitionList(Node head, int pivot){
        Node less = null;
        Node lessTail = null;
        Node equal = null;
        Node equalTail = null;
        Node more = null;
        Node moreTail = null;
        while (head != null){
            Node next = head.next;     //细节！若不这样处理会导致新链表尾部next部分不为空！！
            head.next = null;
            if (head.value == pivot){
                if (equal == null){
                    equal = head;
                    equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = head;
                }
            } else if (head.value < pivot){
                if (less == null){
                    less = head;
                    lessTail = head;
                } else {
                    lessTail.next = head;
                    lessTail = head;
                }
            } else {
                if (more == null){
                    more = head;
                    moreTail = head;
                } else {
                    moreTail.next = head;
                    moreTail = head;
                }
            }
            head = next;
        }

        Node res;
        if (lessTail != null){
            if (equalTail != null){
                lessTail.next = equal;
                if (moreTail != null)
                    equalTail.next = more;
            }
            else
                lessTail.next = more;
            res = less;
        } else {
            if (equalTail != null){
                res = equal;
                equalTail.next = more;
            } else {
                res = more;
            }
        }
        return res;
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
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printSingleLinkedList(head1);

        Node nh = partitionList(head1, 5);
        printSingleLinkedList(nh);
    }
}
