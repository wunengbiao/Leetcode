package QuanGuo;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/12.
 */
public class DNA {

    public int solve(String s1,String s2){
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)=='A' && s2.charAt(i)!='T') count++;
            else if(s1.charAt(i)=='T' && s2.charAt(i)!='A') count++;
            else if(s1.charAt(i)=='C' && s2.charAt(i)!='G') count++;
            else if(s1.charAt(i)=='G' && s2.charAt(i)!='C') count++;
        }
        return count;
    }

    public static void main(String[] args){
        DNA solve=new DNA();

        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        String[] strs=str.split(" ");

        System.out.println(solve.solve(strs[0],strs[1]));
    }
}
