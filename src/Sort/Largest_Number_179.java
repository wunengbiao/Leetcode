package Sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by wunengbiao on 2017/3/26.
 */
public class Largest_Number_179 {
    public String largestNumber(int[] nums) {
        String[] strs=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(strs,cmp);
        String res="";
        for(int i=0;i<strs.length;i++){
            res+=strs[i];
        }
        if(res.charAt(0)=='0') return "0";
        return res;
    }

    Comparator<String> cmp=new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
           return (s2+s1).compareTo(s1+s2);
        }
    };

    public static void main(String[] args){
        Largest_Number_179 solution=new Largest_Number_179();
        int[] nums={3, 30, 34, 5, 9};
        System.out.println(solution.largestNumber(nums));
    }
}
