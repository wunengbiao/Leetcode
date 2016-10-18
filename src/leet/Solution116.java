package leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/18.
 */
public class Solution116 {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        List<TreeLinkNode> cur_level=new ArrayList<>();
        cur_level.add(root);

        while(cur_level.size()!=0){
            List<TreeLinkNode> next_level=new ArrayList<>();
            for(int i=0;i<cur_level.size()-1;i++){
                cur_level.get(i).next=cur_level.get(i+1);
                if(cur_level.get(i).left!=null)
                next_level.add(cur_level.get(i).left);
                if(cur_level.get(i).right!=null)
                next_level.add(cur_level.get(i).right);
            }
            cur_level.get(cur_level.size()-1).next=null;
            if(cur_level.get(cur_level.size()-1).left!=null)
            next_level.add(cur_level.get(cur_level.size()-1).left);
            if(cur_level.get(cur_level.size()-1).right!=null)
            next_level.add(cur_level.get(cur_level.size()-1).right);

            cur_level.clear();
            cur_level=next_level;
        }
    }
}
