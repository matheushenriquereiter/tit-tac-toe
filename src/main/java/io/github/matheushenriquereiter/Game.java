package io.github.matheushenriquereiter;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public Square[][] squares = new Square[3][3];
    public static Turn turn = Turn.FIRST_TEAM;

    public Game() {
        createSquares();

        setResizable(false);
        setLayout(new GridLayout(3, 3));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    public void createSquares() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Square square = new Square();

                square.addActionListener(_ -> {
                    boolean isMarked = square.mark(turn);

                    if (gameEnded()) {
                        JOptionPane.showMessageDialog(this, "Jogo acabou: " + turn);
                    }

                    if (isMarked) {
                        changeTurn();
                    }
                });

                squares[i][j] = square;
                add(square);
            }
        }
    }

    public static void changeTurn() {
        turn = turn == Turn.FIRST_TEAM ? Turn.SECOND_TEAM : Turn.FIRST_TEAM;
    }

    public boolean gameEnded() {
        Square middleSquare = squares[1][1];

        for (int i = 0; i < 3; i++) {
            if ((squares[0][i].marking == turn) && (middleSquare.marking == turn) && (squares[2][2 - i].marking == turn)) {
                return true;
            }
        }

        if ((squares[0][0].marking == turn) && (squares[0][1].marking == turn) && (squares[0][2].marking == turn)) {
            return true;
        }

        if ((squares[1][0].marking == turn) && (squares[1][1].marking == turn) && (squares[1][2].marking == turn)) {
            return true;
        }

        if ((squares[2][0].marking == turn) && (squares[2][1].marking == turn) && (squares[2][2].marking == turn)) {
            return true;
        }

        if ((squares[0][0].marking == turn) && (squares[1][0].marking == turn) && (squares[2][0].marking == turn)) {
            return true;
        }

        if ((squares[0][2].marking == turn) && (squares[1][2].marking == turn) && (squares[2][2].marking == turn)) {
            return true;
        }

        return false;
    }
}
