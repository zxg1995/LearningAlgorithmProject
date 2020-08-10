package basic_class_04;

/**
 * Created by Paul Z on 2020/1/20
 */
public class SuccessorTreeNode {

    static class TreeLinkNode{
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;  //指向父节点

        TreeLinkNode(int x){
            val = x;
        }
    }

    //打印二叉树的模板
    private static void printTree(TreeLinkNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(TreeLinkNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuilder buf = new StringBuilder("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    //找到一个节点中序遍历序列的后继节点
    private static TreeLinkNode getSuccessorTreeLinkNode(TreeLinkNode pNode){
        if (pNode == null)
            return null;
        if (pNode.right != null){
            TreeLinkNode p = pNode.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {
            TreeLinkNode parent = pNode.next;
            while (parent != null && parent.left != pNode){
                pNode = parent;
                parent = pNode.next;
            }
            return parent;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode head = new TreeLinkNode(6);
        head.next = null;
        head.left = new TreeLinkNode(3);
        head.left.next = head;
        head.left.left = new TreeLinkNode(1);
        head.left.left.next = head.left;
        head.left.left.right = new TreeLinkNode(2);
        head.left.left.right.next = head.left.left;
        head.left.right = new TreeLinkNode(4);
        head.left.right.next = head.left;
        head.left.right.right = new TreeLinkNode(5);
        head.left.right.right.next = head.left.right;
        head.right = new TreeLinkNode(9);
        head.right.next = head;
        head.right.left = new TreeLinkNode(8);
        head.right.left.next = head.right;
        head.right.left.left = new TreeLinkNode(7);
        head.right.left.left.next = head.right.left;
        head.right.right = new TreeLinkNode(10);
        head.right.right.next = head.right;
        printTree(head);
        System.out.println(getSuccessorTreeLinkNode(head).val);
        System.out.println(getSuccessorTreeLinkNode(head.right).val);
        System.out.println(head.left.right.val);
        System.out.println(getSuccessorTreeLinkNode(head.left.right).val);
        System.out.println(getSuccessorTreeLinkNode(head.right.right));
    }
}
