package SouHu;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2016/9/26.
 */

//void solve() {
//    cin >> n >> m;
//    for (int i = 1; i <= n; i++) cin >> a[i];
//    dp[0]= 1;
//    for (int i = 1; i <= n; i++) {
//        for (int j = m; j >= a[i]; j--) {
//            dp[j] += dp[j - a[i]];
//        }
//    }
//    cout << dp[m] << endl;
//}
public class Solution5 {
    public static int solve(int[] nums,int m){
        int n=nums.length;
        int[] dp=new int[m+1];
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=m;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[m];
    }

    public static void main(String[] args){

        int[] a={5,5,10,2,3};
        int ret=solve(a,15);
        System.out.println(ret);
    }
}
