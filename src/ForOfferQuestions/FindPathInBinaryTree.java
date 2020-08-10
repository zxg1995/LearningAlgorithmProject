package ForOfferQuestions;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Paul Z on 2020/3/3
 */
public class FindPathInBinaryTree {

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

    private static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
        ArrayList<Integer> nodes = new ArrayList<>();
        int sum = 0;
        process(root, target, sum, pathList, nodes);
        pathList.sort(new myComparator());
        return pathList;
    }

    private static void process(TreeNode root, int target, int sum, ArrayList<ArrayList<Integer>> pathList, ArrayList<Integer> nodes) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                ArrayList<Integer> res = new ArrayList<>(nodes);
                res.add(root.val);
                pathList.add(res);
            }
            return;
        }
        if (sum + root.val > target)
            return;
        nodes.add(root.val);
        process(root.left, target, sum + root.val, pathList, nodes);
        process(root.right, target, sum + root.val, pathList, nodes);
        nodes.remove(nodes.size() - 1);
    }

    private static class myComparator implements Comparator<ArrayList<Integer>>{
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            return o2.size() - o1.size();
        }
    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(5);
        head1.left = new TreeNode(5);
        head1.right = new TreeNode(7);
        head1.left.left = new TreeNode(2);
        head1.left.right = new TreeNode(6);
        head1.right.left = new TreeNode(4);
        head1.right.right = new TreeNode(8);
        printTree(head1);
        ArrayList<ArrayList<Integer>> a = FindPath(head1, 12);
        System.out.println(a);
    }
}
