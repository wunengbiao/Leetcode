package leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/18.
 */
public class Solution145 {
    List<Integer> result=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return result;
    }

    public void postOrder(TreeNode root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        result.add(root.val);
    }
}
