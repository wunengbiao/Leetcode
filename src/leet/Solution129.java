package leet;

/**
 * Created by wunengbiao on 2016/10/18.
 */
public class Solution129 {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return sum;
        preOrder(root,0);
        return sum;
    }

    public void preOrder(TreeNode root,int cur){
        if(root.left==null && root.right==null) sum+=(cur*10+root.val);
        cur=cur*10+root.val;
        if(root.left!=null) preOrder(root.left,cur);
        if(root.right!=null) preOrder(root.right,cur);
    }
}
