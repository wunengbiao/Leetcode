package leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/15.
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return  result;

        List<TreeNode> tmp=new ArrayList<>();
        tmp.add(root);
        List<Integer> cur_level;
        List<TreeNode> next_level;

        boolean flag=true;
        while(tmp.size()!=0){
            cur_level=new ArrayList<>();
            next_level=new ArrayList<>();
            if(flag==false) Collections.reverse(tmp);
//            Collections.reverse(tmp);
            for(TreeNode node:tmp){
                cur_level.add(node.val);
                if(flag==false){
                    if(node.right!=null)
                        next_level.add(node.right);
                    if(node.left!=null)
                        next_level.add(node.left);
                }else{
                    if(node.left!=null)
                        next_level.add(node.left);
                    if(node.right!=null)
                        next_level.add(node.right);
                }

            }
            result.add(cur_level);
            tmp.clear();
            if(flag==true){
                tmp.addAll(next_level);
            }else{
                Collections.reverse(next_level);
                tmp.addAll(next_level);
            }

            if(flag==true){
                flag=false;
            }else{
                flag=true;
            }

        }
        return result;
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

        Solution103 s=new Solution103();
        List<List<Integer>>result=s.zigzagLevelOrder(t1);
        System.out.println(result);
    }
}
