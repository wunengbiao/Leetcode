package leet;

/**
 * Created by wunengbiao on 2017/4/1.
 */
public class Same_Tree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
