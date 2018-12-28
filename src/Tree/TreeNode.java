package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/10.
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        String result="[";
        List<Integer> path=new ArrayList<>();
        print(this,path);

        for(int i=0;i<path.size()-3;i++){
//            System.out.println(path);
//            result+=path.get(i)+',';
            if(path.get(i)==null) result+="null,";
            else{
                result+=path.get(i);
                result+=',';
            }
        }
        result+=path.get(path.size()-3);
        result+="]";
        return result;
    }

    public static void print(TreeNode root, List<Integer> path){
        if(root==null){
            path.add(null);
            return;
        }

        path.add(root.val);
        print(root.left,path);
        print(root.right,path);
    }


    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        TreeNode left=new TreeNode(2);
        TreeNode right=new TreeNode(3);

        root.left=left;
        root.right=right;

        System.out.println(root);

//        List<Integer> path=new ArrayList<>();
//        root.print(root,path);
//        System.out.println(path);

    }

}
