package Tree;

/**
 * Created by wunengbiao on 2017/5/7.
 */
public class Convert_BST_to_Greater_Tree_538 {

    public int sum=0;
    public TreeNode convertBST(TreeNode root) {
        sumOfTree(root);
        return root;
    }

    public void sumOfTree(TreeNode root){
        if(root!=null){
            sumOfTree(root.right);
            sum+=root.val;
            root.val=sum;
            sumOfTree(root.left);


        }
    }

    public static void main(String[] args){
        Convert_BST_to_Greater_Tree_538 s=new Convert_BST_to_Greater_Tree_538();

        TreeNode root=new TreeNode(5);
        TreeNode left=new TreeNode(2);
        TreeNode right=new TreeNode(13);

        root.left=left;
        root.right=right;

        System.out.println(root);
        TreeNode newNode=s.convertBST(root);
        System.out.println(newNode);
    }
}
