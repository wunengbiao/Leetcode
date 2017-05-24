package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wunengbiao on 2017/5/8.
 */
public class BinaryTree_Zigzag_Level_Order_Traversal_103 {

    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return res;
        helper(root,0);

        for(int i=1;i<res.size();i+=2){
            Collections.reverse(res.get(i));
        }
        return res;
    }

    public void helper(TreeNode root,int level){

        if(res.size()<level+1) res.add(new ArrayList<>());
        res.get(level).add(root.val);

        if(root.left!=null){
            helper(root.left,level+1);
        }

        if(root.right!=null){
            helper(root.right,level+1);
        }

    }

    public static void main(String[] args){
        BinaryTree_Zigzag_Level_Order_Traversal_103 s=new BinaryTree_Zigzag_Level_Order_Traversal_103();

        /*
             3
           / \
          9  20
            /  \
           15   7
   */

        TreeNode node3=new TreeNode(3);
        TreeNode node9=new TreeNode(9);
        TreeNode node20=new TreeNode(20);
        TreeNode node15=new TreeNode(15);
        TreeNode node7=new TreeNode(7);

        node3.left=node9;
        node3.right=node20;
        node20.left=node15;
        node20.right=node7;

        System.out.println(s.zigzagLevelOrder(node3));
    }
}
