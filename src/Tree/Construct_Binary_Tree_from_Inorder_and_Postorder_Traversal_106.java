package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wunengbiao on 2017/3/29.
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 {

    Map<Integer,Integer> map=new HashMap<>();
    int postIndex=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 || postorder.length==0) return null;
        postIndex=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return createTree(postorder,0,postorder.length-1);
    }

    public TreeNode createTree(int[] postOrder,int start,int end){
        if(start>end || postIndex<0) return null;
        TreeNode root=new TreeNode(postOrder[postIndex--]);
        if(start==end) return root;
        int index=map.get(root.val);

        root.right=createTree(postOrder,index+1,end);
        root.left=createTree(postOrder,start,index-1);
        return root;
    }

    public static void main(String[] args){
        Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 s=new Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106();
        int[] inorder={3,2,4,1,5,6};
        int[] postorder={3,4,2,6,5,1};
        System.out.println(s.buildTree(inorder,postorder));
    }
}
