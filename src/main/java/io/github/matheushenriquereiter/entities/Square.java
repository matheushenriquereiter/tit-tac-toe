package io.github.matheushenriquereiter.entities;

import io.github.matheushenriquereiter.enums.Turn;

import javax.swing.*;
import java.awt.*;

public class Square extends JButton {
    public Turn mark = null;

    public Square() {
        setSize(60, 60);
    }

    public boolean isMarked() {
        return mark != null;
    }

    public void placeMark(Turn turn) {
        if (isMarked()) {
            return;
        }

        if (turn == Turn.FIRST_TEAM) {
            drawMark("src/main/resources/game-icons/first-team.png", turn);
        }

        if (turn == Turn.SECOND_TEAM) {
            drawMark("src/main/resources/game-icons/second-team.png", turn);
        }
    }

    public void removeMark() {
        mark = null;
        setIcon(null);
    }

    private void drawMark(String filename, Turn turn) {
        Image scaledImage = new ImageIcon(filename).getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(scaledImage));

        mark = turn;
    }
}
