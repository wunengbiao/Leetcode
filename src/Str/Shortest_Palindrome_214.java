package Str;

/**
 * Created by wunengbiao on 2017/3/21.
 */
public class Shortest_Palindrome_214 {
    public String shortestPalindrome(String s) {
        if(s.length()<=1) return s;
        int max_index=1;
        for(int n=s.length();n>=2;n--){
            if(isPalindrome(s.substring(0,n))){
                max_index=n;
                break;
            }
        }
        return new StringBuffer(s.substring(max_index)).reverse().toString()+s;
    }

    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args){
        Shortest_Palindrome_214 solution=new Shortest_Palindrome_214();
        System.out.println(solution.shortestPalindrome("aacecaaa"));
    }
}
