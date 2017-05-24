package Sort;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/3/25.
 *
 * 桶排序 或是基数排序
 */
public class Maximum_Gap_164 {
//    public int maximumGap(int[] nums) {
//        if(nums.length<2) return 0;
//        Arrays.sort(nums);
//
//        int max=Integer.MIN_VALUE;
//        for(int x=1;x<nums.length;x++){
//            max=Math.max(nums[x]-nums[x-1],max);
//        }
//        return max;
//    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // m is the maximal number in nums
        int m = nums[0];
        for (int i = 1; i < nums.length; i++) {
            m = Math.max(m, nums[i]);
        }

        int exp = 1; // 1, 10, 100, 1000 ...
        int R = 10; // 10 digits

        int[] aux = new int[nums.length];

        while (m / exp > 0) { // Go through all digits from LSB to MSB
            int[] count = new int[R];

            for (int i = 0; i < nums.length; i++) {
                count[(nums[i] / exp) % 10]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                aux[--count[(nums[i] / exp) % 10]] = nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = aux[i];
            }
            exp *= 10;
        }

        int max = 0;
        for (int i = 1; i < aux.length; i++) {
            max = Math.max(max, aux[i] - aux[i - 1]);
        }

        return max;
    }

    public static void main(String[] args){
        Maximum_Gap_164 solution=new Maximum_Gap_164();
        int[] nums={1,3,2,4,34,23,56,78,89,56,34,23,21,43,56,67,87,90};
        solution.maximumGap(nums);
    }



}
