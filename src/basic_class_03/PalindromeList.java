package basic_class_03;

import java.util.Stack;

/**
 * Created by Paul Z on 2019/12/24
 */
public class PalindromeList {

    static class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    private static boolean useStackToJudge(Node head){
        Node p = head;
        Stack<Node> stack = new Stack<>();
        while (p != null){
            stack.push(p);
            p = p.next;
        }
        while (!stack.isEmpty()){
            if (stack.pop().value != head.value)
                return false;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node h = new Node(1);
        h.next = new Node(2);
        h.next.next = new Node(2);
        //h.next.next.next = new Node(1);
        System.out.println(useStackToJudge(h));
    }
}
