package DP;

/**
 * Created by wunengbiao on 2017/2/24.
 */
public class Scramble_String_87 {

    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int[] letters=new int[26];
        for(int i=0;i<s1.length();i++){
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(letters[i]!=0) return false;
        }

        for(int i=1;i<s1.length();i++){
            if(isScramble(s1.substring(0,i),s2.substring(0,1)) &&
                    isScramble(s1.substring(i),s2.substring(i))) return true;

            if(isScramble(s1.substring(0,i),s2.substring(s2.length()-i)) &&
                    isScramble(s1.substring(i),s2.substring(0,s2.length()-i))) return true;
        }

        return false;

    }

    public static void main(String[] args){
        Scramble_String_87 s=new Scramble_String_87();
        String s1="great";
        String s2="rgtae";
        String s3="ab";
        String s4="aa";
        System.out.println(s.isScramble(s3,s4));

    }
}
