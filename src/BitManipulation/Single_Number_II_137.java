package BitManipulation;

/**
 * Created by wunengbiao on 2017/5/14.
 *
   k = 3: k1 = 1, k2 = 1, mask = ~(x1 & x2);

   k = 5: k1 = 1, k2 = 0, k3 = 1, mask = ~(x1 & ~x2 & x3);

 twos |= (ones & A[i]);
 ones ^= A[i];
 xthrees = ~(ones & twos);
 ones &= xthrees;
 twos &= xthrees;


 for (int i : array) {
 xm ^= (xm-1 & ... & x1 & i);
 xm-1 ^= (xm-2 & ... & x1 & i);
 .....
 x1 ^= i;

 mask = ~(y1 & y2 & ... & ym)  where yj = xj  if kj = 1 and  yj = ~xj  if kj = 0 (j = 1 to m).

 xm &= mask;
 ......
 x1 &= mask;
 }

                next
 a  b   c      a    b
 0  0   0      0    0
 0  0   1      0    1
 0  1   0      0    1
 0  1   1      1    0
 1  0   0      1    0
 1  0   1      0    0


 */
public class Single_Number_II_137 {
//    public int singleNumber(int[] nums) {
//
//        int ones=0;
//        int twos=0;
//
//        for(int i=0;i<nums.length;i++){
//
//        }
//
//    }
}
