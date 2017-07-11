package NowCoder;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/6/6.
 *
 * dp[i][j]表示有i个数字及j个小于号所能组成的数量(大于号数量当然是i - j - 1次，后面需要使用)
 而加入第i + 1个数字时，分以下四种情况：
 1.如果将i+1插入当前序列的开头，即有了1<2，加入后成为3>1<2，会发现等于同时加入了一个大于号！(此时可以无视1与2之间的关系，因为i+1>i)
 2.如果将i+1插入当前序列末尾,即1<2变成了 1<2<3，会发现等于同时加入了一个小于号！ (此时可以无视1与2之间的关系，因为i+1>i)
 3.如果将i+1加入一个小于号之间，即已经有 1<2了，向中间加入3,会发现变成了1<3>2，等于同时加入了一个大于号！
 4.如果将i+1加入一个大于号中间，即有了2>1，变成了2<3>1，等于同时加入了一个小于号！
 综上所述，dp[i][j]等于以上四种情况之和：
 dp[i - 1][j] //将i加在开头等于加入一个大于号，即要求i-1个数时已经有了j个小于号
 dp[i - 1][j - 1] //将i加在末尾等于加入一个小于号，即要求i-1个数时已经有了j-1个小于号
 dp[i - 1][j] * j //将i加在任意一个小于号之间，等于加入了一个大于号；即要求i-1个数时已经有了j个小于号，每个小于 号都可以进行这样的一次插入
 dp[i - 1][j - 1] * (i- j - 1) //将i加载任意一个大于号之间，等于加入了一个小于号；即要求i-1个数时有了j-1个小于号，而此时共有
 (i - 1) - (j - 1)- 1个大于号，每个大于号都要进行一次这样的操作
 合并同类项即为：
 dp[i][j] = (dp[i - 1][j - 1] * (i - j) + dp[i - 1][j] * (j + 1))
 */
public class Inequality_Series {

    public int solve(int n,int k){
        int[][] dp=new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=0;j<n;j++){
                if(j==0) dp[i][j]=1;
                else
                    dp[i][j]=(dp[i-1][j-1]*(i-j)+dp[i-1][j]*(j+1))%2017;
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args){
        Inequality_Series s=new Inequality_Series();
        Scanner in=new Scanner(System.in);

        String[] strs=in.nextLine().split(" ");
        int n=Integer.parseInt(strs[0]);
        int k=Integer.parseInt(strs[1]);
        System.out.println(s.solve(n,k));
    }
}
