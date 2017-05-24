package BitManipulation;

import Array.Maximum_Subarray_53;

/**
 * Created by wunengbiao on 2017/5/14.
 */
public class Maximum_Product_of_Word_Lengths_318 {
//    public int maxProduct(String[] words) {
//        if(words==null || words.length==0) return 0;
//
//        int max=0;
//        for(int i=0;i<words.length;i++){
//            for(int j=0;j<words.length;j++){
//                if(i==j) continue;
//                max=Math.max(max,toBytes(words[i],words[j]));
//            }
//        }
//        return max;
//    }
//    public int toBytes(String words1,String words2){
//        int[] flags=new int[26];
//        for(int i=0;i<words1.length();i++){
//            flags[words1.charAt(i)-'a']++;
//        }
//        for(int i=0;i<words2.length();i++){
//            if(flags[words2.charAt(i)-'a']!=0) return 0;
//        }
//
//        return words1.length()*words2.length();
//    }

    public int maxProduct(String[] words) {
        int max=0;
        int[] bytes=new int[words.length];

        for(int i=0;i<words.length;i++){
            int val=0;
            for(int j=0;j<words[i].length();j++){
                val|=1<<(words[i].charAt(j)-'a');
                System.out.println("val:"+val);
            }
            bytes[i]=val;
        }

        for(int i=0;i<bytes.length;i++){
            for(int j=i+1;j<bytes.length;j++){
                if((bytes[i] & bytes[j])==0) max=Math.max(max,words[i].length()*words[j].length());
            }
        }
        return max;
    }

    public static void main(String[] args){
        Maximum_Product_of_Word_Lengths_318 s=new Maximum_Product_of_Word_Lengths_318();
        String[] words={"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(s.maxProduct(words));

    }

}
