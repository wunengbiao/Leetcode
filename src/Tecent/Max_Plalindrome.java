package Tecent;

/**
 * Created by wunengbiao on 2017/3/16.
 */
public class Max_Plalindrome {
    public int solve(String str){
        if(str.length()<=1) return str.length();

        String str1= new StringBuffer(str).reverse().toString();

        int dp[][]=new int[str.length()+1][str.length()+1];

        for(int i=1;i<=str.length();i++){
            for(int j=1;j<=str.length();j++){
                if(str.charAt(i-1)==str1.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[str.length()][str.length()]);

        return str.length()-dp[str.length()][str.length()];
    }

    public static void main(String[] args){
        Max_Plalindrome solution=new Max_Plalindrome();
        String test="google";
        System.out.println(solution.solve(test));
    }
}
