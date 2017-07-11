package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * Created by wunengbiao on 2017/6/22.
 */
public class Max_Points_on_a_Line_149 {
    static  class Slope{
        int x;
        int y;

        public Slope(int x1,int y1){
            this.x=x1;
            this.y=y1;
        }
        @Override
        public boolean equals(Object obj) {
            return this.x==((Slope) obj).x && this.y==((Slope) obj).y;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }
    public int maxPoints(Point[] points) {
        if(points.length<=2) return points.length;
        int res=0;

        for(int i=0;i<points.length-1;i++){
            int numVertical=1,local=1,duplicate=0;
            Map<Slope,Integer> map=new HashMap<>();
            for(int j=i+1;j<points.length;j++){
                if(points[i].x==points[j].x){
                    if(points[i].y==points[j].y) duplicate++;
                    else numVertical++;
                }else{
                    int[] slopeA={points[j].y-points[i].y,points[j].x-points[i].x};
                    reduction(slopeA);
                    Slope slope=new Slope(slopeA[0],slopeA[1]);

//                    System.out.println(Arrays.toString(slope));
                    int count=map.getOrDefault(slope,0);
                    if(count==0) map.put(slope,2);
                    else map.put(slope,count+1);
                    local= Math.max(local,map.get(slope));
                }
            }
            local=Math.max(local+duplicate,numVertical+duplicate);
            res=Math.max(res,local);
        }
        return res;
    }

    public void reduction(int[] slope){
       if(slope[1]<0){
           slope[1]=-slope[1];
           slope[0]=-slope[0];
       }

        int res=1;
        int a=slope[0];
        int b=slope[1];
        while(b!=0){
            int tmp=b;
            b=a%b;
            a=tmp;
        }
        slope[0]/=a;
        slope[1]/=a;
    }

    public static void main(String[] args){
        //[[0,0],[94911151,94911150],[94911152,94911151]]
        Point[] points={new Point(0,0),new Point(-1,-1),new Point(2,2),new Point(2,4)};
        Max_Points_on_a_Line_149 s=new Max_Points_on_a_Line_149();
        System.out.println(s.maxPoints(points));

        Slope s1=new Slope(1,2);
        Slope s2=new Slope(1,2);
        System.out.println(s1==s2);
    }
}