package leet;

/**
 * Created by wunengbiao on 2016/12/16.
 */
public class Solution99 {

    TreeNode mistake1;
    TreeNode mistake2;
    TreeNode pre=null;
    public void recoverTree(TreeNode root) {
        inorder_traversal(root);
        if(mistake1!=null && mistake2!=null){
            int temp;
            temp=mistake1.val;
            mistake1.val=mistake2.val;
            mistake2.val=temp;
        }
    }

    public void inorder_traversal(TreeNode root){
        if(root==null) return;
        if(root.left!=null)
            inorder_traversal(root.left);

        if(pre!=null && pre.val>root.val){
            if(mistake1==null){
                mistake1=pre;
                mistake2=root;
            }else{
                mistake2=root;
            }
        }

        pre=root;
        if(root.right!=null)
            inorder_traversal(root.right);
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(4);
        TreeNode node1=new TreeNode(5);
        TreeNode node2=new TreeNode(1);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(2);

        root.left=node1;
        node1.left=node2;
        node1.right=node3;
        root.right=node4;

        System.out.println(root);
        Solution99 s=new Solution99();
        s.recoverTree(root);
        System.out.println(root);
    }
}
