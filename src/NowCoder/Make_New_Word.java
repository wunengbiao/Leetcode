package NowCoder;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/6/5.
 */
public class Make_New_Word {
    public int solve(int n,int m,String[] items){
        int[][] table=new int[items.length][2];
        for(int i=0;i<items.length;i++){
            for(int j=0;j<items[i].length();j++){
                if(items[i].charAt(j)=='0') table[i][0]++;
                else table[i][1]++;
            }
        }

        int[][] dp=new int[n+1][m+1];

        for(int i=0;i<items.length;i++){
            for(int x=n;x>=table[i][0];x--){
                for(int y=m;y>=table[i][1];y--){
                    dp[x][y]=Math.max(dp[x][y],dp[x-table[i][0]][y-table[i][1]]+1);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args){
        Make_New_Word s=new Make_New_Word();
        Scanner in=new Scanner(System.in);
        String[] nums=in.nextLine().split(" ");
        int c=Integer.parseInt(nums[0]);
        int n=Integer.parseInt(nums[1]);
        int m=Integer.parseInt(nums[2]);
        String[] items=new String[c];
        for(int i=0;i<c;i++){
            items[i]=in.nextLine();
        }

        System.out.println(s.solve(n,m,items));
    }
}
