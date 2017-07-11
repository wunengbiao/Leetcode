package NowCoder;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/6/6.
 */
public class Min_Distance_Go_Home {
    public int solve(int[] positions){
        if(positions.length<3) return 0;
        int[] sum=new int[positions.length];

        for(int i=0;i<positions.length-1;i++){
            sum[i+1]=sum[i]+Math.abs(positions[i+1]-positions[i]);
        }

        int res=Integer.MAX_VALUE;
        for(int i=1;i<positions.length-1;i++){
            res=Math.min(res,sum[i-1]+sum[positions.length-1]-sum[i+1]+Math.abs(positions[i+1]-positions[i-1]));
        }

        return res;
    }

    public static void main(String[] args){
        Min_Distance_Go_Home s=new Min_Distance_Go_Home();
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[] positions=new int[n];
        String[] strs=in.nextLine().split(" ");
        for(int i=0;i<strs.length;i++){
            positions[i]=Integer.parseInt(strs[i]);
        }

        System.out.println(s.solve(positions));
    }
}
