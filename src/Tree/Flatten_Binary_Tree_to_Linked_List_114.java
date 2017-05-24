package Tree;

/**
 * Created by wunengbiao on 2017/3/31.
 */
public class Flatten_Binary_Tree_to_Linked_List_114 {
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root!=null){
            flatten(root.left);
            flatten(root.right);
        }

        if(root.left==null) return;
        TreeNode p=root.left;
        while(p.right!=null) p=p.right;
        p.right=root.right;
        root.right=root.left;
        root.left=null;
    }

    public static void main(String[] args){

    }
}
