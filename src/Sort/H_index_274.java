package Sort;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/3/26.
 */
public class H_index_274 {
    public int hIndex(int[] citations) {
        if(citations.length==0) return 0;
        Arrays.sort(citations);
        int res=0;
        for(int i=citations.length-1;i>=0;i--){
            res=Math.max(res,Math.min(citations[i],citations.length-i));
        }

        return res;
    }

    public static void main(String[] args){
        H_index_274 solution=new H_index_274();
        int[] citations={100};
        System.out.println(solution.hIndex(citations));
    }
}
