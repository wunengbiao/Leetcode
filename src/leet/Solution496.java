package leet;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by wunengbiao on 2017/2/11.
 */
public class Solution496 {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();

        for(int num:nums){
            while(!stack.isEmpty() && stack.peek()<num)
                map.put(stack.pop(),num);
            stack.push(num);
        }

        int[] result=new int[findNums.length];
        for(int i=0;i<findNums.length;i++){
            result[i]=map.getOrDefault(findNums[i],-1);
        }
        return result;
    }


}
