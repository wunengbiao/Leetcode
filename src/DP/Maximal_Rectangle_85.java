package DP;

import java.util.Stack;

/**
 * Created by wunengbiao on 2017/2/22.
 */
public class Maximal_Rectangle_85 {
    public int maximalRectangle(char[][] matrix) {

        if(matrix.length==0) return 0;
        int maxArea=0;
        int [] heights=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
//                int h=(i-1>=0?heights[i]:0);
                if(matrix[i][j]=='0') heights[j]=0;
                else heights[j]++;
            }
            maxArea=Math.max(maxArea,largestRectangleArea(heights));
        }


        return maxArea;
    }

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
        Maximal_Rectangle_85 s=new Maximal_Rectangle_85();
        char[][] matrix={
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','0','0'}
        };

        char[][] matrix1={};

        char[][] matrix2={
                {'0','0','0'},
                {'0','0','0'},
                {'0','0','0'},
                {'0','0','0'}
        };

        System.out.println("MaxArea:"+s.maximalRectangle(matrix2));
    }
}
