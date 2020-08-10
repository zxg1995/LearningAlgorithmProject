package ForOfferQuestions;

/**
 * Created by Paul Z on 2020/2/16
 */
public class SubstructureOfTree {

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

    //输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    private static boolean HasSubtree(TreeNode root1,TreeNode root2){
        if (root1 == null || root2 == null)
            return false;
        if (root1.val == root2.val){
            if (root2.left == null && root2.right == null)
                return true;
            else if (root2.left == null) {
                if (!HasSubtree(root1.right, root2.right))
                    return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
                return true;
            }
            else if (root2.right == null) {
                if (!HasSubtree(root1.left, root2.left))
                    return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
                return true;
            }
            else {
                if (!(HasSubtree(root1.left, root2.left) && HasSubtree(root1.right, root2.right)))
                    return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
                return true;
            }
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(8);
        head1.left = new TreeNode(8);
        head1.right = new TreeNode(7);
        head1.left.left = new TreeNode(9);
        head1.left.right = new TreeNode(2);
        head1.left.right.left = new TreeNode(4);
        head1.right.left = new TreeNode(6);
        head1.right.right = new TreeNode(8);
        printTree(head1);
        TreeNode head2 = new TreeNode(8);
        head2.left = new TreeNode(9);
        head2.right = new TreeNode(2);
        printTree(head2);
        System.out.println(HasSubtree(head1, head2));
    }
}
