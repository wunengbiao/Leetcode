package lintCode;

import java.util.Stack;

/**
 * Created by wunengbiao on 2017/4/5.
 */
public class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0) return 0;
        int len=heights.length;
        Stack<Integer> st=new Stack<>();

        int maxArea=0;
        for(int i=0;i<=len;i++){
            int h=i==len?0:heights[i];
            if(st.isEmpty() || heights[st.peek()]<=h){
                st.push(i);
            }else{
                int top=st.pop();
                maxArea=Math.max(maxArea,heights[top]*(st.isEmpty()?i:i-1-st.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args){
        Largest_Rectangle_in_Histogram s=new Largest_Rectangle_in_Histogram();
        int[] nums={2,1,3,5,3,2};
        System.out.println(s.largestRectangleArea(nums));
    }
}
