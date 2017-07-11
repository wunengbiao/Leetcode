package DP;

/**
 * Created by wunengbiao on 2017/5/31.
 */
public class Non_negative_Integers_without_Consecutive_Ones_600 {
    public int findIntegers(int num) {
        if(num==0) return 0;

        int before=0;
        for(int i=1;i<=num;i++){
            if((i & (i-1))>=(i-1) || (i & (i-1))==0)
                before=i;
        }
        return before;
    }

    public static void main(String[] args){
        Non_negative_Integers_without_Consecutive_Ones_600 s=new Non_negative_Integers_without_Consecutive_Ones_600();
        System.out.println(s.findIntegers(6));
    }
}
