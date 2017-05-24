package Tree;

/**
 * Created by wunengbiao on 2017/5/8.
 */
public class Sum_Root_to_Leaf_Numbers_129 {

    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        helper(root,0);
        return res;
    }

    int res=0;
    public void helper(TreeNode root,int sum){
        if(root.left==null && root.right==null){
            res=res+sum*10+root.val;
            return;
        }
        if(root.left!=null)
        helper(root.left,sum*10+root.val);
        if(root.right!=null)
        helper(root.right,sum*10+root.val);
    }

    public static void main(String[] args){
        Sum_Root_to_Leaf_Numbers_129 s=new Sum_Root_to_Leaf_Numbers_129();

        TreeNode root=new TreeNode(1);
        TreeNode left=new TreeNode(2);
        TreeNode right=new TreeNode(3);

        root.left=left;
        root.right=right;

        System.out.println(s.sumNumbers(root));
    }
}
