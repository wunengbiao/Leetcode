package leet;

import java.util.*;

/**
 * Created by wunengbiao on 2017/5/8.
 */
public class Most_Frequent_Subtree_Sum_508 {
    Map<Integer,Integer> map=new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        findFrequentSum(root);
        List<Integer> res=new ArrayList<>();
        int max=0;
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+"-->"+entry.getValue());
            if((int)entry.getValue()==max){
                res.add((int)entry.getKey());
            }
            if((int)entry.getValue()>max){
                max=(int)entry.getValue();
                res.clear();
                res.add((int)entry.getKey());
            }
        }
        int[] resArr=new int[res.size()];
        for(int i=0;i< res.size();i++){
            resArr[i]=res.get(i);
        }
        return resArr;
    }


    public int findFrequentSum(TreeNode root){
        if(root==null) return 0;

        int left=findFrequentSum(root.left);
        int right=findFrequentSum(root.right);
        int sum=left+right+root.val;
        int count=map.getOrDefault(sum,0);
        map.put(sum,count+1);
        return sum;
    }

    public static void main(String[] args){
        Most_Frequent_Subtree_Sum_508 s=new Most_Frequent_Subtree_Sum_508();

        /*
        *
               5
             /  \
            2   -5
        * */

        TreeNode root=new TreeNode(5);
        TreeNode left=new TreeNode(2);
        TreeNode right=new TreeNode(-3);

        root.left=left;
        root.right=right;
        System.out.println(Arrays.toString(s.findFrequentTreeSum(root)));
    }

}
