package leet;

import java.util.*;

/**
 * Created by wunengbiao on 2017/5/8.
 */
public class Find_Largest_Value_in_Each_Tree_Row_515 {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        Map<TreeNode,Integer> map=new HashMap<>();
        map.put(root,0);

        Map<Integer,Integer> max=new HashMap<>();

        int level=0;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            level=map.get(node);

            if(node.left!=null){
                map.put(node.left,level+1);
                queue.add(node.left);
            }

            if(node.right!=null){
                map.put(node.right,level+1);
                queue.add(node.right);
            }

            if(max.containsKey(level)){
                max.put(level,Math.max(max.get(level),node.val));
            }else{
                max.put(level,node.val);
            }

        }
        for(int i=0;i<=level;i++){
            res.add(max.get(i));
        }

        return res;
    }

    public static void main(String[] args){
        Find_Largest_Value_in_Each_Tree_Row_515 s=new Find_Largest_Value_in_Each_Tree_Row_515();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(2);
        TreeNode node4=new TreeNode(5);
        TreeNode node5=new TreeNode(3);
        TreeNode node6=new TreeNode(9);

        node1.left=node2;
        node1.right=node3;

        node2.left=node4;
        node2.right=node5;

        node3.right=node6;
//        System.out.println(node1);

        System.out.println(s.largestValues(node1));
    }

}
