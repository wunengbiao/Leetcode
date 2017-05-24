package leet;

/**
 * Created by wunengbiao on 2017/5/8.
 *
 *
 */
public class Find_Bottom_Left_Tree_Value_513 {

    int maxLevel=0;
    int res;
    public int findBottomLeftValue(TreeNode root) {
        res=root.val;
        helper(root,0);
        return res;
    }

    public void helper(TreeNode root,int level){

        if(root==null) return;
        helper(root.left,level+1);
        if(level>maxLevel){
            res=root.val;
            maxLevel=level;
        }
        helper(root.right,level+1);
    }

    public static void main(String[] args){
        /*
        * Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

           Output:
                    7
        * */
        Find_Bottom_Left_Tree_Value_513 s=new Find_Bottom_Left_Tree_Value_513();

        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node3.left=node5;
        node5.left=node7;
        node3.right=node6;

        System.out.println(s.findBottomLeftValue(node1));
    }
}
