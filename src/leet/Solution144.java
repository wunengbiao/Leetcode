package leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/18.
 */
public class Solution144 {
    List<Integer> result=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return result;
    }

    public void preOrder(TreeNode root){
        if(root==null) return;
        result.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
