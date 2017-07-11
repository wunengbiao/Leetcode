package DP;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by wunengbiao on 2017/6/9.
 */
public class Unique_Substrings_in_Wraparound_String_467 {
    public int findSubstringInWraproundString(String p) {
        int[] count=new int[26];

        int maxLengthCur=0;
        for(int i=0;i<p.length();i++){
            if(i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))){
                maxLengthCur++;
            }else{
                maxLengthCur=1;
            }

            int index=p.charAt(i)-'a';
            count[index]=Math.max(count[index],maxLengthCur);
        }

        int res=0;
        for(int i=0;i<26;i++){
            res+=count[i];
        }
        return res;
    }
}
