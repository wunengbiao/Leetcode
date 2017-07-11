package Baidu;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wunengbiao on 2017/4/10.
 *
 * 括号表达式在数学四则计算中经常用到，用于改变运算的优先级，这也是一个关于括号的问题。对于一个给定的括号序列，如果在其中插入"+"和"1"后构成一个正确的数学表达式，则认为该括号序列是正则的。根据该定义，括号序列"(())()"、"()"及"(()(()))"都构成正则序列，序列")("、"(()"和"(()))("不是正则序列。

 小B正在头疼的一个问题是，给定一个由"("、")"和"?"构成的序列，如何将其中的"?"替换为单个的括号，从而使得该序列成为一个正则序列。更麻烦的事情在于，替换每个"?"都有着不同的代价，如何才能花费最小的代价将给定的序列转换为一个正则序列。作为朋友，小B希望你能够帮到她。

 (??)
 1 2
 2 8
 (?)
 1 2
 (??)
 2 2
 1 1

 4
 ()()
 -1
 3
 ()()
 */
public class Minimal_Brackets_Sequence {

    int min_cost;
    String print;
    Minimal_Brackets_Sequence(){
        min_cost=Integer.MAX_VALUE;
        print="-1";
    }
    public void helper(char[] str,int i ,int stack,int[][] costs,int cost,int pos){
        if(stack<0 || stack>str.length/2) return;
        if(i==str.length){

            if(cost<min_cost && stack==0){
                min_cost=cost;
                print=new String(str);
            }
        }else{
            if(str[i]=='(') helper(str,i+1,stack+1,costs,cost,pos);
            else if(str[i]==')') helper(str,i+1,stack-1,costs,cost,pos);
            else{
                str[i]=')';
                helper(str,i+1,stack-1,costs,cost+costs[pos][1],pos+1);
                str[i]='(';
                helper(str,i+1,stack+1,costs,cost+costs[pos][0],pos+1);
                str[i]='?';
            }
        }
    }

    public void solve(String s ,int[][] cost){
        if(s.length()%2==1){
            System.out.println(-1);
            return;
        }
        int left=0;
        int right=0;
        for(Character c:s.toCharArray()){
            if(c=='(') left++;
            else if(c==')') right++;
        }

        if(left>s.length()/2 || right>s.length()/2){
            System.out.println(-1);
            return;
        }

        helper(s.toCharArray(),0,0,cost,0,0);
        if(min_cost==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }else{
            System.out.println(min_cost);
            System.out.println(print);
            return;
        }
    }

    public int count_unkown(String line){
        int count=0;
        for(int i=0;i<line.length();i++){
            if(line.charAt(i)=='?') count++;
        }
        return count;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Minimal_Brackets_Sequence s;
        String line;
        int[][] costs;

        while(true){
            s=new Minimal_Brackets_Sequence();
            line=in.nextLine();
            int n=s.count_unkown(line);
            costs=new int[n][2];
            for(int i=0;i<n;i++){
                String[] nums=in.nextLine().split(" ");
                costs[i][0]=Integer.parseInt(nums[0]);
                costs[i][1]=Integer.parseInt(nums[1]);
            }
            s.solve(line,costs);
        }
    }
}
