package leet;

import SouHu.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/10.
 */
public class Solution95 {


     public ArrayList<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return generate(1, n);
    }

    private ArrayList<TreeNode> generate(int start, int end){
        ArrayList<TreeNode> rst = new ArrayList<TreeNode>();

        if(start > end){
            rst.add(null);
            return rst;
        }

            for(int i=start; i<=end; i++){
                ArrayList<TreeNode> left = generate(start, i-1);
                ArrayList<TreeNode> right = generate(i+1, end);
                for(TreeNode l: left){
                    for(TreeNode r: right){
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        rst.add(root);
                    }
                }
            }
        return rst;
    }

    public static void main(String[] args){
        Solution95 s=new Solution95();

        List<TreeNode> result=new ArrayList<>();
        result=s.generateTrees(3);
        for(TreeNode t:result){
            System.out.println(t);
        }
    }
}
