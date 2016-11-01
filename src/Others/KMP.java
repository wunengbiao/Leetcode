package Others;

/**
 * Created by wunengbiao on 2016/10/21.
 */
public class KMP {

    public int[] next(String pattern){
        int[] pnext=new int[pattern.length()];
        for(int i=0;i<pattern.length();i++){
            pnext[i]=-1;
        }
        int i=0,k=-1,n=pattern.length();
        while(i<n-1){
            if(k==-1 || pattern.charAt(k)==pattern.charAt(i)){
                i++;k++;
                if(pattern.charAt(i)==pattern.charAt(k)){
                    pnext[i]=pnext[k];
                }else{
                    pnext[i]=k;
                }
            }else{
                k=pnext[k];
            }
        }

        return pnext;
    }
}
