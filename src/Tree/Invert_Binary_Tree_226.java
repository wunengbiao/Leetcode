package Tree;

/**
 * Created by wunengbiao on 2017/5/7.
 */
public class Invert_Binary_Tree_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;

        if(root!=null);

        TreeNode left=root.left;
        TreeNode right=root.right;

        root.left=right;
        root.right=left;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
