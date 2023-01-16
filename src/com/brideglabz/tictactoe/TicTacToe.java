package com.brideglabz.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    char gameBoard[] = null;
    char playerLetter = '\0';
    char computerLetter = '\0';
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the Tic Tac Toe Game Program in Java!");
        TicTacToe gameObj = new TicTacToe();
        gameObj.initialiseGame();
        gameObj.choosePlayerLetter();
        gameObj.showBoard();
        gameObj.playerPlays();
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
            //playerPlays();
        }
        else if (gameBoard[playerCell] != ' ') {
            System.out.println("\nThe cell you selected is not empty.\nPlease try again!");
            playerPlays();
        }
        else
            gameBoard[playerCell] = playerLetter;
    }


}
/*Ability for user to make
a move to a desired
location in the board
- Select the index from 1 to 9 to make
the move.*/