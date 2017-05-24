package SouHu;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wunengbiao on 2017/3/11.
 */
public class Color_Diamond {

    public int solve(String s){
        Set<Character> set=new HashSet<>();

        for(Character c:s.toCharArray()){
            if(c>='A' && c<='E')
                set.add(c);
        }

        if(set.size()<5) return 0;
//        System.out.println("SUCCESS");

        String line=s+s;
        int n=line.length();
        int[] dp=new int[n];

        for(int i=0;i<5;i++){
            char cur=(char) ('A'+i);
//            System.out.println(cur);
            int last=-1;
            for(int j=0;j<n;j++){
                if(line.charAt(j)==cur){
                    last=j;
                }

                if(last==-1){
                    dp[j]=n;
                }else{
                    dp[j]=Math.max(dp[j],j-last+1);
                }
            }
        }

        int res=n;
        for(int i=0;i<n;i++){
            res=Math.min(res,dp[i]);
        }

        return n/2-res;
    }

    public static void main(String[] args){
        Color_Diamond s=new Color_Diamond();
        System.out.println(s.solve("ABCYDYE"));
    }
}
