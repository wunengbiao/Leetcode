package Baidu;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wunengbiao on 2017/4/10.
 */
public class Minimal_Brackets_Sequence {

    String sequence;
    int[][] cost_table;
    int min_cost;
    String print;
    int count_left;
    int count_right;
    int count_unkown;

    Minimal_Brackets_Sequence(String sequence,int[][] cost_table){
        this.sequence=sequence;
        this.cost_table=cost_table;
        min_cost=Integer.MAX_VALUE;
        print=null;
        count_left=0;
        count_right=0;
        count_unkown=0;
    }

    public boolean isValid(String s){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') st.push('(');
            if(s.charAt(i)==')'){
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }




    public void count(String s){
        for(Character c:s.toCharArray()){
            if(c=='(') count_left++;
            if(c==')') count_right++;
            if(c=='?') count_unkown++;
        }
    }

    public static int count_w(String s){
        int res=0;
        for(Character c:s.toCharArray()){
            if(c=='?') res++;
        }
        return res;
    }

    public void backtrack(String s,int i,int j,int z,int half,int cost){

        if(i==half && j==half){
            if(cost<min_cost && isValid(s)){
                min_cost=cost;
                print=s;
            }
            return;
        }

        if(j<half){
            String temp=s.replaceFirst("\\?",")");
            backtrack(temp,i,j+1,z+1,half,cost+cost_table[z][1]);
        }
        if(i<half){
            String temp=s.replaceFirst("\\?","(");
            backtrack(temp,i+1,j,z+1,half,cost+cost_table[z][0]);
        }

    }

    public void solve(){

        if(sequence.length()%2==0 && count_left<= sequence.length()/2 && count_right<= sequence.length()/2){
            count(sequence);
            backtrack(sequence,count_left,count_right,0,sequence.length()/2,0);
        }else {
            min_cost=-1;
            print=null;
        }

    }

    public static void main(String[] args){

        int y=0;
        Scanner in=new Scanner(System.in);
        Minimal_Brackets_Sequence s;
        while(in.hasNext()){
            y++;
            String sequence=in.nextLine();
            int count_w=Minimal_Brackets_Sequence.count_w(sequence);
            int[][] cost_table=new int[count_w][2];
            for(int i=0;i<count_w;i++){
                String[] nums=in.nextLine().split(" ");
                cost_table[i][0]=Integer.parseInt(nums[0]);
                cost_table[i][1]=Integer.parseInt(nums[1]);
            }
            s=new Minimal_Brackets_Sequence(sequence,cost_table);
            s.count(sequence);
            System.out.println("("+s.count_left+","+s.count_right+","+s.count_unkown+")");
            System.out.println(y+":"+sequence.length());
            s.solve();



            System.out.println(y+":"+s.min_cost);
            if(s.min_cost!=-1) System.out.println(y+":"+s.print);
            System.out.println("-------------------------------");
        }
    }



}
