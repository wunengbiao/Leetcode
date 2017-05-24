package Greedy;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/4/9.
 */
public class Assign_Cookies_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while(i<g.length && j<s.length){
            if(s[j]>=g[i]){
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        return i;
    }
}
