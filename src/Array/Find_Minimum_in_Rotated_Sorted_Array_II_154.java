package Array;

/**
 * Created by wunengbiao on 2017/5/11.
 */
public class Find_Minimum_in_Rotated_Sorted_Array_II_154 {
    public int findMin(int[] nums) {
        int min=nums[0];

        int i=1;
        while(i<nums.length){
            if(nums[i]<nums[i-1]){

                min=Math.min(min,nums[i]);
                break;
            }

            i++;
        }

        return min;
    }

    public static void main(String[] args){
        Find_Minimum_in_Rotated_Sorted_Array_II_154 s=new Find_Minimum_in_Rotated_Sorted_Array_II_154();
        int[] array={4,5,6,7,0,1,2};
        System.out.println(s.findMin(array));
    }
}
