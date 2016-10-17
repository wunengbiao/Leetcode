package leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/17.
 */
public class Solution113 {
     List<List<Integer>> result=new ArrayList<>();
     List<Integer> path=new ArrayList<>();
     public List<List<Integer>> pathSum(TreeNode root, int sum) {
         if(root==null) return result;
         pathSum(root,0,sum);
         return result;

    }

    public void  pathSum(TreeNode root,int cur,int sum){
        if(root.left==null && root.right==null){
            if(root.val+cur==sum){
                path.add(root.val);

                List<Integer> temp=new ArrayList<>();
                temp.addAll(path);
                result.add(temp);
            }else{
                path.add(root.val);
            }
            return;
        }

        cur+=root.val;
        path.add(root.val);

        if(root.left!=null) {
            pathSum(root.left, cur, sum);
            path.remove(path.size()-1);
        }


        if(root.right!=null){
           pathSum(root.right,cur,sum);
           path.remove(path.size()-1);
        }

    }
    public static void main(String[] args){

        TreeNode root=new TreeNode(1);
        TreeNode q1=new TreeNode(2);
        TreeNode q2=new TreeNode(7);
        TreeNode p1=new TreeNode(4);
        TreeNode p2=new TreeNode(5);

        root.left=q1;
        root.right=q2;
        q1.left=p1;
        q1.right=p2;
        Solution113 s=new Solution113();

        List<List<Integer>> result=s.pathSum(root,8);
        System.out.println(result);
    }
}
