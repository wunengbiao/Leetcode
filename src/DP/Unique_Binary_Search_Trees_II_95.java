package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/2/24.
 */
public class Unique_Binary_Search_Trees_II_95 {
    public List<TreeNode> generateTrees(int n) {

        if(n==0) return new ArrayList<TreeNode>();
        return generate(1,n);
    }

    public ArrayList<TreeNode> generate(int start,int end){
        ArrayList<TreeNode> rst=new ArrayList<>();

        if(start>end){
            rst.add(null);
            return rst;
        }

        for(int i=start;i<=end;i++){
            ArrayList<TreeNode> left=generate(start,i-1);
            ArrayList<TreeNode> right=generate(i+1,end);

            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    rst.add(root);
                }
            }
        }

        return rst;
    }


    public static void main(String[] args){
        Unique_Binary_Search_Trees_II_95 s=new Unique_Binary_Search_Trees_II_95();
        List<TreeNode> root=s.generateTrees(3);
        System.out.println(root);
        System.out.println(root.size());
    }


}
