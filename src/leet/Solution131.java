package leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2016/9/25.
 */
public class Solution131 {
    public List<List<String>> partition(String s) {

        if(s.isEmpty()) return new ArrayList<List<String>>();
        int len=s.length();
        if(len==1){
            List<String> temp=new ArrayList<>();
            temp.add(s);
            List<List<String>>ret =new ArrayList<>();
            ret.add(temp);
            return ret;
        }else{
            List<List<String>> ret=new ArrayList<>();
            int pos=0;
            while(pos<len){
                if(isPalindrome(s,0,pos)){
                    if(pos==len-1){
                        List<String> temp=new ArrayList<>();
                        temp.add(s.substring(0,pos+1));
                        ret.add(temp);
                    }
                    else{
                        List<List<String>> subRet=partition(s.substring(pos+1));
                        for(List<String> l:subRet){
                            l.add(0,s.substring(0,pos));
                            ret.add(l);
                        }
                    }

                }
                ++pos;
            }
            return ret;
        }

    }

    public boolean isPalindrome(String s,int begin,int end){

        if(begin<0||begin>end||end>s.length()) return false;
        while(begin<end){
            if(s.charAt(begin)!=s.charAt(end)){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String[] args){
        Solution131 s=new Solution131();
        List<List<String>> ret=s.partition("aab");
        System.out.println(ret);
    }

}
