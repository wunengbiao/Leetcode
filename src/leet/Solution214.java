package leet;

import ChinaMobile.Solution;

/**
 * Created by wunengbiao on 2017/1/1.
 */
public class Solution214 {
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) { j += 1; }
        }
        if (j == s.length()) { return s; }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }

    public static void main(String[] args){
        Solution214 s=new Solution214();
        String res=s.shortestPalindrome("caacecaab");
        System.out.println(res);
    }
}
