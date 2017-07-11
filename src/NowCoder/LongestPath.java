package NowCoder;

public class LongestPath {
    int max=0;
    public int findPath(TreeNode root) {
        findPath(root,0);
        findPath(root,1);
        return max;
    }

    public int findPath(TreeNode root,int val){
        if(root==null) return 0;
        if(root.left==null && root.right==null && root.val==val) return 1;
        int left=findPath(root.left,val);
        int right=findPath(root.right,val);
        if(root.val==val){
            max=Math.max(left+right+1,max);
            return Math.max(left,right)+1;
        }else{
            max=Math.max(max,Math.max(left,right));
            return 0;
        }
    }

}

