package Tree;

/**
 * Created by wunengbiao on 2017/3/31.
 */
public class Recover_Binary_Search_Tree_99 {

    public void recoverTree(TreeNode root) {
        inorder_travel(root);
        if(mistake1!=null && mistake2!=null){
            int tmp=mistake1.val;
            mistake1.val=mistake2.val;
            mistake2.val=tmp;
        }

    }

    private TreeNode mistake1;
    private TreeNode mistake2;
    private TreeNode pre=null;

    public void inorder_travel(TreeNode root){
        if(root==null) return;
        if(root.left!=null)
            inorder_travel(root.left);
        if(pre!=null && pre.val>root.val){
            if(mistake1==null){
                mistake1=pre;
                mistake2=root;
            }else{
                mistake2=root;
            }
        }
        pre=root;

        if(root.right!=null){
            inorder_travel(root.right);
        }
    }

}
