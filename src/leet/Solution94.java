package leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/10.
 */
public class Solution94 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> result=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return result;
        inOrder(root);
        return result;
    }


    public void inOrder(TreeNode root){
//        while(root!=null){
//            inOrder(root.left);
//            result.add(root.val);
//            inOrder(root.right);
//        }

        if(root.left!=null){
            inOrder(root.left);
        }

        result.add(root.val);

        if(root.right!=null){
            inOrder(root.right);
        }
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=null;

        TreeNode right=new TreeNode(2);
        root.right=right;

        right.right=null;

        TreeNode left=new TreeNode(3);
        left.left=null;
        left.right=null;

        right.left=left;

        List<Integer> result=new ArrayList<>();

        Solution94 s=new Solution94();
        result=s.inorderTraversal(root);
        System.out.println(result);
    }


}
