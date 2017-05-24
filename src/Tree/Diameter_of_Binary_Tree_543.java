package Tree;

/**
 * Created by wunengbiao on 2017/5/7.
 */
public class Diameter_of_Binary_Tree_543 {
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        lenghtOfTree(root);
        return res-1<0?0:res-1;
    }

    public int lenghtOfTree(TreeNode root){

        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;

        int left=lenghtOfTree(root.left);
        int right=lenghtOfTree(root.right);

        res=Math.max(res,left+right+1);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args){
        Diameter_of_Binary_Tree_543 s=new Diameter_of_Binary_Tree_543();
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(5);

        root.left=node1;
        root.right=node2;

        node1.left=node3;
        node1.right=node4;

        System.out.println(root);

        System.out.println(s.diameterOfBinaryTree(root));
    }
}
