package leet;

import SouHu.Solution;

/**
 * Created by wunengbiao on 2016/10/17.
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        Integer cur=0;
        return DFS(root,cur,sum);

    }

    public boolean DFS(TreeNode root,Integer cur,int sum){
        if(root==null) return false;
        if(root.left==null && root.right==null){
            if(root.val+cur==sum) return true;
        }
        return DFS(root.left,cur+root.val,sum) || DFS(root.right,cur+root.val,sum);
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        TreeNode left=new TreeNode(2);
        root.right=left;

        Solution112 s=new Solution112();
        boolean result=s.hasPathSum(root,3);
        System.out.println(result);
    }
}
