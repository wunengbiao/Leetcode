package Str;

/**
 * Created by wunengbiao on 2017/3/20.
 */
public class Distinct_Subsequences_115 {
    public int numDistinct(String s, String t) {
        if(!isSubSequence(s,t)) return 0;
        int[][] dp=new int[t.length()+1][s.length()+1];
        dp[0][0]=1;
        for(int i=1;i<=s.length();i++){
            dp[0][i]=1;
        }

        for(int i=1;i<=t.length();i++){
            dp[i][0]=0;
        }

        for(int i=1;i<=t.length();i++){
            for(int j=1;j<=s.length();j++){
                dp[i][j]=dp[i][j-1];
                if(t.charAt(i-1)==s.charAt(j-1))
                    dp[i][j]+=dp[i-1][j-1];
            }
        }

        return dp[t.length()][s.length()];
    }

    public boolean isSubSequence(String s,String t){
        int i=0,j=0;
        while(j<s.length() ){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j++;
                if(i==t.length()) return true;
            }else{
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Distinct_Subsequences_115 solution=new Distinct_Subsequences_115();
//        System.out.println(solution.isSubSequence("Rabbbit","Rabbit"));
        System.out.println(solution.numDistinct("rabbbit","rabbit"));
    }


}
