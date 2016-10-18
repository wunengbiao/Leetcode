package leet;

/**
 * Created by wunengbiao on 2016/10/17.
 */
public class Solution114 {
     public void flatten(TreeNode root) {

         TreeNode head=new TreeNode(-1);
         head.right=root;

         TreeNode node=head;

         while(node.right!=null){
             node=node.right;
             if(node.left!=null){
                 TreeNode cur=node.left;
                 while(cur.right!=null){
                     cur=cur.right;
                 }
                 TreeNode tmp=node.right;
                 node.right=node.left;
                 node.left=null;
                 cur.right=tmp;
             }
         }
        head.right=null;
    }
}
