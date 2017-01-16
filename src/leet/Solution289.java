package leet;

/**
 * Created by wunengbiao on 2017/1/5.
 */
public class Solution289 {
    public void gameOfLife(int[][] board) {
        if(board==null && board.length==0) return;
        int m=board.length,n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int lives=getNeighbourCount(board,m,n,i,j);
                if(board[i][j]==1 && lives>=2 && lives<=3)
                    board[i][j]=3;
                if(board[i][j]==0 && lives==3)
                    board[i][j]=2;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]>>=1;
            }
        }
    }



    public int getNeighbourCount(int[][] board,int m,int n,int i,int j){
        int live=0;

        for(int x=Math.max(0,i-1);x<=Math.min(m-1,i+1);x++){
            for(int y=Math.max(0,j-1);y<=Math.min(n-1,j+1);y++){
                live+=board[x][y]&1;
            }
        }

        live-=board[i][j]&1;
        return live;
    }

    public static void main(String[] args){

    }
}
