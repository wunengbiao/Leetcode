package Tree;

/**
 * Created by wunengbiao on 2017/3/31.
 */
public class Binary_Tree_Maximum_Path_Sum_124 {
    public int maxPathSum(TreeNode root) {
        inorder_travel(root);
        return max;
    }

    int max=Integer.MIN_VALUE;
    public void inorder_travel(TreeNode root){
        if(root==null) return;
        inorder_travel(root.left);
        inorder_travel(root.right);

        int left=root.left==null?0:root.left.val;
        int right=root.right==null?0:root.right.val;

        int cur=0;
        if(left>0) cur+=left;
        if(right>=0) cur+=right;
        max=Math.max(cur+root.val,max);
        root.val=Math.max(left,right)>0?Math.max(left,right)+root.val:root.val;
    }

    public static void main(String[] args){
        Binary_Tree_Maximum_Path_Sum_124 s=new Binary_Tree_Maximum_Path_Sum_124();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(-4);
        TreeNode node5=new TreeNode(5);

        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        System.out.println(s.maxPathSum(node1));

    }
}
