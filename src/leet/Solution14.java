package leet;

import ChinaMobile.Solution;

/**
 * Created by wunengbiao on 2016/10/20.
 */
public class Solution14 {
     public String longestCommonPrefix(String[] strs) {
         if(strs.length==0) return "";
         int minLength=Integer.MAX_VALUE;
         for(int i=0;i<strs.length;i++){
             if(strs[i].length()<minLength) minLength=strs[i].length();
         }
         if(minLength==0) return "";
         int prefix=0;
         for(int i=0;i<minLength;i++){
             boolean flag=true;
             for(int j=0;j<strs.length;j++){
                 if(strs[j].charAt(i)!=strs[0].charAt(i)){
                     flag=false;
                     break;
                 }
             }
             if(flag==true){
                  prefix++;
             }else{
                 break;
             }

         }

         if(prefix==0) return "";
         else{
             String result=strs[0].substring(0,prefix);
            return result;
         }

    }
    public static void main(String[] args){
        Solution14 s=new Solution14();
        String a[]={
          "aca","cba"
        };
        System.out.println(s.longestCommonPrefix(a));
    }
}
