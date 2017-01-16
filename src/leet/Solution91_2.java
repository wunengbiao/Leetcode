package leet;

/**
 * Created by wunengbiao on 2017/1/10.
 */
public class Solution91_2 {
    public int numDecodings(String s) {
        if(s==null || s.length()==0) return 0;
        int n=s.length();

        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=s.charAt(0)!=0?1:0;

        char[] nums=s.toCharArray();
        for(int i=2;i<=n;i++){
            if(nums[i-1]>='1' && nums[i-1]<='9')
                dp[i]+=dp[i-1];
            if(check10To26(nums[i-1],nums[i-2]))
                dp[i]+=dp[i-2];
        }

        return dp[n];
    }

    public boolean check10To26(char a,char b){
        String s=""+a+b;
        int num=Integer.parseInt(s);
        if(num>=10 && num<=26)
            return true;
        return false;
    }

    public static void main(String[] args){
        Solution91_2 s=new Solution91_2();
        int res=s.numDecodings("227");
        System.out.println(res);
    }
}
