package Tree;

import java.util.Map;

/**
 * Created by wunengbiao on 2017/3/29.
 */
public class Balanced_Binary_Tree_110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        node1.left = node3;

        System.out.println(getHeight(root));
    }
}
