package Tree;

import java.util.Map;

/**
 * Created by wunengbiao on 2017/3/29.
 */
public class Balanced_Binary_Tree_110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        if(Math.abs(left-right)>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root){
        if(root==null) return 1;
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        return Math.max(left,right)+1;
    }
}
