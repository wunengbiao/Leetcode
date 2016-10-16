package leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wunengbiao on 2016/10/15.
 */
public class Solution105 {
    Map<Integer,Integer> inMap=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) return null;
        for(int i=0;i<preorder.length;i++){
            inMap.put(preorder[i],i);
        }
        return createTree(preorder,0,preorder.length-1);
    }

    public TreeNode createTree(int[] preorder,int start,int end){
        if(start>end) return null;
        TreeNode root=new TreeNode(preorder[start]);

        return root;
    }
}
