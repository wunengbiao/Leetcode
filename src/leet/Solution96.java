package leet;

import SouHu.Solution;

/**
 * Created by wunengbiao on 2016/10/2.
 */
public class Solution96 {
     public int numTrees(int n) {
        if(n==0 || n==1){
            return 1;
        }else{
            try {
                int m1=1;
                int m2=1;
                for(int i=1;i<=2*n;i++){
                    m1*=i;
                }
                for(int j=1;j<=n;j++){
                    m2*=j;
                }

                return m1/(m2*m2*(n+1));
            } catch (Exception e) {
                e.printStackTrace();
            }


            return 0;
        }

    }

    public static void main(String[] args){
        Solution96 s=new Solution96();
        int ret=s.numTrees(7);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(ret);
    }
}
