package Greedy;

/**
 * Created by wunengbiao on 2017/5/12.
 */
public class Is_Subsequence_392 {
    public boolean isSubsequence(String s, String t) {

        int l1=s.length();
        int l2=t.length();

        int i=0;
        int j=0;

        while(i<l1 && j<l2){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }

        if(i==l1) return true;
        return false;

    }

    public static void main(String[] args){
        Is_Subsequence_392 s=new Is_Subsequence_392();
        System.out.println(s.isSubsequence("axc","ahbgdc"));
    }
}
