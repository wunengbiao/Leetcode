package leet;

/**
 * Created by wunengbiao on 2016/10/17.
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;

        int[] min=new int[1];
        min[0]=Integer.MAX_VALUE;
        minLength(root,1,min);
        return min[0] ;
    }

    public void minLength(TreeNode root,int cur,int[] min){

        if(root.left==null && root.right==null){
            min[0]=Math.min(min[0],cur);
            return;
        }
        if(root.left!=null){
            minLength(root.left,cur+1,min);
        }
        if(root.right!=null){
            minLength(root.right,cur+1,min);
        }
    }

    public static void main(String[] args){
//        TreeNode root=new TreeNode(1);
//        TreeNode left=new TreeNode(2);
//        root.right=left;
        TreeNode root=new TreeNode(1);
        TreeNode q1=new TreeNode(2);
        TreeNode q2=new TreeNode(3);
        TreeNode p1=new TreeNode(4);
        TreeNode p2=new TreeNode(5);

        root.left=q1;
        root.right=q2;
        q1.left=p1;
        q1.right=p2;

        Solution111 s=new Solution111();
        int result=s.minDepth(root);
        System.out.println(result);
    }
}
