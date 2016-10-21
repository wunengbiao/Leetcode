package leet;

import SouHu.Solution;

/**
 * Created by wunengbiao on 2016/10/19.
 */
public class Solution222 {

//    public int countNodes(TreeNode root) {
//        if(root==null) return 0;
//        TreeNode gen=root;
//        int sum=0;
//        while(gen!=null){
//            int left=getHeight(gen.left);
//            int right=getHeight(gen.right);
//
//            if(left>right){
//                sum+=(1<<right);
//                gen=gen.left;
//            }
//            if(left==right){
//                sum+=(1<<left);
//                gen=gen.right;
//            }
//
//        }
//        return sum;
//    }
//
//    int getHeight(TreeNode root) {
//        return root == null ? 0 : 1 + getHeight(root.left);
//    }

    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
               height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                                         : (1 << h-1) + countNodes(root.left);
    }

//    public int getHeight(TreeNode root){
//        if(root==null) return 0;
//        int left=getHeight(root.left);
//        int right=getHeight(root.right);
//        return Math.max(left,right)+1;
//    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        TreeNode p1=new TreeNode(2);
        TreeNode p2=new TreeNode(3);
        TreeNode p3=new TreeNode(4);
        TreeNode p4=new TreeNode(5);
        TreeNode p5=new TreeNode(6);

        root.left=p1;
        root.right=p2;

        p1.left=p3;
        p1.right=p4;

        p2.left=p5;

        Solution222 s=new Solution222();
        System.out.println(s.countNodes(root));
    }
}
