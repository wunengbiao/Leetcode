package leet;


import java.util.Stack;

/**
 * Created by wunengbiao on 2017/2/9.
 */
public class Solution456 {

    class Pair{
        int min;
        int max;
        Pair(int min,int max){
            this.min=min;
            this.max=max;
        }
    }

    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack=new Stack<>();

        for(int n:nums){
            if(stack.isEmpty() || n<stack.peek().min)
                stack.push(new Pair(n,n));
            else if(n>stack.peek().min){
                Pair last=stack.pop();
                if(n<last.max) return true;
                else{
                    last.max=n;
                    while(!stack.isEmpty() && n>=stack.peek().max) stack.pop();
                    if(!stack.isEmpty() && stack.peek().min<n) return true;
                    stack.push(last);
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Solution456 s=new Solution456();
        int[] nums={-2,1,-2};
        System.out.println(s.find132pattern(nums));
    }
}
