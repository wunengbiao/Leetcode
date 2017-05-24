package Tree;

/**
 * Created by wunengbiao on 2017/5/8.
 */
public class Count_Complete_Tree_Nodes_222 {
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
                height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                        : (1 << h-1) + countNodes(root.left);
    }

    public static void main(String[] args){
        TreeNode t1=new TreeNode(3);
        TreeNode t2=new TreeNode(9);
        TreeNode t3=new TreeNode(20);
        TreeNode t4=new TreeNode(15);
        TreeNode t5=new TreeNode(7);

        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;

        Count_Complete_Tree_Nodes_222 s=new Count_Complete_Tree_Nodes_222();
//        System.out.println(s.getHeight(t1));
    }
}
