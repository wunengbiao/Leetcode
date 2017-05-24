package Tree;

import java.util.Stack;

/**
 * Created by wunengbiao on 2017/3/31.
 */
public class PostOrder {

    public void travel(TreeNode root){
        if(root==null) return;

        TreeNode cur=null;
        Stack<TreeNode> st=new Stack<>();
        TreeNode pre=null;
        st.push(root);

        while(!st.isEmpty()){
            cur=st.peek();

            if(cur.left==null && cur.right==null || (pre!=null && pre==cur.right || pre==cur.left)){
                System.out.println(cur.val);
                st.pop();
                pre=cur;
            }else{
                if(cur.right!=null) st.push(cur.right);
                if(cur.left!=null) st.push(cur.left);
            }


        }
    }

    public static void main(String[] args){
        PostOrder s=new PostOrder();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);

        node1.left=node2;
        node2.left=node3;
        node1.right=node4;
        node4.right=node5;

        s.travel(node1);
    }
}
