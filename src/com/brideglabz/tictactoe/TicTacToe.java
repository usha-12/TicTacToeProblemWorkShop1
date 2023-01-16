package com.brideglabz.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    char gameBoard[] = null;
    char playerLetter = '\0';
    char computerLetter = '\0';
    public static void main(String[] args) {
        System.out.println("Welcome to the Tic Tac Toe Game Program in Java!");
        TicTacToe gameObj = new TicTacToe();
        gameObj.initialiseGame();
        gameObj.choosePlayerLetter();
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
        Scanner sc = new Scanner(System.in);
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

}
/*Ability to allow the
player to choose a
letter X or O

- Create a method to allow player to
input X or O and call from main
- Determine Player and Computer

 Letter to play the game*/