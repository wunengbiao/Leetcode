package NetEase.SHiXi2017.neitui_2016;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/9.
 * [编程题] 藏宝图
   牛牛拿到了一个藏宝图，顺着藏宝图的指示，牛牛发现了一个藏宝盒，藏宝盒上有一个机关，
   机关每次会显示两个字符串 s 和 t，根据古老的传说，牛牛需要每次都回答 t 是否是 s 的子序列。
   注意，子序列不要求在原字符串中是连续的，例如串 abc，它的子序列就有 {空串, a, b, c, ab, ac, bc, abc} 8 种。
 */
public class Solution6 {
    public boolean solve(String s1,String s2){
        int left=0;
        int right=0;

        while(left<s1.length() && right<s2.length()){
            if(s1.charAt(left)!=s2.charAt(right))
                left++;
            else{
                left++;
                right++;
            }
        }

        if(right==s2.length())
            return true;
        return false;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Solution6 s=new Solution6();
        while(in.hasNext()){
            String s1=in.nextLine();
            String s2=in.nextLine();
            System.out.println(s.solve(s1,s2)?"Yes":"No");
        }
    }
}
