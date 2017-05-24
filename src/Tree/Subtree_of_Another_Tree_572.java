package Tree;

/**
 * Created by wunengbiao on 2017/5/7.
 */
public class Subtree_of_Another_Tree_572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;

        if (s.val == t.val) {
            if (isSame(s, t)) return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);

    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }


}
