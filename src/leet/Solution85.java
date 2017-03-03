package leet;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/1/8.
 */
public class Solution85 {

    public int maximalRectangle(char[][] matrix) {
        if(matrix==null) return 0;
        int row=matrix.length;
        int col=matrix[0].length;

        int[] left=new int[col];
        int[] right=new int[col];
        int[] height=new int[col];

        int maxArea=0;
        Arrays.fill(left,0);
        Arrays.fill(right,col);
        Arrays.fill(height,0);

        for(int i=0;i<row;i++){
            int cur_left=0,cur_right=col;
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='1') height[j]=height[j]+1;
                else height[j]=0;
            }

            for(int j=0;j<col;j++){
                if(matrix[i][j]=='1')
                    left[j]=Math.max(left[j],cur_left);
                else{
                    left[j]=0;
                    cur_left=j+1;
                }
            }

            for(int j=col-1;j>=0;j--){
                if(matrix[i][j]=='1')
                    right[j]=Math.min(right[j],cur_right);
                else{
                    right[j]=col;
                    cur_right=j;
                }
            }

            System.out.println("----------------"+(i+1)+"---------------");
            System.out.println("left:"+Arrays.toString(left));
            System.out.println("right:"+Arrays.toString(right));
            System.out.println("height:"+Arrays.toString(height));
            for(int j=0;j<col;j++){
                maxArea=Math.max(maxArea,(right[j]-left[j])*height[j]);
            }
        }

        return maxArea;
    }

    public static void main(String[] args){
        Solution85 s=new Solution85();

        char[][] matrix={
                {'0','0','0','1','0','0','0'},
                {'0','0','1','1','1','0','0'},
                {'0','1','1','1','1','1','0'}
        };

        System.out.println("Max Area:"+s.maximalRectangle(matrix));
    }
}
