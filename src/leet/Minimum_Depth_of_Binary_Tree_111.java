package leet;

/**
 * Created by wunengbiao on 2017/5/8.
 */
public class Minimum_Depth_of_Binary_Tree_111 {
    public int minDepth(TreeNode root) {

        if(root==null) return 0;

        int left=minDepth(root.left);
        int right=minDepth(root.right);

        if(left==0) return right+1;
        if(right==0) return left+1;
        return Math.min(left,right)+1;
    }

    public static void main(String[] args){
        Minimum_Depth_of_Binary_Tree_111 s=new Minimum_Depth_of_Binary_Tree_111();

        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
//        TreeNode node3=new TreeNode(3);
//        TreeNode node4=new TreeNode(4);
//        TreeNode node5=new TreeNode(5);
//        TreeNode node6=new TreeNode(6);
//        TreeNode node7=new TreeNode(7);

        node1.left=node2;
//        node1.right=node3;
//        node2.left=node4;
//        node3.left=node5;
//        node5.left=node7;
//        node3.right=node6;

        System.out.println(s.minDepth(node1));
    }
}
