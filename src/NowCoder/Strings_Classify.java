package NowCoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by wunengbiao on 2017/6/5.
 */
public class Strings_Classify {
    public int hashcode(String s){
        if(s.equals("")) return 1;
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        int key=1;
        for(char c:s.toCharArray()){
            key*=prime[c-'a'];
        }
        return key;
    }

    public int solve(String[] strs){
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<strs.length;i++){
            set.add(hashcode(strs[i]));
        }
        return set.size();
    }

    public static void main(String[] args){
        Strings_Classify s=new Strings_Classify();
        Scanner in=new Scanner(System.in);

        int n=Integer.parseInt(in.nextLine());
        String[] strs=new String[n];

        for(int i=0;i<n;i++){
            strs[i]=in.nextLine();
        }

        System.out.println(s.solve(strs));
    }
}
