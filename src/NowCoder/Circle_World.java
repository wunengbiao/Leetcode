package NowCoder;

import java.util.*;

/**
 * Created by wunengbiao on 2017/5/31.
 */
public class Circle_World {
//    public int solve(String[] words) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            int hash = hashcode(words[i]);
//            if (map.containsKey(hash)) {
//                map.put(hash, map.get(hash) + 1);
//            } else {
//                map.put(hash, 1);
//            }
//        }
//
//        return map.size();
//    }

//    public int hashcode(String s) {
//        if (s.equals("")) return 1;
//        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
//        int key = 1;
//        for (char c : s.toCharArray()) {
//            key *= prime[c - 'a'];
//        }
//        return key;
//    }

    public int solve(List<String> list){
        int count=0;
        while(list.size()!=0){
            String cur=list.get(0);
            for(int i=0;i<cur.length();i++){
                String dic=cur.substring(i,cur.length())+cur.substring(0,i);
                list.remove(dic);
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Circle_World s = new Circle_World();

        int n = Integer.parseInt(in.nextLine());
        List<String> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word= in.nextLine();
            list.add(word);
        }
        System.out.println(s.solve(list));
    }
}
