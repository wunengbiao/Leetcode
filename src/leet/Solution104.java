package leet;

/**
 * Created by wunengbiao on 2016/10/15.
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {

        if(root==null) return 0;
        if(root.left==null && root.right==null)
            return 1;

        int left=maxDepth(root.left);
        int right=maxDepth(root.right);

        return Math.max(left,right)+1;
    }

    public static void main(String[] args){
        TreeNode t1=new TreeNode(3);
        TreeNode t2=new TreeNode(9);
        TreeNode t3=new TreeNode(20);
        TreeNode t4=new TreeNode(15);
        TreeNode t5=new TreeNode(7);

        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;

        Solution104 s=new Solution104();
        System.out.println(s.maxDepth(t1));
    }
}
