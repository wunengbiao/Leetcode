package leet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wunengbiao on 2016/10/15.
 */
public class Test {

    int i=0;
    public void backtrack(int n){
        if(n>10) return;
        backtrack(n+1);
        i++;
        if(n==i) System.out.println(n);
        if(n-1==i) System.out.println(i+" "+n);

    }

    public static boolean isDigit(char s){
        if(s-'0'>=0 && s-'0'<=9)
            return true;
        return false;
    }

    public static void main(String[] args) throws ParseException {
//        List<Integer> tmp=new ArrayList<>();
//        tmp.add(1);
//        tmp.add(2);
//        tmp.add(3);
//        Collections.reverse(tmp);
//
//        System.out.println(tmp);
//
//        System.out.println(Math.floor(1.0));
//        System.out.println(Math.ceil(1.0));
//
//        List<Integer>p1=new ArrayList<>();
//        p1.add(1);
//        p1.add(2);
//        p1.add(3);
//        List<Integer>p2=new ArrayList<>();
//        p1.add(4);
//        p1.add(5);
//        p1.add(6);
//
//        List<List<Integer>> l1=new ArrayList<>();
//        l1.add(p1);
//        l1.add(p2);
//
//        List<List<Integer>> result=new ArrayList<>();
//        result.addAll(l1);
//        System.out.println(result);
//        String a="abc";
//        String b=a;
//        a="cde";
//        System.out.println(b);

//         int a[][] ={
//                {3,2,1},{4,6,5}
//        };
//
//        System.out.println(a.length);
//        System.out.println(a[0].length);

//        String a="abc";
//        System.out.println(a.substring(2,3));
//        System.out.println(a+'c');
//
//        List<Integer> test=Arrays.asList();
//        System.out.println(test);

//        Test test=new Test();
//        test.backtrack(1);

//        List<Integer> res=new ArrayList<>();
//        res.add(1);
//        res.add(null);
//        res.add(2);
//
//        System.out.println(res);
//        System.out.println("["+null+"]");

//        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//
//        Date date=format.parse("2016-10-27 00:00:00");
//        System.out.println(date.getTime());

        Set<String> set=new HashSet<>();

        set.add("Hello");
        set.add("World");
        set.remove("Hello");

        System.out.println(set);

        List<String> src=new ArrayList<>();
        src.add("Hello");
        src.add("World");

        List<String>dest=new ArrayList<>();
        Collections.copy(dest,src);
        System.out.println(dest);

    }

}
