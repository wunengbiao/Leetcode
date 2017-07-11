package NowCoder;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/6/5.
 */
public class YeMa {
    public int[] solve(int n){
        int[] res=new int[10];

        if(n==0) return res;
        if(n%10<9){
            res=solve(n-1);
            while(n>0){
                res[n%10]++;
                n/=10;
            }
            return res;
        }

        res=solve(n/10);
        for(int i=0;i<10;i++){
            res[i]=res[i]*10+n/10+(i>0?1:0);
        }
        return res;
    }

    public static void main(String[] args){
        YeMa s=new YeMa();
        System.out.println(Arrays.toString(s.solve(21345)));
    }
}
