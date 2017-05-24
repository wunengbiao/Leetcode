package Queue;

import java.util.TreeSet;

/**
 * Created by wunengbiao on 2017/4/1.
 */
public class Max_Sum_of_Rectangle_No_Larger_Than_K {
    public int maxSumSubmatrix(int[][] matrix, int k){
        int cols=matrix[0].length;
        int rows=matrix.length;

        int result=Integer.MIN_VALUE;
        for(int leftCol=0;leftCol<cols;leftCol++){
            int[] tmp=new int[rows];
            for(int rightCol=leftCol;rightCol<cols;rightCol++){
                for(int i=0;i<rows;i++){
                    tmp[i]+=matrix[i][rightCol];
                }
                result=Math.max(result,kadane(tmp,k));
            }
        }

        return result;
    }

    public int kadane(int[] a,int k){
        int resutl=Integer.MIN_VALUE;
        int sum=0;
        TreeSet<Integer> set=new TreeSet();
        set.add(0);
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            Integer ceiling=set.ceiling(sum-k);
            if(ceiling!=null){
                resutl=Math.max(resutl,sum-ceiling);
            }
            set.add(sum);
        }
        return resutl;
    }

   public static void main(String[] args){
       Max_Sum_of_Rectangle_No_Larger_Than_K s=new Max_Sum_of_Rectangle_No_Larger_Than_K();
       int[][] matrix=
               {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};

       System.out.println(s.maxSumSubmatrix(matrix,8));
   }
}
