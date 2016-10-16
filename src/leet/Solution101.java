package leet;

/**
 * Created by wunengbiao on 2016/10/15.
 */
public class Solution101 {
     public boolean isSymmetric(TreeNode root) {

         return isSymmetric(root,root);

    }

    public boolean isSymmetric(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;

        if(p.val!=q.val) return false;

        return isSymmetric(p.left,q.right) && isSymmetric(p.right,q.left);
    }
}
