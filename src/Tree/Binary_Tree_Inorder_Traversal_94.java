package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/4/1.
 */
public class Binary_Tree_Inorder_Traversal_94 {
    List<Integer> res=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder_travel(root);
        return res;
    }

    public void inorder_travel(TreeNode root){
        if(root==null) return;
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
    }

    public static void main(String[] args){
        Binary_Tree_Inorder_Traversal_94 s=new Binary_Tree_Inorder_Traversal_94();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);

        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;

        System.out.println(s.inorderTraversal(node1));
    }
}
