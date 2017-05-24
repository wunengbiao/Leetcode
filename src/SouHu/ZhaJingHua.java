package SouHu;

import java.util.*;

/**
 * Created by wunengbiao on 2017/3/9.
 */
public class ZhaJingHua {

    public int[] decompose(String s){
        Set<Character> valid_char=new HashSet<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9','J','Q','K','A'));

        int i=0;
        int cur=0;
        int[] result=new int[3];

        while(i<s.length()){
            if(!valid_char.contains(s.charAt(i))) return null;
            if(s.charAt(i)=='0') return null;
            if(s.charAt(i)=='1'){
                if(s.charAt(++i)=='0') result[cur++]=10;
                else return null;
            }
            else if(s.charAt(i)=='J') result[cur++]=11;
            else if(s.charAt(i)=='Q') result[cur++]=12;
            else if(s.charAt(i)=='K') result[cur++]=13;
            else if(s.charAt(i)=='A') result[cur++]=14;
            else result[cur++]=s.charAt(i)-'0';

            if(cur==3 &&i!=s.length()-1) return null;
            if(cur!=3 && i==s.length()-1) return null;
            i++;
        }
        Arrays.sort(result);
        return result;
    }

    public int compare(int[] a,int[] b){
        int p1=sum(a[0],a[1],a[2]);
        int p2=sum(b[0],b[1],b[2]);
        if(p1==p2) return 0;
        if(p1>p2) return 1;
        else return -1;

    }

    public int sum(int a,int b,int c){
        int sum=0;
        if(a==b && b==c) return a+1000000;
        if(b-a==1 && c-b==1) return c+100000;
        else if(a==b) return a*15+10000+c;
        else if(b==c) return b*15+10000+a;
        else return c*300+b*15+c*1;
    }

    public static void main(String[] args){
        ZhaJingHua s=new ZhaJingHua();
        Scanner in=new Scanner(System.in);

        while (in.hasNext()){
            String str=in.nextLine();
            String[] strs=str.split(" ");

            if(s.decompose(strs[0])==null || s.decompose(strs[1])==null)
                System.out.println(-2);
            else
                System.out.println(s.compare(s.decompose(strs[0]),s.decompose(strs[1])));
        }
    }
}
