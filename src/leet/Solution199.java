package leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/19.
 */
public class Solution199 {

    List<Integer> result=new ArrayList<>();
     public List<Integer> rightSideView(TreeNode root) {
         if(root==null) return result;
         List<TreeNode>cur_level=new ArrayList<>();
         cur_level.add(root);
         while(cur_level.size()!=0){
             List<TreeNode> next_level=new ArrayList<>();
             TreeNode last=cur_level.get(cur_level.size()-1);
             result.add(last.val);
             for(TreeNode parent:cur_level){
                 if(parent.left!=null)
                     next_level.add(parent.left);
                 if(parent.right!=null)
                     next_level.add(parent.right);
             }

             cur_level.clear();
             cur_level=next_level;
         }

         return result;
    }
}
