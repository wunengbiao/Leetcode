package Backtracking;

/**
 * Created by wunengbiao on 2017/6/16.
 */
public class Sudoku_Solver_37 {
    public void solveSudoku(char[][] board) {

        boolean[][] rows=new boolean[9][9];
        boolean[][] cols=new boolean[9][9];
        boolean[][] blocks=new boolean[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int index=board[i][j]-'0'-1;
                rows[i][index]=true;
                cols[j][index]=true;
                int block=(i%3)*3+j%3;
                blocks[block][index]=true;
            }
        }
        helper(board,rows,cols,blocks);

    }

    public boolean helper(char[][] board,boolean[][] rows,boolean[][] cols,boolean[][] blocks){

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    int k=(i%3)*3+j%3;

                    for(int c=0;c<9;c++){
                        if(!rows[i][c-1] && !cols[j][c-1] && !blocks[k][c-1]){
                            board[i][j]=(char)('0'+c+1);
                            rows[i][c]=cols[j][c]=blocks[k][c]=true;
                            if(helper(board,rows,cols,blocks)){
                                return true;
                            }
                            rows[i][c]=cols[j][c]=blocks[k][c]=false;
                            board[i][j]='.';
                        }
                    }

                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args){
        System.out.println('9'=='.');
    }
}
