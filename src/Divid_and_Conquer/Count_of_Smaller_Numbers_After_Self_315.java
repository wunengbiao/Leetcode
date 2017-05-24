package Divid_and_Conquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/4/2.
 */
public class Count_of_Smaller_Numbers_After_Self_315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res=new ArrayList<>();
        BinarySearchTree tree=new BinarySearchTree();
        for(int i=nums.length-1;i>=0;i--){
            int x=tree.insert(nums[i]);
            System.out.println(x);
            res.add(0,x);
        }
        return res;
    }

    public class Node{
        Node left;
        Node right;
        int val;
        int cnt=1;
        int leftCnt=0;

        Node(int val){
            this.val=val;
        }
    }

    public class BinarySearchTree{
        Node root;
        public int insert(int val){
            if(root==null){
                this.root=new Node(val);
                return 0;
            }

            int res=0;
            Node p=root;
            while(p!=null){
                if(val<p.val){
                    p.leftCnt+=1;
                    if(p.left==null){
                        p.left=new Node(val);
                        break;
                    }
                    p=p.left;
                }else if(val>p.val){
                    res+=p.leftCnt+p.cnt;
                    if(p.right==null){
                        p.right=new Node(val);
                        break;
                    }
                    p=p.right;
                }else{
                    res+=p.leftCnt;
                    p.cnt+=1;
                    break;
                }
            }
            return res;
        }
    }

    public static void main(String[] args){
        Count_of_Smaller_Numbers_After_Self_315 s=new Count_of_Smaller_Numbers_After_Self_315();
//        int[] nums={5,2,6,1};
        int[] nums={1,0,2};
        System.out.println(s.countSmaller(nums));
    }
}
