package leet;

/**
 * Created by wunengbiao on 2016/10/19.
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode cur=root;
        while((p.val-cur.val)*(q.val-cur.val)>0){
            if(p.val<root.val && q.val<root.val) cur=cur.left;
            if(p.val>root.val && q.val>root.val) cur=cur.right;
        }
        return cur;
    }
}
