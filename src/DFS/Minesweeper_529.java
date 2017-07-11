package DFS;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/6/7.
 */
public class Minesweeper_529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }else{
            dfs(click[0],click[1],board);
            return board;
        }

    }

    public void dfs(int x,int y,char[][] board){
        if(board[x][y]=='E' && getMinesAround(x,y,board)!=0){
            board[x][y]=(char) (getMinesAround(x,y,board)+'0');
            return;
        }

        if(board[x][y]=='E' && getMinesAround(x,y,board)==0){
            board[x][y]='B';

            for(int i= Math.max(0,x-1);i<=Math.min(board.length-1,x+1);i++){
                for(int j=Math.max(0,y-1);j<=Math.min(board[0].length-1,y+1);j++){
                    if(i==x && j==y) continue;
                    dfs(i,j,board);
                }
            }
        }
    }

    public int getMinesAround(int x,int y,char[][] board){
        int count=0;
        for(int i=Math.max(x-1,0);i<=Math.min(board.length-1,x+1);i++){
            for(int j=Math.max(y-1,0);j<=Math.min(board[0].length-1,y+1);j++){
                if(board[i][j]=='M') count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        char[][] board={{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click={3,0};
        Minesweeper_529 s=new Minesweeper_529();
        s.updateBoard(board,click);

        for(int i=0;i<board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
