package leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wunengbiao on 2016/10/16.
 */
public class Solution106 {
    Map<Integer,Integer> inMap=new HashMap<>();
    int postIndex=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 || postorder.length==0) return null;
        postIndex=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }

        return createTree(postorder,0,inorder.length-1);

    }

    public TreeNode createTree(int[] postOrder,int start,int end){
        if(start>end || postIndex<0) return null;
        TreeNode root=new TreeNode(postOrder[postIndex--]);
        if(start==end) return root;
        int index=inMap.get(root.val);
        root.right=createTree(postOrder,index+1,end);
        root.left=createTree(postOrder,start,index-1);
        return root;
    }
}
