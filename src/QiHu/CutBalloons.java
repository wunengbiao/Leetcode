package QiHu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/5/2.
 */
public class CutBalloons {
    static final int MOD = (int)1e9 + 7;
    static int CutBallStirng (int[] color,int n) {
        int[] count = new int[11];
        int[] result = new int[20];
        result[0] = 1;
        for(int i = 1; i<=n; i++) {
            Arrays.fill(count, 0);
            for(int j = 0; j<i; j++){

                count[color[i-j-1]] ++;
                System.out.println(Arrays.toString(count));
                if(count[color[i-j-1]] > 1) {
                    break;
                }
                result[i] = (result[i] + result[i-j-1])% MOD;

            }
        }
        System.out.println(Arrays.toString(result));
        return result[n];
    }

    public static int solve(int n,int[] array){
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){

            int j=i-1;
            HashSet<Integer> set=new HashSet<>();

            while(j>=0 && !set.contains(array[j])){
                set.add(array[j]);
                dp[i]+=dp[j];
                dp[i]%=MOD;
                j--;
            }
        }
        return dp[n];
    }

//    public static int CutBallStirng(int[] array,int n){
//        int[] count=new int[10];
//        int[] dp=new int[n+1];
//
//        dp[0]=0;
//
//        for(int i=1;i<=n;i++){
//            Arrays.fill(count,0);
//
//            for(int j=i;j>=1;j--){
//                count[array[j]]++;
//
//                if(count[array[j]]>1) break;
//
//                dp[i]=(dp[i]+dp[j-1])%MOD;
//            }
//        }
//
//        return dp[n];
//
//    }
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] test = new int[n+1];
        for(int i = 0; i <n; i++){
            test[i]= s.nextInt();
        }
//        System.out.println(CutBallStirng(test,n));
        System.out.println(solve(n,test));
    }
}
