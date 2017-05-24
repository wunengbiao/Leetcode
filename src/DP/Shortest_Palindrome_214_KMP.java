package DP;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/3/22.
 */
public class Shortest_Palindrome_214_KMP {
    public String shortestPalindrome(String s) {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().substring(0, s.length() - getCommonLength(s)) + s;
    }

    private int getCommonLength(String str) {
        StringBuilder builder = new StringBuilder(str);
        String rev = new StringBuilder(str).reverse().toString();
        builder.append("#").append(rev);
        System.out.println(builder.toString());
        int[] p = new int[builder.length()];
        for (int i = 1; i < p.length; i++) {
            int j = p[i - 1];
            while (j > 0 && builder.charAt(i) != builder.charAt(j)) j = p[j - 1];
            p[i] = j == 0 ? (builder.charAt(i) == builder.charAt(0) ? 1 : 0) : j + 1;
        }
        System.out.println(Arrays.toString(p));
        return p[p.length - 1];
    }

    public static void main(String[] args){
        Shortest_Palindrome_214_KMP solution=new Shortest_Palindrome_214_KMP();
        System.out.println(solution.shortestPalindrome("aacecaaa"));
        System.out.println(solution.shortestPalindrome("aaaaaaaa"));
    }
}
