package QiHu;

/**
 * Created by wunengbiao on 2017/3/21.
 */
public class Money_Combine {
//    public int recursive(int n,int curSum,int level,int[] array){
//        int units=array.length;
//
//        int cnt=0;
//        if(level<units){
//            if(curSum==n){
//                cnt+=1;
//            }
//            else{
//                for(int i=0;i*array[level]<=n-curSum;++i){
//                    cnt+=recursive(n,curSum+i*array[level],level+1,array);
//                }
//            }
//        }
//        return cnt;
//    }

    int numOfCoints(int value,int[] arr){
        int n=arr.length;
        int[][] dp=new int[n][value+1];
        for(int i=0;i<=value;i++){
            dp[0][i]=1;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=value;++j){
                if(j>=arr[i])
                    dp[i][j]=dp[i][j-arr[i]]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n-1][value];
    }
    public static void main(String[] args){
//        int[] arr={1,2,5};
        int[] arr={2};
        Money_Combine solution=new Money_Combine();
        System.out.println(solution.numOfCoints(3,arr));
//        System.out.println(solution.recursive(1000,0,0,arr));
    }
}
