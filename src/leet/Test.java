package leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/15.
 */
public class Test {

    public static void main(String[] args){
        List<Integer> tmp=new ArrayList<>();
        tmp.add(1);
        tmp.add(2);
        tmp.add(3);
        Collections.reverse(tmp);

        System.out.println(tmp);

        System.out.println(Math.floor(1.0));
        System.out.println(Math.ceil(1.0));

        List<Integer>p1=new ArrayList<>();
        p1.add(1);
        p1.add(2);
        p1.add(3);
        List<Integer>p2=new ArrayList<>();
        p1.add(4);
        p1.add(5);
        p1.add(6);

        List<List<Integer>> l1=new ArrayList<>();
        l1.add(p1);
        l1.add(p2);

        List<List<Integer>> result=new ArrayList<>();
        result.addAll(l1);
        System.out.println(result);

    }
}
