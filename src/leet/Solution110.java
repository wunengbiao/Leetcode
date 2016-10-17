package leet;

/**
 * Created by wunengbiao on 2016/10/17.
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {

        if(root==null) return true;
        int left=deepLength(root.left);
        int right=deepLength(root.right);
        if(Math.abs(left-right)>1) return false;

        return isBalanced(root.right) && isBalanced(root.left);
    }

    public int deepLength(TreeNode root){

        if(root==null) return 1;

        int left=deepLength(root.left);
        int right=deepLength(root.right);
        return Math.max(left,right)+1;
    }


}
