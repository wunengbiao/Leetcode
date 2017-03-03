package leet;

import java.util.Stack;

/**
 * Created by wunengbiao on 2017/2/10.
 */
public class Solution331 {
    public boolean isValidSerialization(String preorder) {
        if(preorder==null) return false;

        String[] nodes=preorder.split(",");
        Stack<String> s=new Stack<>();

        for(int i=0;i<nodes.length;i++){
            String cur=nodes[i];
            while(cur.equals("#") && !s.isEmpty() && s.peek().equals(cur)){
                s.pop();
                if(s.isEmpty()) return false;
                s.pop();
            }
            s.push(cur);
        }

        if(s.size()==1 && s.pop().equals("#")) return true;
        else return false;
    }

    public static void main(String[] args){
        Solution331 s=new Solution331();
        String test1="9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println("Result is:"+s.isValidSerialization(test1));
    }
}
