package advanced_class_03;

/**
 * Created by Paul Z on 2020/6/30
 */
public class MorrisTraversal {

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

    private static void morrisTraversalPre(TreeNode root){
        if (root == null)
            return;
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if (mostRight.right == null){
                    mostRight.right = cur;
                    System.out.print(cur.val+" ");
                    cur = cur.left;
                    continue;
                }
                else
                    mostRight.right = null;
            }
            else
                System.out.print(cur.val+" ");
            cur = cur.right;
        }
        System.out.println();
    }

    private static void morrisTraversalIn(TreeNode root){
        if (root == null)
            return;
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                else
                    mostRight.right = null;
            }
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    private static void morrisTraversalPost(TreeNode root){
        if (root == null)
            return;
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(root);
        System.out.println();
    }

    private static void printEdge(TreeNode root){
        TreeNode next = root.right;
        root.right = null;
        while (next != null){
            TreeNode tmp = next.right;
            next.right = root;
            root = next;
            next = tmp;
        }
        next = root;
        while (next != null){
            System.out.print(next.val + " ");
            next = next.right;
        }
        next = root.right;
        root.right = null;
        while (next != null){
            TreeNode tmp = next.right;
            next.right = root;
            root = next;
            next = tmp;
        }
    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(2);
        head1.right = new TreeNode(3);
        head1.left.left = new TreeNode(4);
        head1.left.right = new TreeNode(5);
        head1.right.left = new TreeNode(6);
        head1.right.right = new TreeNode(7);
        printTree(head1);
        System.out.println("二叉树Morris先序遍历结果：");
        morrisTraversalPre(head1);
        System.out.println("=================================");
        System.out.println("二叉树Morris中序遍历结果：");
        morrisTraversalIn(head1);
        System.out.println("=================================");
        System.out.println("二叉树Morris后序遍历结果：");
        morrisTraversalPost(head1);
        System.out.println("=================================");
    }
}

