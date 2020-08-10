package basic_class_04;

/**
 * Created by Paul Z on 2020/1/28
 */
public class BalancedTree {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
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

    static class Output{
        boolean isBalanced;
        int height;

        Output(boolean isBalanced, int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    private static Output judgeBalancedTree(TreeNode head){
        if (head == null)
            return new Output(true, 0);
        Output left = judgeBalancedTree(head.left);
        Output right = judgeBalancedTree(head.right);
        if (left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1)
            return new Output(true, Math.max(left.height, right.height) + 1);
        else
            return new Output(false, 0);
    }

    public static void main(String[] args) {
        System.out.println("=================================");
        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(2);
        head1.right = new TreeNode(3);
        head1.left.left = new TreeNode(4);
        head1.left.right = new TreeNode(5);
        head1.right.left = new TreeNode(6);
        head1.right.right = new TreeNode(7);
        printTree(head1);
        Output output1 = judgeBalancedTree(head1);
        System.out.println(output1.isBalanced);
        System.out.println(output1.height);
        System.out.println("=================================");
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.left.left.left.right =new TreeNode(12);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
        printTree(head);
        Output output2 = judgeBalancedTree(head);
        System.out.println(output2.isBalanced);
        System.out.println(output2.height);
    }
}
