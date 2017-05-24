package Str;

/**
 * Created by wunengbiao on 2017/3/22.
 */
public class Integer_to_English_Words_273 {

    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        int i=0;
        String word="";
        while(num>0){
            if(num%1000!=0)
                word=helper(num%1000)+THOUSANDS[i]+" "+word;
            num/=1000;
            i++;
        }

        return word.trim();
    }

    public String helper(int num){
        if(num==0) return "";
        if(num<20) return LESS_THAN_20[num]+" ";
        if(num<100) return TENS[num/10]+" "+helper(num%10);
        else return helper(num/100)+"Hundred "+helper(num%100);
    }

    public static void main(String[] args){
        Integer_to_English_Words_273 solution=new Integer_to_English_Words_273();
        System.out.println(solution.numberToWords(12345).length());
        System.out.println(solution.numberToWords(12345));
        System.out.println("Twelve Thousand Three Hundred Forty Five");
    }
}
