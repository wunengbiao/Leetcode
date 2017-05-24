package Tree;

import java.util.Stack;

/**
 * Created by wunengbiao on 2017/3/31.
 */
public class Flatten_Binary_Tree_to_Linked_List_114_2 {
    public void flatten(TreeNode root) {
        if(root==null) return;

        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode p=st.pop();

            if(p.left!=null) st.push(p.left);
            if(p.right!=null) st.push(p.right);

            p.left=null;
            if(!st.isEmpty()) p.right=st.peek();
        }

    }
}
