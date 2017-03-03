package leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wunengbiao on 2017/2/15.
 */
public class Solution446 {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        Map<Integer, Integer>[] map = new Map[A.length];

        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>(i);

            for (int j = 0; j < i; j++) {
                long diff = (long)A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;

                int d = (int)diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                res += c2;
                map[i].put(d, c1 + c2 + 1);
            }
        }

        return res;
    }

    public static void main(String[] args){
        Solution446 s=new Solution446();
        int[] test={2,4,6,8,10,14};
        System.out.println(s.numberOfArithmeticSlices(test));
    }
}
