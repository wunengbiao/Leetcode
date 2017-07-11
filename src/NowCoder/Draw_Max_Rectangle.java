package NowCoder;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/6/5.
 */
public class Draw_Max_Rectangle {
    public int solve(int[][] points){
        int minX=Integer.MAX_VALUE;
        int minY=Integer.MAX_VALUE;
        int maxX=Integer.MIN_VALUE;
        int maxY=Integer.MIN_VALUE;

        for(int i=0;i<points.length;i++){
            minX=Math.min(minX,points[i][0]);
            maxX=Math.max(maxX,points[i][0]);
            minY=Math.min(minY,points[i][1]);
            maxY=Math.max(maxY,points[i][1]);
        }

        return (maxX-minX)*(maxY-minY);
    }

    public static void main(String[] args){
        Draw_Max_Rectangle s=new Draw_Max_Rectangle();
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[][] points=new int[n][2];
        for(int i=0;i<n;i++){
            String[] strs=in.nextLine().split(" ");
            points[i][0]=Integer.parseInt(strs[0]);
            points[i][1]=Integer.parseInt(strs[1]);
        }
        System.out.println(s.solve(points));
    }
}
