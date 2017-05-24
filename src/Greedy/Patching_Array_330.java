package Greedy;

/**
 * Created by wunengbiao on 2017/5/13.
 */
public class Patching_Array_330 {

    public int minPatches(int[] nums, int n) {

        long max=0;
        int cnt=0;

        for(int i=0;max<n;){
            if(i>=nums.length || max<nums[i]-1){
                System.out.println(max+1);
                max+=max+1;
//                System.out.println(max);
                cnt++;
            }else{
                max+=nums[i];
                i++;
            }
        }

        return cnt;
    }

    public static void main(String[] args){
        Patching_Array_330 s=new Patching_Array_330();
        int[] arr={1,5,10};
//        int[] arr={1,3};
//        int[] arr={1,2,2};
        System.out.println(s.minPatches(arr,100));
    }
}
