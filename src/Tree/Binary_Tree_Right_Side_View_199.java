package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/5/8.
 */
public class Binary_Tree_Right_Side_View_199 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return res;
        helper(root,0);
        return res;
    }

    List<Integer> res=new ArrayList<>();
    public void helper(TreeNode root,int level){
        if(root==null) return;
        if(res.size()<level+1) res.add(root.val);

        helper(root.right,level+1);
        helper(root.left,level+1);
    }

    public static void main(String[] args){
        /*
        *
               1            <---
             /   \
            2     3         <---
             \     \
              5     4       <---
        * */

        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);

        node1.left=node2;
        node1.right=node3;
        node2.right=node5;
        node3.right=node4;

        Binary_Tree_Right_Side_View_199 s=new Binary_Tree_Right_Side_View_199();
        System.out.println(s.rightSideView(node1));
    }
}
