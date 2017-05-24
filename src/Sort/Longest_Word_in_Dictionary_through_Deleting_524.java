package Sort;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/3/26.
 */
public class Longest_Word_in_Dictionary_through_Deleting_524 {
    public String findLongestWord(String s, List<String> d) {
        String res="";
        int max=0;
        for(String s2:d){
            if(isSubsquence(s,s2)){
                if(s2.length()>max) {
                    res=s2;
                    max=s2.length();
                }
                else if(s2.length()==max){
                    if(s2.compareTo(res)<0)
                        res=s2;
                }
            }
        }

        return res;
    }

    public boolean isSubsquence(String s1,String s2){
        int n=s1.length();
        int m=s2.length();

        int i=0,j=0;
        while(i<n && j<m){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }

        if(j==s2.length()) return true;
        else return false;
    }

    public static void main(String[] args){
        Longest_Word_in_Dictionary_through_Deleting_524 solution=new Longest_Word_in_Dictionary_through_Deleting_524();

        String s="foobarfoobar";
        List<String> dic= Arrays.asList("foo","bar");

//        String s="abpcplea";
//        List<String> dic= Arrays.asList("ale","apple","monkey","plea");
//        List<String> dic= Arrays.asList("a","b","c");

        System.out.println("bar".compareTo("foo"));
        System.out.println(solution.findLongestWord(s,dic));
    }
}
