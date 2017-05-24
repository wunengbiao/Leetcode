package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wunengbiao on 2017/5/9.
 */
public class Minimum_Window_Substring_76 {
//    public String minWindow(String s, String t) {
//        String result="";
//
//        if(s.length()==0 || t.length()==0) return result;
//
//        Map<Character,Integer> map=new HashMap<>();
//        Map<Character,Integer> windows=new HashMap<>();
//
//        for(int i=0;i<t.length();i++){
//            int count=map.getOrDefault(t.charAt(i),0);
//            map.put(t.charAt(i),count+1);
//        }
//
//        System.out.println(map);
//
//        int minLength=Integer.MAX_VALUE;
//        int letterCounter=0;
//
//        for(int slow=0,fast=0;fast<s.length();fast++){
//            char c=s.charAt(fast);
//
//
//            if(map.containsKey(c)){
//                int old=windows.getOrDefault(c,0);
//                windows.put(c,old+1);
//
//                if(old+1<=map.get(c)){
//                    letterCounter++;
//                }
//            }
//
//            System.out.println(letterCounter);
//            if(letterCounter>=t.length()){
//                while(map.containsKey(s.charAt(slow)) || windows.getOrDefault(s.charAt(slow),0)>map.getOrDefault(s.charAt(slow),0)){
//                    char key=s.charAt(slow);
//                    int old=windows.getOrDefault(key,0);
//                    windows.put(key,old-1);
//                    slow++;
//                }
//
//                System.out.println(fast-slow+1<minLength);
//                if(fast-slow+1<minLength){
//                    minLength=fast-slow+1;
//
//                    System.out.println("slow:"+slow+",minLenght:"+minLength);
//                    result=s.substring(slow,minLength);
//                }
//            }
//        }
//
//        return result;
//
//    }

    String minWindow(String s,String t){
        int[] map=new int[256];
        for(Character c:t.toCharArray()) map[c]++;

        int counter=t.length(),begin=0,end=0,d=Integer.MAX_VALUE,head=0;

        while(end<s.length()){
            if(map[s.charAt(end++)]-->0) counter--;
            while(counter==0){
                if(end-begin<d) d=end-(head=begin);
                if(map[s.charAt(begin++)]++==0) counter++;
            }
        }
        System.out.println(head);
        System.out.println(d);

        return d==Integer.MAX_VALUE?"":s.substring(head,d+head);
    }

    public static void main(String[] args){
        Minimum_Window_Substring_76 s=new Minimum_Window_Substring_76();
        System.out.println(s.minWindow("ADOBECODEBANC","ABC"));
//        System.out.println(s.minWindow("a","aa"));
//        System.out.println(Integer.valueOf('A'));

        int i=0;
        System.out.println(i++==0);

        System.out.println(i);

    }
}
