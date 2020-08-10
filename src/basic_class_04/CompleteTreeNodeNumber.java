package basic_class_04;

/**
 * Created by Paul Z on 2020/1/30
 */
public class CompleteTreeNodeNumber {

    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            value = x;
        }
    }

    //打印二叉树的模板
    private static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
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

    private static int getNumberOfCBT(TreeNode head){
        if (head == null)
            return 0;
        int h = 0;
        int hr = 0;
        TreeNode cur = head;
        while (cur != null) {
            cur = cur.left;
            h++;
        }
        cur = head.right;
        while (cur != null){
            cur = cur.left;
            hr++;
        }
        if (hr == h-1)
            return (int) (getNumberOfCBT(head.right) + Math.pow(2, h-1));
        else
            return (int) (getNumberOfCBT(head.left) + Math.pow(2, h-2));
    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(4);
        head1.left = new TreeNode(2);
        head1.right = new TreeNode(6);
        head1.left.left = new TreeNode(1);
        head1.left.right = new TreeNode(3);
        head1.right.left = new TreeNode(5);
        printTree(head1);
        System.out.print("完全二叉树的节点个数为：");
        System.out.println(getNumberOfCBT(head1));
        System.out.println("=================================");
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.left.left.right = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.left.right.left = new TreeNode(9);
        head.left.right.right = new TreeNode(11);
        head.right.left.left = new TreeNode(12);
        printTree(head);
        System.out.print("完全二叉树的节点个数为：");
        System.out.println(getNumberOfCBT(head));
    }
}
