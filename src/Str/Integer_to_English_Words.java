package Str;

/**
 * Created by wunengbiao on 2017/5/18.
 */
public class Integer_to_English_Words {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS={"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    private final String[] THOUSANDS={"","Thousands","Million","Billion"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        int i=0;
        String res="";

        while(num>0){
            if(num%1000!=0)
                res=helper(num%1000)+THOUSANDS[i]+" "+res;
            num/=1000;
            i++;
        }
        return res.trim();
    }

    public String helper(int nums){
        if(nums==0) return "";
        if(nums<20) return LESS_THAN_20[nums]+" ";
        if(nums<100) return TENS[nums/10]+" "+helper(nums%10);
        else return helper(nums/100)+" Hundred "+helper(nums%100);
    }

    public static void main(String[] args){
        Integer_to_English_Words s=new Integer_to_English_Words();
        System.out.println(s.numberToWords(1234567));
    }
}
