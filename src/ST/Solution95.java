package ST;

import leet.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/27.
 */
public class Solution95 {

    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        else return generate(1,n);
    }

    public List<TreeNode> generate(int start,int end){
        List<TreeNode> res=new ArrayList<>();
        if(start>end){
            res.add(null);
        }

        for(int i=start;i<=end;i++){
            List<TreeNode> left=generate(start,i-1);
            List<TreeNode> right=generate(i+1,end);

            for(TreeNode leftNode:left){
                for(TreeNode rightNode:right){
                    TreeNode root=new TreeNode(i);
                    root.left=leftNode;
                    root.right=rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution95 s=new Solution95();
        List<TreeNode>result=s.generateTrees(3);
        System.out.println(result);
    }
}
