package com.brideglabz.tictactoe;
public class TicTacToe {
    char gameBoard[] = null;
    public static void main(String[] args) {
        System.out.println("Welcome to the Tic Tac Toe Game Program in Java!");
        TicTacToe gameObj = new TicTacToe();
        gameObj.initialiseGame();
    }
    void initialiseGame(){
        gameBoard = new char[10];
        for(int index = 0; index < 10; index++)
            gameBoard[index] = ' ';
    }

}
/*As a Player would like to
start fresh by creating a tic-tac-toe board - Create a TicTacToeGame class - Create method for every use case
and call from main
- Create a board of char[] of size 10
and assign empty space to each
element

-
0th index is ignored to make it
 user-friendly*/