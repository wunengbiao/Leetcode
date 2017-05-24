package Greedy;

import java.util.*;

/**
 * Created by wunengbiao on 2017/5/12.
 */
public class Remove_Duplicate_Letters_316 {
    public String removeDuplicateLetters(String s) {
        Map<Character,List<Integer>> counts=new HashMap<>();
        List<Character> keys=new ArrayList<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!counts.containsKey(c)){
                counts.put(c,new ArrayList<>());
                keys.add(c);
            }
            counts.get(c).add(i);
        }

        System.out.println(counts);
        System.out.println(keys);

        Collections.sort(keys);

        StringBuilder sb=new StringBuilder();

        while(!counts.isEmpty()){

            boolean found=true;
            for(int i=0;i<keys.size();i++){
                int index=counts.get(keys.get(i)).get(0);

                for(int j=0;j<keys.size();j++){
                    List<Integer> count=counts.get(keys.get(j));
                    if(count.get(count.size()-1)<index){
                        found=false;
                        break;
                    }
                }


                if(found){
                    sb.append(keys.get(i));
                    counts.remove(keys.get(i));
                    keys.remove(i);

                    for (int j = 0; j < keys.size(); j++) {
                        List<Integer> count = counts.get(keys.get(j));
                        while (count.get(0) < index) {
                            count.remove(0);
                        }
                    }
                    break;
                }
                found=true;

            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Remove_Duplicate_Letters_316 s=new Remove_Duplicate_Letters_316();
        System.out.println(s.removeDuplicateLetters("bcabc"));
    }
}
