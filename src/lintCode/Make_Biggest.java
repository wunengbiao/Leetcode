package lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/4/4.
 * 给出两个长度分别是m和n的数组来表示两个大整数，数组的每个元素都是数字0-9。
 * 从这两个数组当中选出k个数字来创建一个最大数，其中k满足k <= m + n。
 * 选出来的数字在创建的最大数里面的位置必须和在原数组内的相对位置一致。返回k个数的数组。
 * 你应该尽可能的去优化算法的时间复杂度和空间复杂度。
 */
public class Make_Biggest {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        List<Integer> res=new ArrayList<>();
        for(int i=Math.max(0,k-nums2.length);i<=Math.min(nums1.length,k);i++){
//            System.out.println(findKMax(nums1,i));
//            System.out.println(findKMax(nums2,k-i));
            List<Integer> merge=merge(findKMax(nums1,i),findKMax(nums2,k-i));
//            System.out.println(merge);
//            System.out.println("------------------------------");
            if(greater(merge,res)){
                res.clear();
                res.addAll(merge);
            }
        }
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=res.get(i);
        }

        return result;
    }
    public List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new ArrayList<>();
        while(l1.size()+l2.size()>0){
            if(greater(l1,l2)){
                res.add(l1.get(0));
                l1.remove(0);
            }else{
                res.add(l2.get(0));
                l2.remove(0);
            }
        }

        return res;
    }

    public boolean greater(List<Integer> l1,List<Integer> l2){
        if(l1==null || l1.size()==0) return false;
        if(l2.size()==0 && l2==null) return true;

        int i=0;
        int end=Math.min(l1.size(),l2.size());
        while(i<end){
            if(l1.get(i)==l2.get(i)){
                i++;
                continue;
            }
            if(l1.get(i)>l2.get(i)){
                return true;
            }else{
                return false;
            }

        }

        if(l1.size()>i) return true;
        return false;
    }

    public List<Integer> findKMax(int[] nums,int k){
        List<Integer> res=new ArrayList<>();
        int begin=0;
        while(k>0){
            int end=nums.length-k;
            int max=begin;
            for(int i=begin+1;i<=end;i++){
                if(nums[i]>nums[max]) max=i;
            }
            begin=max+1;
            res.add(nums[max]);
            k--;
        }
        return res;
    }

    public static void main(String[] args){
        Make_Biggest s=new Make_Biggest();
        int[] nums1={3,4,6,5};
        int[] nums2={9,1,2,5,8,3};
        List<Integer> l1=Arrays.asList(6,5);
        List<Integer> l2=Arrays.asList(8,3);
        System.out.println(s.greater(l1,l2));



        System.out.println(Arrays.toString(s.maxNumber(nums1,nums2,5)));
    }


}
