package NowCoder;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/5/31.
 */
public class Many_Fish {
    public int solve(int minSize,int maxSize,int[] fishes){
        Arrays.sort(fishes);
        int count=0;

        for(int i=0;i<fishes.length;i++){

        }
        return 0;
    }

    public boolean isOk(int[] fishes,int fish){
        int i=0;
        while(fish<=fishes[i] ){
            i++;
        }

        if(i==0){
            int r2=fishes[i]/2;
            if(r2*2==fishes[i]) r2++;
            if(fish>=r2) return true;

            int r10=fishes[i]/10;
            if(r10*10==fishes[i]) r10--;
            if(fish<=r10) return true;
            return false;
        }

        else if(i==fishes.length){

        }

        else{

        }

        return false;
    }
}
