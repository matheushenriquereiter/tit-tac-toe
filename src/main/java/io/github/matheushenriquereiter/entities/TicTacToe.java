package io.github.matheushenriquereiter.entities;

import io.github.matheushenriquereiter.enums.Turn;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    public Square[][] squares = new Square[3][3];
    public static Turn turn = Turn.FIRST_TEAM;

    public TicTacToe() {
        setResizable(false);
        setLayout(new GridLayout(3, 3));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);
        setBackground(Color.BLACK);

        createSquares();

        setVisible(true);
    }

    public void createSquares() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Square square = new Square();

                square.addActionListener(_ -> attemptMove(square));

                squares[i][j] = square;
                add(square);
            }
        }
    }

    private void attemptMove(Square square) {
        square.placeMark(turn);

        if (isGameOver()) {
            JOptionPane.showMessageDialog(this, "Jogo acabou: " + turn);
            return;
        }

        if (isDraw()) {
            JOptionPane.showMessageDialog(this, "Jogo empatou");
            clearGame();
            return;
        }

        if (square.isMarked()) {
            changeTurn();
        }
    }

    public static void changeTurn() {
        turn = turn == Turn.FIRST_TEAM ? Turn.SECOND_TEAM : Turn.FIRST_TEAM;
    }

    public boolean isGameOver() {
        Square middleSquare = squares[1][1];

        for (int i = 0; i < 3; i++) {
            if ((squares[0][i].mark == turn) && (middleSquare.mark == turn) && (squares[2][2 - i].mark == turn)) {
                return true;
            }

            if ((squares[i][0].mark == turn) && (squares[i][1].mark == turn) && (squares[i][2].mark == turn)) {
                return true;
            }
        }

        if ((squares[0][0].mark == turn) && (squares[1][0].mark == turn) && (squares[2][0].mark == turn)) {
            return true;
        }

        if ((squares[0][2].mark == turn) && (squares[1][2].mark == turn) && (squares[2][2].mark == turn)) {
            return true;
        }

        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Square square = squares[i][j];

                if (!square.isMarked()) {
                    return false;
                }
            }
        }

        return true;
    }

    public void clearGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Square square = squares[i][j];

                square.removeMark();
            }
        }
    }
}
