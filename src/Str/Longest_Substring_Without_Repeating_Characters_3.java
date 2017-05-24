package Str;

/**
 * Created by wunengbiao on 2017/3/19.
 */
public class Longest_Substring_Without_Repeating_Characters_3 {

    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) return s.length();
        int pointer1=0;
        int pointer2=1;

        int res=1;
        for(;pointer1<s.length();pointer1++){

            for(;pointer2<s.length();pointer2++){
                for(int k=pointer1;k<pointer2;k++){
                    if(s.charAt(pointer2)!=s.charAt(k)){
                        if(pointer2==s.length()-1 &&k==pointer2-1)
                            res=Math.max(res,pointer2-pointer1+1);
                    }
                    else{
                        if(pointer2==s.length()-1 && k==pointer2-1)
                            res=Math.max(res,pointer2-pointer1);
                        res=Math.max(res,pointer2-pointer1);
                        pointer1=k+1;
                    }
                }
                if(pointer2==s.length()-1) return res;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Longest_Substring_Without_Repeating_Characters_3 s=new Longest_Substring_Without_Repeating_Characters_3();

        System.out.println(s.lengthOfLongestSubstring("au"));
    }
}
