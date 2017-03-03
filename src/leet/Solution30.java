package leet;

import java.util.*;

/**
 * Created by wunengbiao on 2016/10/21.
 */
public class Solution30 {

   public List<Integer> findSubstring(String S, String[] L) {

       int n=L[0].length();

       Map<String,Integer> position=new HashMap<>();
       for(int i=0;i<L.length;i++) position.put(L[i],i);

       Map<String,List<Integer>> map=new HashMap<>();
       for(int i=0;i<L.length;i++){
           map.put(L[i],new ArrayList<>());
       }
       for(int i=0;i<S.length()-n;i++){
           if(map.containsKey(S.substring(i,i+n))){
               map.get(S.substring(i,i+n)).add(i);
           }
       }
       List<Integer> result=new ArrayList<>();

       for(int i=0;i<L.length;i++){
           if(map.get(L[i]).size()==0) return result;
       }

       int[] counts=new int[L.length];
       int[] sequence=new int[L.length];
       for(int i=0;i<L.length;i++){
           sequence[i]=map.get(L[i]).get(counts[i]);
       }

       int min=findMin(sequence);
       while(counts[min]<map.get(L[min]).size()){
           if(isSequence(sequence)) result.add(min);
           else{
               counts[min]++;
               sequence[min]=map.get(L[min]).get(counts[min]);

               min=findMin(sequence);
           }
       }



       return result;


    }

    public boolean isSequence(int[] sq){

       int[] temp=new int[sq.length];
       for(int i=0;i<sq.length;i++){
           temp[i]=sq[i];
       }
       Arrays.sort(temp);
       if(temp.length<=1) return true;
       int diff=temp[1]-temp[0];

       for(int i=0;i<temp.length-1;i++){
           if(temp[i+1]-temp[i]!=diff) return false;
       }

       return true;

    }

    public int findMin(int[] sq){
        int index=0;
        for(int i=1;i<sq.length;i++){
            if(sq[i]<sq[index]){
                index=i;
            }
        }
        return index;
    }


    public static void main(String[] args){
        Solution30 s=new Solution30();
        String[] words={"foo","bar","the"};

        List<Integer> result=s.findSubstring("barfoofodasssssssssssssssdasdassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssobarthefoobarman",words);
        System.out.println(result);
    }
}
