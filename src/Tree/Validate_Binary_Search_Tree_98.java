package Tree;

import java.util.Stack;

/**
 * Created by wunengbiao on 2017/4/1.
 */
public class Validate_Binary_Search_Tree_98 {
    public boolean isValidBST(TreeNode root){
        if(root==null) return true;
        if(root.left!=null && root.val<=root.left.val) return false;
        if(root.right!=null && root.val>=root.right.val) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
//    public boolean isValidBST(TreeNode root) {
//        if(root==null) return true;
//
//        TreeNode pre=null;
//        Stack<TreeNode> st=new Stack<>();
//        TreeNode cur=root;
//
//        while(!st.isEmpty() || cur!=null){
//            if(cur!=null){
//                st.push(cur);
//                cur=cur.left;
//            }else{
//                cur=st.pop();
//                if(pre!=null && pre.val>=cur.val) return false;
//                pre=cur;
//                cur=cur.right;
//            }
//
//        }
//        return true;
//    }

    public static void main(String[] args){

        Validate_Binary_Search_Tree_98 s=new Validate_Binary_Search_Tree_98();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(1);
        node1.left=node2;

        System.out.println(s.isValidBST(node1));

    }

}
