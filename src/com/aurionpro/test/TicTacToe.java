package com.aurionpro.test;

import java.util.Scanner;

public class TicTacToe {
	    private char[][] board;
	    private char currentPlayer;

	    public TicTacToe() {
	        board = new char[3][3];
	        currentPlayer = 'X';
	        initializeBoard();
	    }

	    public void initializeBoard() {
	        for (int row = 0; row < 3; row++) {
	            for (int col = 0; col < 3; col++) {
	                board[row][col] = '-';
	            }
	        }
	    }

	    public void printBoard() {
	        System.out.println("-------------");
	        for (int row = 0; row < 3; row++) {
	            System.out.print("| ");
	            for (int col = 0; col < 3; col++) {
	                System.out.print(board[row][col] + " | ");
	            }
	            System.out.println();
	            System.out.println("-------------");
	        }
	    }

	    public void playGame() {
	        Scanner scanner = new Scanner(System.in);
	        boolean gameFinished = false;

	        System.out.println("Let's play Tic-Tac-Toe!");

	        while (!gameFinished) {
	            System.out.println("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]): ");
	            int row = scanner.nextInt() - 1;
	            int col = scanner.nextInt() - 1;

	            if (isValidMove(row, col)) {
	                board[row][col] = currentPlayer;
	                printBoard();

	                if (isWinningMove(row, col)) {
	                    System.out.println("Player " + currentPlayer + " wins!");
	                    gameFinished = true;
	                } else if (isBoardFull()) {
	                    System.out.println("It's a draw!");
	                    gameFinished = true;
	                } else {
	                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	                }
	            } else {
	                System.out.println("Invalid move. Try again.");
	            }
	        }

	        scanner.close();
	    }

	    public boolean isValidMove(int row, int col) {
	        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
	    }

	    public boolean isWinningMove(int row, int col) {
	        // Check row
	        if (board[row][0] == board[row][1] && board[row][0] == board[row][2]) {
	            return true;
	        }
	        // Check column
	        if (board[0][col] == board[1][col] && board[0][col] == board[2][col]) {
	            return true;
	        }
	        // Check diagonal
	        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2]) ||
	                (board[0][2] == board[1][1] && board[0][2] == board[2][0])) {
	            return true;
	        }
	        return false;
	    }

	    public boolean isBoardFull() {
	        for (int row = 0; row < 3; row++) {
	            for (int col = 0; col < 3; col++) {
	                if (board[row][col] == '-') {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    public static void main(String[] args) {
	        TicTacToe game = new TicTacToe();
	        game.playGame();
	    }
	}


