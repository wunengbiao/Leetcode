package Tree;

/**
 * Created by wunengbiao on 2017/5/8.
 */
public class Delete_Node_in_a_BST_450 {

    public TreeNode deleteNode(TreeNode root, int key) {

        res=root;
        deleteNode(root,key,null);
        return res;
    }

    TreeNode res;
    public void deleteNode(TreeNode root,int key,TreeNode parent){
        if(root==null) return;
        if(root.val==key){

            TreeNode left=root.left;
            TreeNode right=root.right;

            if(right==null){
                if(parent==null){
                    res=left;
                }else{
                    if(parent.left==root){
                        parent.left=left;
                    }else{
                        parent.right=left;
                    }
                }

                return;
            }

            TreeNode p=right;
            while(p.left!=null){
                p=p.left;
            }
            p.left=left;

            if(parent==null){
                res=right;
            }else{
                if(parent.left==root){
                    parent.left=right;
                }else{
                    parent.right=right;
                }
            }

            return;
        }

        if(key>root.val) deleteNode(root.right,key,root);
        if(key<root.val) deleteNode(root.left,key,root);
    }

    public static void main(String[] args){
        /*
        *
                root = [5,3,6,2,4,null,7]
                key = 3

                    5
                   / \
                  3   6
                 / \   \
                2   4   7

        * */
        TreeNode node5=new TreeNode(5);
//        TreeNode node3=new TreeNode(3);
//        TreeNode node6=new TreeNode(6);
//        TreeNode node2=new TreeNode(2);
//        TreeNode node4=new TreeNode(4);
//        TreeNode node7=new TreeNode(7);

//        node5.left=node3;
//        node5.right=node6;
//        node3.left=node2;
//        node3.right=node4;
//        node6.right=node7;

        Delete_Node_in_a_BST_450 s=new Delete_Node_in_a_BST_450();

        System.out.println(s.deleteNode(node5,5));
    }




}
