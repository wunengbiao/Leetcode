package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wunengbiao on 2017/3/31.
 */
public class Binary_Tree_Postorder_Traversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;

        Stack<TreeNode> st=new Stack<>();
        TreeNode cur=root;
        while(!st.isEmpty() || cur!=null){
            if(cur!=null){
                st.push(cur);
                res.add(0,cur.val);
                cur=cur.right;
            }else {
                cur=st.pop();
                cur=cur.left;
            }
        }

        return res;
    }

    public static void main(String[] args){
        Binary_Tree_Postorder_Traversal_145 s=new Binary_Tree_Postorder_Traversal_145();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);

        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;

        System.out.println(s.postorderTraversal(node1));
    }
}
