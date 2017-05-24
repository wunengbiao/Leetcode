package leet;

import Tree.Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wunengbiao on 2016/10/15.
 */
public class Solution105 {
    Map<Integer,Integer> inMap=new HashMap<>();

    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) return null;
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        return createTree(preorder,0,inorder.length-1);
    }

    public TreeNode createTree(int[] preorder,int start,int end){
        if(start>end) return null;
        TreeNode root=new TreeNode(preorder[preIndex++]);
        if(start==end) return root;

        int inIndex=inMap.get(root.val);
        root.left=createTree(preorder,start,inIndex-1);
        root.right=createTree(preorder,inIndex+1,end);

        return root;
    }

}
