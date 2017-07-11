package DP2;

/**
 * Created by wunengbiao on 2017/7/1.
 */
public class Remove_Boxes_546 {
    public int removeBoxes(int[] boxes) {
        if(boxes==null || boxes.length==0) return 0;
        int[][][] dp=new int[boxes.length][boxes.length][boxes.length];
        return get(dp,boxes,0,boxes.length-1,1);
    }

    public int get(int[][][] dp,int[] boxes,int start,int end,int k){
        if(start>end) return 0;
        else if(start==end) return k*k;
        else if(dp[start][end][k]!=0) return dp[start][end][k];
        else{
            int temp=get(dp,boxes,start+1,end,1)+k*k;
            for(int m=start+1;m<=end;m++){
                if(boxes[start]==boxes[end]){
                    temp=Math.max(temp,get(dp,boxes,start+1,m-1,1)+get(dp,boxes,m,end,k+1));
                }
            }
            dp[start][end][k]=temp;
            return temp;
        }

    }
}
