package leet;

/**
 * Created by wunengbiao on 2016/10/16.
 */
public class Solution108 {
     public TreeNode sortedArrayToBST(int[] nums) {

         if(nums.length==0) return null;
         return createBST(nums,0,nums.length-1);

    }

    public TreeNode createBST(int nums[],int start,int end){

        if(start>end) return null;
        int index= (int) Math.ceil((start+end)/2);
        TreeNode root=new TreeNode(nums[index]);
        if(start==end) return root;

        root.left=createBST(nums,start,index-1);
        root.right=createBST(nums,index+1,end);

        return root;
    }
}
