package Tree;

import java.util.Stack;

/**
 * Created by wunengbiao on 2017/3/31.
 */
public class PreTravel {
    public void travel(TreeNode root){
        if(root==null) return;

        TreeNode cur=root;
        Stack<TreeNode> st=new Stack<>();
        while(cur!=null || !st.isEmpty()){
            if(cur!=null){
                System.out.println(cur.val);
                st.push(cur);
                cur=cur.left;
            }else{
                cur=st.pop();
                cur=cur.right;
            }
        }
    }

    public static void main(String[] args){
        PreTravel s=new PreTravel();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);

        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        s.travel(node1);
    }
}
