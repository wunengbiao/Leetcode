package BitManipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wunengbiao on 2017/5/15.
 */
public class Maximum_XOR_of_Two_Numbers_in_an_Array_421 {
    public int findMaximumXOR(int[] nums) {
        int max=0;
        int mask=0;

        for(int i=31;i>=0;i--){
            mask=mask | (1<<i);
            Set<Integer> set=new HashSet<>();
            for(int num:nums){
                set.add(num & mask);
            }

            int tmp=max | (1<<i);
            for(int prefix:set){
                if(set.contains(tmp^prefix)){
                    max=tmp;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        Maximum_XOR_of_Two_Numbers_in_an_Array_421 s=new Maximum_XOR_of_Two_Numbers_in_an_Array_421();
        int[] nums={3, 10, 5, 25, 2, 8};
//        int[] nums={16,17,18};
        System.out.println(s.findMaximumXOR(nums));
    }
}
