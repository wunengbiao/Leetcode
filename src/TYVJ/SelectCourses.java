package TYVJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/5/2.
 */
public class SelectCourses {
    int n;
    List<Integer>[] heads;
    int[][] dp;
    int[] val;

    public SelectCourses(int n){
        this.n=n;
        dp=new int[n+1][n+1];
        val=new int[n+1];

        heads=new List[n+1];
        for(int i=0;i<=n;i++){
            heads[i]=new ArrayList<>();
        }
    }

    public void dfs(int root,int m){
        if(m==0) return;

        for(int node:heads[root]){

            for(int i=0;i<=m;i++){
                dp[node][i]=dp[root][i];
            }

            dfs(node,m-1);

            for(int i=m;i>=1;i--){
                dp[root][i]=Math.max(dp[root][i],dp[node][i-1]+val[node]);
            }
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        String[] nums=in.nextLine().split(" ");
        int n=Integer.parseInt(nums[0]);
        int m=Integer.parseInt(nums[1]);

        SelectCourses s=new SelectCourses(n);
        for(int i=1;i<=n;i++){
            String[] strs=in.nextLine().split(" ");
            int head=Integer.parseInt(strs[0]);
            int val=Integer.parseInt(strs[1]);

            s.heads[head].add(i);
            s.val[i]=val;
        }

        s.dfs(0,m);

        for(int i=0;i<=n;i++){
            System.out.println(Arrays.toString(s.dp[i]));
        }
        System.out.println(s.dp[0][m]);
    }
}
