package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wunengbiao on 2017/3/29.
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
    Map<Integer,Integer> map=new HashMap<>();
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) return null;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return createTree(preorder,0,inorder.length-1);

    }

    public TreeNode createTree(int[] preorder,int start,int end){
        if(start>end || preIndex>preorder.length-1) return null;

        TreeNode root=new TreeNode(preorder[preIndex++]);
        if(start==end) return root;

        int mid=map.get(root.val);
        root.left=createTree(preorder,start,mid-1);
        root.right=createTree(preorder,mid+1,end);
        return root;
    }

    public static void main(String[] args){

        Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 s=new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105();
        int[] inorder={3,2,4,1,5,6};
        int[] preorder={1,2,3,4,5,6};
        System.out.println(s.buildTree(preorder,inorder));
    }
}
