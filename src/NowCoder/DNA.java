package NowCoder;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/5/31.
 */
public class DNA {
    public int solve(String s1,String s2){
        int n=s1.length();
        int c1=0;
        int c2=0;
        for(int i=0;i<n;i++){
            if(s1.charAt(i)=='A'){
                if(s2.charAt(i)!='T') c1++;
            }
            if(s1.charAt(i)=='T'){
                if(s2.charAt(i)!='A') c1++;
            }
            if(s1.charAt(i)=='C'){
                if(s2.charAt(i)!='G') c1++;
            }
            if(s1.charAt(i)=='G'){
                if(s2.charAt(i)!='C') c1++;
            }

            if(s2.charAt(i)=='A'){
                if(s1.charAt(i)!='T') c2++;
            }
            if(s2.charAt(i)=='T'){
                if(s1.charAt(i)!='A') c2++;
            }
            if(s2.charAt(i)=='C'){
                if(s1.charAt(i)!='G') c2++;
            }
            if(s2.charAt(i)=='G'){
                if(s1.charAt(i)!='C') c2++;
            }
        }
        return Math.min(c1,c2);
    }

    public static void main(String[] args){
        DNA s=new DNA();
        Scanner in=new Scanner(System.in);
        String[] strs=in.nextLine().split(" ");
        System.out.println(s.solve(strs[0],strs[1]));

    }
}
