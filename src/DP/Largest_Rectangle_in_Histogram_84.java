package DP;

import java.util.Stack;

/**
 * Created by wunengbiao on 2017/2/22.
 */
public class Largest_Rectangle_in_Histogram_84 {
    public int largestRectangleArea(int[] heights) {
        if(heights==null) return 0;
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<=n;i++){
            int h=(i==n?0:heights[i]);
            if(st.isEmpty() || h>=heights[st.peek()])
                st.push(i);
            else{
                int tp=st.pop();
                maxArea=Math.max(maxArea,heights[tp]*(st.isEmpty()?i:i-1-st.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args){
        Largest_Rectangle_in_Histogram_84 s=new Largest_Rectangle_in_Histogram_84();
        int[] heights={2,1,5,6,2,3};
        System.out.println(s.largestRectangleArea(heights));
    }
}
