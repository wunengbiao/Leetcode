package leet;

/**
 * Created by wunengbiao on 2016/10/19.
 */
public class Solution230 {

    int calThreeNode(TreeNode root){
        if(root==null) return 0;
        return calThreeNode(root.left)+calThreeNode(root.right)+1;
    }

    public int kthSmallest(TreeNode root, int k) {

        if(root==null) return 0;
        int leftSize=calThreeNode(root.left);
        if(k==leftSize+1) return root.val;
        if(leftSize>=k)
            return kthSmallest(root.left,k);
        else
            return kthSmallest(root.right,k-leftSize-1);
    }
}
