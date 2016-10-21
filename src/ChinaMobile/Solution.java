package ChinaMobile;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
   public int[][] mySort(int[][] matrix){
       int row=matrix.length;
       int col=matrix[0].length;
       int[] result=new int[row*col];
       for(int i=0;i<row;i++){
           for(int j=0;j<col;j++){
               result[i*col+j]=matrix[i][j];
           }
       }

       Arrays.sort(result);
       for(int i=0;i<row;i++){

           if(i%2==0)
           for(int j=0;j<col;j++){
               matrix[i][j]=result[i*col+j];
           }
           if(i%2==1)
               for(int j=0;j<col;j++){
                   matrix[i][j]=result[i*col+col-j-1];
               }
       }
       return matrix;
   }

   public static void main(String[] args){
       int a[][]={{3,2,1,5,7,8},{1,4,5,6,8,9},{3,7,5,5,8,0}};
       Solution s=new Solution();
       int[][] result=s.mySort(a);
//
       int row=a.length;
       int col=a[0].length;

       for(int i=0;i<row;i++){
           for(int j=0;j<col;j++){
               System.out.print(result[i][j]);
               System.out.print(" ");
           }
           System.out.println();
       }
   }
}
