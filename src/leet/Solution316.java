package leet;

import java.util.*;

/**
 * Created by wunengbiao on 2016/10/23.
 */
public class Solution316 {

    public String removeDuplicateLetters(String s) {
        int[] res=new int[26];
        boolean[] visited=new boolean[26];
        char[] ch=s.toCharArray();
        for(char c:ch){
            res[c-'a']++;
        }

        Stack<Character> st=new Stack<>();
        int index;

        for(char c:ch){
            index=c-'a';
            res[index]--;
            if(visited[index])
                continue;
            while(!st.isEmpty() && c<st.peek() && res[st.peek()-'a']!=0){
                visited[st.pop()-'a']=false;
            }
            st.push(c);
            visited[index]=true;
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        return sb.toString();

    }

    public static void main(String[] args){
        Solution316 s=new Solution316();
        String test1="cbacdcbc";
        System.out.println("Result is:"+s.removeDuplicateLetters(test1));
    }
}
