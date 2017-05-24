package DP;

/**
 * Created by wunengbiao on 2017/3/2.
 */
public class Dungeon_Game_174 {
    public int calculateMinimumHP(int[][] dungeon) {

        int n=dungeon.length;
        int m=dungeon[0].length;
//        if(n==1 && m==1) return dungeon[0][0]>0?1:1-dungeon[0][0];
        int[][] dp=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]=dungeon[i][j]>=0?0:1-dungeon[i][j];
                    if(dungeon[0][0]<=0) dungeon[i][j]=1;
                }

                else if(i==0){
                    if(dungeon[i][j]+dungeon[i][j-1]>=0){
                        dp[i][j]=dp[i][j-1];
                        dungeon[i][j]=dungeon[i][j]+dungeon[i][j-1];
                    }else{
                        dp[i][j]=dp[i][j-1]+(1-dungeon[i][j]-dungeon[i][j-1]);
                        dungeon[i][j]=1;
                    }
                }
                else if(j==0){
                    if(dungeon[i][j]+dungeon[i-1][j]>=0){
                        dp[i][j]=dp[i-1][j];
                        dungeon[i][j]=dungeon[i][j]+dungeon[i-1][j];
                    }else{
                        dp[i][j]=dp[i-1][j]+(1-dungeon[i][j]-dungeon[i-1][j]);
                        dungeon[i][j]=1;
                    }
                }
                else{
                    int up=dp[i-1][j]+((dungeon[i-1][j]+dungeon[i][j])>=0?0:(1-dungeon[i-1][j]-dungeon[i][j]));
                    int left=dp[i][j-1]+((dungeon[i][j-1]+dungeon[i][j])>=0?0:(1-dungeon[i][j-1]-dungeon[i][j]));

                    if(up<left){
                        dp[i][j]=up;
                        if(dungeon[i][j]+dungeon[i-1][j]>=0)
                            dungeon[i][j]=dungeon[i][j]+dungeon[i-1][j];
                        else
                            dungeon[i][j]=1;
                    }else if(up>left){
                        dp[i][j]=left;
                        if(dungeon[i][j]+dungeon[i][j-1]>=0)
                            dungeon[i][j]=dungeon[i][j]+dungeon[i][j-1];
                        else
                            dungeon[i][j]=1;
                    }else{
                        if(dungeon[i][j-1]>=dungeon[i-1][j]){
                            dp[i][j]=left;
                            if(dungeon[i][j]+dungeon[i][j-1]>=0)
                                dungeon[i][j]=dungeon[i][j]+dungeon[i][j-1];
                            else
                                dungeon[i][j]=1;
                        }else{
                            dp[i][j]=up;
                            if(dungeon[i][j]+dungeon[i-1][j]>=0)
                                dungeon[i][j]=dungeon[i][j]+dungeon[i-1][j];
                            else
                                dungeon[i][j]=1;
                        }
                    }
                }
            }
        }

        return dp[n-1][m-1]==0?1:dp[n-1][m-1];
    }

    public static void main(String[] args){
        Dungeon_Game_174 s=new Dungeon_Game_174();
//        int[][] dungeon={
//                {-2,-3,3},
//                {-5,-10,1},
//                {10,30,-5}
//        };
//        int[][] dungeon={
//                {-100}
//        };

//        int[][] dungeon={{3,-20,30},{-3,4,0}};
        int[][] dungeon={{1,-3,3},{0,-2,0},{-3,-3,-3}};

        System.out.println(s.calculateMinimumHP(dungeon));
    }
}
