package leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/16.
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
//            result.add(cur_level);

            result.add(0,cur_level);
            tmp.clear();
            tmp.addAll(next_level);
        }
//         Collections.reverse(result);
        return result;
    }
}
