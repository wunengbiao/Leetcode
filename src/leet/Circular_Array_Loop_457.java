package leet;

import NowCoder.Circle_World;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wunengbiao on 2017/7/4.
 */
public class Circular_Array_Loop_457 {
    public boolean circularArrayLoop(int[] nums) {

        Set<Integer> indexs;
        for(int i=0;i<nums.length;i++){
            indexs=new HashSet<>();
            int count=0;

            int next=i;
            boolean forward=nums[next]>0;
            while(count<nums.length){
                next=forward(next,nums.length,nums[next]);
                if(forward==nums[next]>0){
                    indexs.add(next);
                    if(indexs.contains(i) && indexs.size()>1 )
                        return true;
                    count++;
                }else{
                    break;
                }
            }
        }

        return false;
    }

    public int forward(int index,int n,int step){
        return (index+step)>=0?(index+step)%n:(index+step)%n+n;
    }

    public static void main(String[] args){
        Circular_Array_Loop_457 s=new Circular_Array_Loop_457();
        int[] nums={2, -1, 1, 2, 2};
        int[] nums3={2, -1, 1, -2, -2};
        int[] nums2={-1,2};
        System.out.println(s.circularArrayLoop(nums3));
    }
}
