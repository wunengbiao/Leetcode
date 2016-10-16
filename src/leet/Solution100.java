package leet;

import SouHu.Solution;

/**
 * Created by wunengbiao on 2016/10/12.
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
       return preOrder(p,q);
    }

    public boolean preOrder(TreeNode p,TreeNode q){

        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;

        boolean res1=preOrder(p.left,q.left);
        boolean res2=preOrder(p.right,q.right);

        return res1 && res2;
    }

    public static void main(String[] args){
        Solution100 s=new Solution100();
        TreeNode p=new TreeNode(10);
        TreeNode pleft=new TreeNode(5);
        TreeNode pright=new TreeNode(15);
        p.left=pleft;
        p.right=pright;

        TreeNode q=new TreeNode(10);
        TreeNode qleft=new TreeNode(5);
        q.left=qleft;
        TreeNode qleftR=new TreeNode(15);
        qleft.right=qleftR;

        boolean result=s.isSameTree(p,q);
        System.out.println(result);
    }
}
