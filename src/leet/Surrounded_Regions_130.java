package leet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wunengbiao on 2017/7/4.
 */
public class Surrounded_Regions_130 {
    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0) return;

        int m=board.length;
        int n=board[0].length;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            if(board[i][0]=='O') queue.offer(new int[]{i,0});
            if(board[i][n-1]=='O') queue.offer(new int[]{i,n-1});
        }

        for(int j=0;j<n;j++){
            if(board[0][j]=='O')
                queue.offer(new int[]{0,j});
            if(board[m-1][j]=='O')
                queue.offer(new int[]{m-1,j});
        }

        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};

        while(!queue.isEmpty()){
            int[] ele=queue.poll();
            board[ele[0]][ele[1]]='*';
            for(int i=0;i<4;i++){
                int x=ele[0]+dx[i];
                int y=ele[1]+dy[i];
                if(1<=x&&x<m-1&&1<=y && y<n-1 && board[x][y]=='O'){
                    queue.offer(new int[]{x,y});
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                if(board[i][j]=='*')
                    board[i][j]='O';
            }
        }
    }

    public static void main(String[] args){
//        char[][] board={
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O','X'},
//                {'X', 'X' ,'O' ,'X'},
//                {'X', 'O', 'X', 'X'}
//        };

        char[][] board={
                {'X','X','X','X','X'},
                {'X','O','O','O','X'},
                {'X','X','O','O','X'},
                {'X','X','X','O','X'},
                {'X','O','X','X','X'}
        };

        Surrounded_Regions_130 s=new Surrounded_Regions_130();
        s.solve(board);
        for(int i=0;i<board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }


}
