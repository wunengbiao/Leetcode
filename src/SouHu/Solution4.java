package SouHu;

/**
 * Created by wunengbiao on 2016/9/23.
 */
public class Solution4 {

    final String[] nums_str={"ZERO","ONE","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
    public int solve(String str){
        char[] num_chars=str.toCharArray();
        int[] countC=new int[26];
        for(int i=0;i<num_chars.length;i++){
            countC[num_chars[i]-'A']++;
        }
        if(countC['Z'-'A']!=0){
            countC['E'-'A']-=countC['Z'-'A'];
            countC['R'-'A']-=countC['Z'-'A'];
            countC['O'-'A']-=countC['Z'-'A'];
        }

        return 0;
    }
}
