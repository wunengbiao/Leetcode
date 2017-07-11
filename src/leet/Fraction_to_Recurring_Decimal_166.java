package leet;

import java.util.HashMap;

/**
 * Created by wunengbiao on 2017/7/9.
 */
public class Fraction_to_Recurring_Decimal_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        if(denominator==0) return "";

        String ans="";
        if((numerator<0)^(denominator<0)) ans+="-";

        long num=numerator,den=denominator;
        num=Math.abs(num);
        den=Math.abs(den);

        long res=num/den;
        ans+=String.valueOf(res);

        long rem=(num%den)*10;
        if(rem==0) return ans;

        HashMap<Long,Integer> map=new HashMap<>();
        ans+='.';
        while(rem!=0){
            if(map.containsKey(rem)){
                int beg=map.get(rem);
                String part1=ans.substring(0,beg);
                String part2=ans.substring(beg,ans.length());
                ans=part1+"("+part2+")";
                return ans;
            }

            map.put(rem,ans.length());
            res=rem/den;
            ans+=String.valueOf(res);
            rem=(rem%den)*10;

        }
        return ans;
    }

    public static void main(String[] args){
        Fraction_to_Recurring_Decimal_166 s=new Fraction_to_Recurring_Decimal_166();
        System.out.println(s.fractionToDecimal(1,3));
    }
}
