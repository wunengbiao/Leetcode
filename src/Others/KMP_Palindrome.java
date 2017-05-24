package Others;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/3/22.
 */
public class KMP_Palindrome {
    public int solve(String s){
        StringBuilder builder=new StringBuilder(s);
        String str=s+"#"+builder.reverse().toString();
        int[] p=new int[str.length()];

        for(int i=1;i<str.length();i++){
            int j=p[i-1];
            while(j>0 && str.charAt(i)!=str.charAt(j)) j=p[j-1];
            p[i]=j==0?(str.charAt(i)==str.charAt(0)?1:0):j+1;
        }

        System.out.println(Arrays.toString(p));

        return p[str.length()-1];

    }

    public static void main(String[] args){
        KMP_Palindrome kmp_palindrome=new KMP_Palindrome();
        System.out.println(kmp_palindrome.solve("aaaa"));
    }
}
