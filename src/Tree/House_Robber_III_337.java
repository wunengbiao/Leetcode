package Tree;

/**
 * Created by wunengbiao on 2017/5/8.
 */
public class House_Robber_III_337 {

    public int rob(TreeNode root) {
        if (root == null) return 0;
        int val = 0;

        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }

    public static void main(String[] args){
        /*
             3
            / \
           4   5
          / \   \
         1   3   1
        * */

        House_Robber_III_337 s=new House_Robber_III_337();

        TreeNode root=new TreeNode(3);
        TreeNode node1=new TreeNode(4);
        TreeNode node2=new TreeNode(5);
        TreeNode node3=new TreeNode(1);
        TreeNode node4=new TreeNode(3);
        TreeNode node5=new TreeNode(1);

        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.right=node5;

        System.out.println(s.rob(root));
    }


}
