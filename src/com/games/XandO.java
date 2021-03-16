package com.games;

public class XandO {
    //players
    public static final int X = 1, O= -1;
    //empty cell
    public static final int EMPTY = 0;
    //game board
    private int board[][] = new int[3][3];
    private int player;

    //constructor
    public XandO(){
        clearBoard();
    }
    //clears the board
    public void clearBoard() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++ ){
                board[i][j] = EMPTY;
            }
        }
        player = X;
    }
    //puts mark on position i, j
    public void putsMark(int i, int j) throws IllegalArgumentException{
        //invalid board position
        if((i > 2) || (i < 0) || (j > 2) || (j < 0)){
            throw new IllegalArgumentException("Invalid board position");
        }
        //board position is occupied
        if (board[i][j] != EMPTY){
            throw new IllegalArgumentException("Board position is occupied");
        }
        board[i][j] = player;
        //switches players
        player = -player;
    }

    //checks win
    public boolean isWin(int mark){
        return ((board[0][0] + board[0][1] + board[0][2] == mark*3)
        || (board[1][0] + board[1][1] + board[1][2] == mark*3)
        || (board[2][0] + board[2][1] + board[2][2] == mark*3)
        || (board[0][0] + board[1][0] + board[2][0] == mark*3)
        || (board[0][1] + board[1][1] + board[2][1] == mark*3)
        || (board[0][2] + board[1][2] + board[2][2] == mark*3)
        || (board[0][0] + board[1][1] + board[2][2] == mark*3)
        || (board[0][2] + board[1][1] + board[2][0] == mark*3));
    }
    public int winner(){
        if(isWin(X))
            return(X);
        else if (isWin(O))
            return(O);
        else
            return 0;

        }


    //returns char showing board

public String toString(){
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++) {
            switch (board[i][j]) {
                case X:
                    sb.append("X");
                    break;
                case O:
                    sb.append("O");
                    break;
                case EMPTY:
                    sb.append(" ");
            }
            if (j < 2)
                sb.append("|");
        }
            if (i < 2)
                sb.append("\n-----\n");
        }
    return sb.toString();
    }
}


