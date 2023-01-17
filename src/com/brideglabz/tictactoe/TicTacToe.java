package com.brideglabz.tictactoe;
import java.util.Scanner;
public class TicTacToe {
    char gameBoard[] = null;
    char playerLetter = '\0';
    char computerLetter = '\0';
    String winner = null;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the Tic Tac Toe Game Program in Java!");
        TicTacToe gameObj = new TicTacToe();
        gameObj.initialiseGame();
        if (gameObj.toss() == 1)
            System.out.println("\nPlayer won the toss.\nPlayer plays first.");
        else
            System.out.println("\nComputer won the toss.\nComputer plays first.");
        gameObj.choosePlayerLetter();
        gameObj.showBoard();
        gameObj.playerPlays();
        gameObj.showBoard();
    }
    void initialiseGame(){
        gameBoard = new char[10];
        for(int index = 0; index < 10; index++)
            gameBoard[index] = ' ';
    }
    void choosePlayerLetter() {
        System.out.println("\nPlayer please choose your play Letter.");
        System.out.println("Enter 'X' to play 'X' on your turn.");
        System.out.println("Or Enter 'O' to play 'O' on your turn.");
        char playerInput = sc.next().charAt(0);
        sc.close();
        if (playerInput == 'X' || playerInput == 'x') {
            playerLetter = 'X';
            computerLetter = 'O';
        }
        else if (playerInput == 'O' || playerInput == 'o') {
            playerLetter = 'O';
            computerLetter = 'o';
        }
        else
            System.out.println("\nInvalid Input.\nPlease try again!");
    }
    void showBoard() {
        System.out.println("\nCurrent Board : ");
        System.out.println("-------------");
        System.out.println("| "+gameBoard[1]+" | "+gameBoard[2]+" | "+gameBoard[3]+" |");
        System.out.println("-------------");
        System.out.println("| "+gameBoard[4]+" | "+gameBoard[5]+" | "+gameBoard[6]+" |");
        System.out.println("-------------");
        System.out.println("| "+gameBoard[7]+" | "+gameBoard[8]+" | "+gameBoard[9]+" |");
        System.out.println("-------------");
    }
    void playerPlays() {
        System.out.print("\nEnter an empty cell number [1-9] where do want make your move : ");
        byte playerCell = sc.nextByte();
        if (playerCell > 9 || playerCell < 1) {
            System.out.println("\nInvalid selection.\nPlease try again!");
            playerPlays();
        }
        else if (gameBoard[playerCell] != ' ') {
            System.out.println("\nThe cell you selected is not empty.\nPlease try again!");
            playerPlays();
        }
        else
            gameBoard[playerCell] = playerLetter;
    }
    int toss() {
        return (Math.random() > 0.5 ? 1 : 0);
    }
    void checkWinOrTie() {
        char winLetter = ' ';
        byte cellsStillEmpty = 0;
         winner = null;

        for(int pattern = 1; pattern < 9; pattern++) {
            switch(pattern) {
                case 1 :
                    if(gameBoard[1] == gameBoard[2] && gameBoard[1] == gameBoard[3])
                        winLetter = gameBoard[1];
                    break;
                case 2 :
                    if(gameBoard[4] == gameBoard[5] && gameBoard[4] == gameBoard[6])
                        winLetter = gameBoard[4];
                    break;
                case 3 :
                    if(gameBoard[7] == gameBoard[8] && gameBoard[7] == gameBoard[9])
                        winLetter = gameBoard[7];
                    break;
                case 4 :
                    if(gameBoard[1] == gameBoard[4] && gameBoard[1] == gameBoard[7])
                        winLetter = gameBoard[1];
                    break;
                case 5 :
                    if(gameBoard[2] == gameBoard[5] && gameBoard[2] == gameBoard[8])
                        winLetter = gameBoard[2];
                    break;
                case 6 :
                    if(gameBoard[3] == gameBoard[6] && gameBoard[3] == gameBoard[9])
                        winLetter = gameBoard[3];
                    break;
                case 7 :
                    if(gameBoard[1] == gameBoard[5] && gameBoard[1] == gameBoard[9])
                        winLetter = gameBoard[1];
                    break;
                case 8 :
                    if(gameBoard[3] == gameBoard[5] && gameBoard[3] == gameBoard[7])
                        winLetter = gameBoard[3];
                    break;
            }
        }
        winner = "me";
        if (winLetter == playerLetter)
            winner = "PLAYER";
        else if(winLetter == computerLetter)
            winner = "COMPUTER";
        else {
            for(int counter = 1; counter <= 9; counter++) {
                if(gameBoard[counter] == ' ')
                    cellsStillEmpty++;
            }
            if (cellsStillEmpty == 0)
                winner = "TIE";
        }
        if (winner != null)
            displayResults();
    }

    void displayResults() {
        if (winner == "TIE")
            System.out.println("\n\nIt's a TIE!\nPlease try again.");
        else
            System.out.println("\n\n"+winner+" wins!");
    }


}
/*As player would expect
the Tic Tac Toe App to
determine after every
move the winner or
the tie or change the turn*/