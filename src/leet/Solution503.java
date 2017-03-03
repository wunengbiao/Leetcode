package leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by wunengbiao on 2017/2/11.
 */
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {

        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> st=new Stack<>();

        int n=nums.length;
        int[] temp=new int[2*n];
        for(int i=0;i<n;i++){
            temp[i]=nums[i];
            temp[i+n]=nums[i];
        }
        System.out.println(Arrays.toString(temp));

        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && temp[st.peek()]<temp[i])
                map.put(st.pop(),i);
            st.push(i);
        }

        int[] res=new int[n];
        for(int i=0;i<n;i++){
            int t=map.getOrDefault(i,-1);
            t=t>(n-1)?t-n:t;
            res[i]=t<0?-1:temp[t];
        }
        return res;
    }

    public static void main(String[] args){
        Solution503 s=new Solution503();
        int[] test={1,2,1};
        System.out.println(Arrays.toString(s.nextGreaterElements(test)));
    }
}
