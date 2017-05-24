package Array;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/5/11.
 */
public class First_Missing_Positive_41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int begin=0;
        for(int i=0;i<=nums.length;i++){
            int cur=i==nums.length?Integer.MAX_VALUE:nums[i];
            int before=i==0?Integer.MIN_VALUE:nums[i-1];
            if(cur<=0 || cur==before) continue;
            else{
                if(++begin==cur) continue;
                else{
                    break;
                }
            }
        }

        return begin;
    }

    public static void main(String[] args){
        First_Missing_Positive_41 s=new First_Missing_Positive_41();
//        int[] array={3,4,-1,1};
//        int[] array={1,2,0};
        int[] array={0,2,2,1,1};
        System.out.println(s.firstMissingPositive(array));
    }
}
