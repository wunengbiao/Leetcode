package NetEase;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/13.
 */
public class Go_to_Company {
    public int solve(int[][] stations,int[] destination,int walktime,int taxitime){
        int time=Integer.MAX_VALUE;
        for(int i=0;i<stations.length;i++){
            int length_of_walk=Math.abs(0-stations[i][0])+Math.abs(0-stations[i][1]);
            int lenght_of_taxi=Math.abs(stations[i][0]-destination[0])+Math.abs(stations[i][1]-destination[1]);
            time=Math.min(time,lenght_of_taxi*taxitime+length_of_walk*walktime);
        }
        int length_of_walk=Math.abs(0-destination[0])+Math.abs(0-destination[1]);
        time=Math.min(time,length_of_walk*walktime);
        return time;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Go_to_Company s=new Go_to_Company();
        int[][] stations;
        int[] destination;
        int walktime;
        int taxitime;

        while(in.hasNext()){
            int num_of_stations=in.nextInt();
            stations=new int[num_of_stations][2];

            for(int i=0;i<num_of_stations;i++){
                stations[i][0]=in.nextInt();
            }
            for(int i=0;i<num_of_stations;i++){
                stations[i][1]=in.nextInt();
            }


            destination=new int[2];

            destination[0]=in.nextInt();
            destination[1]=in.nextInt();


            walktime=in.nextInt();
            taxitime=in.nextInt();

            System.out.println(s.solve(stations,destination,walktime,taxitime));
        }
    }
}
