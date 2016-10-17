package leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/17.
 */
public class PrintPath {

    public void print(TreeNode root, List<Integer> path){
        if(root.left==null && root.right==null){
            path.add(root.val);
            System.out.println(path);
            return;
        }
        path.add(root.val);

        if(root.left!=null){
             print(root.left,path);
            path.remove(path.size()-1);
        }


        if(root.right!=null){
            print(root.right,path);
            path.remove(path.size()-1);
        }


    }
    public static void main(String[] args){
         TreeNode root=new TreeNode(1);
        TreeNode q1=new TreeNode(2);
        TreeNode q2=new TreeNode(7);
        TreeNode p1=new TreeNode(4);
        TreeNode p2=new TreeNode(5);

        root.left=q1;
        root.right=q2;
        q1.left=p1;
        q1.right=p2;

        PrintPath p=new PrintPath();
        List<Integer> path=new ArrayList<>();
        p.print(root,path);
    }
}
