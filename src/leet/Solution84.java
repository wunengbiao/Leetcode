package leet;

import java.util.Stack;

/**
 *
 * Created by wunengbiao on 2017/1/9.
 */
public class Solution84 {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);
            if (s.isEmpty() || h >= height[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }

            System.out.println(s);
        }
        return maxArea;
    }

    public static void main(String[] args){
        Solution84 s=new Solution84();
        int[] nums={2,1,5,6,2,3};
        int res=s.largestRectangleArea(nums);
        System.out.println(res);
    }
}
