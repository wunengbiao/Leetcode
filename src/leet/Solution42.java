package leet;

import java.util.Stack;

/**
 * Created by wunengbiao on 2017/2/7.
 */
public class Solution42 {

    public int trap(int[] height) {
        if(height==null) return 0;
        Stack<Integer> s=new Stack<>();

        int i=0,maxWater=0,maxBotWater=0;

        while(i<height.length){
            if(s.isEmpty() || height[i]<=height[s.peek()]){
                s.push(i++);
            }else{
                int bot=s.pop();
                maxBotWater=s.isEmpty()?0:(Math.min(height[s.peek()],height[i])-height[bot])*(i-s.peek()-1);
                maxWater+=maxBotWater;
            }
        }

        return maxWater;
    }

    public static void main(String[] args){
        Solution42 s=new Solution42();
//        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height={4,2,3};
        System.out.println(s.trap(height));
    }
}
