package leet;

/**
 * Created by wunengbiao on 2016/10/20.
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        int[] pnext=next(needle);
        int i=0,j=0;
        int n=haystack.length();
        int m=needle.length();
        while(j<n && i<m){
            if(i==-1 || haystack.charAt(j)==needle.charAt(i)){
                j++;i++;
            }else{
                i=pnext[i];
            }
        }
        if(i==m){
            return j-i;
        }
        return -1;
    }

    public int[] next(String s){
        int[] pnext=new int[s.length()];
        for(int i=0;i<s.length();i++){
            pnext[i]=-1;
        }

        int k=-1;
        int i=0;

        while(i<s.length()-1){
            if(k==-1 || s.charAt(i)==s.charAt(k)){
                i++;k++;
                if(s.charAt(i)==s.charAt(k)){
                    pnext[i]=pnext[k];
                }else{
                    pnext[i]=k;
                }
            }else {
                k=pnext[k];
            }
        }
        return pnext;
    }

    public static void main(String[] args){
        Solution28 s=new Solution28();
        int result=s.strStr("ababcabcacbab","abcac");
        System.out.println(result);
    }
}
