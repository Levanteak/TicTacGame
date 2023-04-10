package org.example;

import java.util.Scanner;

public class Main{
    static Scanner scanner = new Scanner(System.in);
    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';
    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        while (true) {
            System.out.println("Player " + currentPlayer + ", make your move (row[1-3] column[1-3]):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();
                if (isGameOver(row, col)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (isBoardFull()) {
                    System.out.println("It's a tie!");
                    break;
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        if (board[row][col] != '-') {
            return false;
        }
        return true;
    }
    static boolean isGameOver(int row, int col) {
        // check row
        if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
            return true;
        }
        // check column
        if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
            return true;
        }
        // check diagonal
        if (row == col && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (row + col == 2 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
