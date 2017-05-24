package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/5/8.
 */
public class Populating_Next_Right_Pointers_in_Each_Node_II_117 {
    List<List<TreeLinkNode>> res=new ArrayList<>();
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        helper(root,0);

        for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size()-1;j++){
                res.get(i).get(j).next=res.get(i).get(j+1);
            }

            res.get(i).get(res.get(i).size()-1).next=null;
        }
    }

    public void helper(TreeLinkNode root,int level){

        if(res.size()<level+1) res.add(new ArrayList<>());
        res.get(level).add(root);

        if(root.left!=null){
            helper(root.left,level+1);
        }

        if(root.right!=null){
            helper(root.right,level+1);
        }
    }
}
