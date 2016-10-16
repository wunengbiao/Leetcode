package leet;

import SouHu.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/15.
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return  result;

        List<TreeNode> tmp=new ArrayList<>();
        tmp.add(root);
        List<Integer> cur_level;
        List<TreeNode> next_level;

        while(tmp.size()!=0){
            cur_level=new ArrayList<>();
            next_level=new ArrayList<>();
            for(TreeNode node:tmp){
                cur_level.add(node.val);
                if(node.left!=null)
                    next_level.add(node.left);
                if(node.right!=null)
                    next_level.add(node.right);
            }
            result.add(cur_level);
            tmp.clear();
            tmp.addAll(next_level);
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode t1=new TreeNode(6);
        TreeNode t2=new TreeNode(9);
        TreeNode t3=new TreeNode(20);
        TreeNode t4=new TreeNode(15);
        TreeNode t5=new TreeNode(7);

        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;

        Solution102 s=new Solution102();
        List<List<Integer>>result=s.levelOrder(t1);
        System.out.println(result);
    }
}
