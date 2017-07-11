package Backtracking;

/**
 * Created by wunengbiao on 2017/6/18.
 */
public class N_Queens_II_52 {
    public int totalNQueens(int n) {
        helper(n,1,new int[n+1]);
        return count;
    }

    int count=0;
    public void helper(int n,int i,int[] res){
        if(i>n){
            count+=1;
            return;
        }

        for(int c=1;c<=n;c++){
            if(place(res,i,c)){
                res[i]=c;
                helper(n,i+1,res);
            }
        }
    }

    public boolean place(int[] res,int n,int pos){
        for(int i=1;i<n;i++){
            if(pos==res[i] || Math.abs(pos-res[i])==Math.abs(n-i)) return false;
        }
        return true;
    }

    public static void main(String[] args){
        N_Queens_II_52 s=new N_Queens_II_52();
        System.out.println(s.totalNQueens(8));
    }

}
