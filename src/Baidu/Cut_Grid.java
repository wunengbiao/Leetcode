package Baidu;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/11.
 */
public class Cut_Grid {

//    public int getArea(int x1,int y1,int x2,int y2){
//        int leght=Math.abs(x1-x2);
//        int height=Math.abs(y1-y2);
//
//        int min=Math.max(height,leght);
//        return min*min;
//    }

    public static int getNumOfSquare(int plot[][],int n){
        int sum = 0;
        int i,j;
        int xMin=Integer.MAX_VALUE,yMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE, yMax = Integer.MIN_VALUE;
        for(i = 0 ; i < n; i++){
            if (plot[i][0] < xMin) {
                xMin = plot[i][0];
            }
            if(plot[i][0] > xMax){
                xMax = plot[i][0];
            }
            if (plot[i][1] < yMin) {
                yMin = plot[i][1];
            }
            if(plot[i][1] > yMax){
                yMax = plot[i][1];
            }
        }
        int tmp = (yMax - yMin) > (xMax - xMin) ? yMax - yMin : xMax - xMin;
        return sum = tmp * tmp;

    }


//    public int getMinArea(int[][] array){
//        int min=Integer.MAX_VALUE;
//        for(int i=0;i<array.length;i++){
//            for(int j=0;j<array.length;j++){
//                if(i==j) continue;
//                else min=Math.min(min,getArea(array[i][0],array[i][1],array[j][0],array[j][1]));
//            }
//        }
//        return min;
//    }

    public static void main(String[] args){
        Cut_Grid cut_grid=new Cut_Grid();
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=in.nextInt();
            arr[i][1]=in.nextInt();
        }
        System.out.println(cut_grid.getNumOfSquare(arr,n));
    }
}
