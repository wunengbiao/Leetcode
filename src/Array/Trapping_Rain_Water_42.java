package Array;

import java.util.Stack;

/**
 * Created by wunengbiao on 2017/5/11.
 */
public class Trapping_Rain_Water_42 {
    public int trap(int[] height) {
        Stack<Integer> stack=new Stack<>();

        int i=0,maxWater=0,maxBotWater=0;
        while(i<height.length){
            if(stack.isEmpty() || height[i]<=height[stack.peek()]){
                stack.push(i++);
            }else{
                int bot=stack.pop();
                maxBotWater=stack.isEmpty()?0:(Math.min(height[i],height[stack.peek()])-height[bot])*(i-stack.peek()-1);
                maxWater+=maxBotWater;
            }
        }
        return maxWater;
    }

    public static void main(String[] args){
        Trapping_Rain_Water_42 s=new Trapping_Rain_Water_42();
//        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height={2,0,1,2};
        System.out.println(s.trap(height));
    }
}
