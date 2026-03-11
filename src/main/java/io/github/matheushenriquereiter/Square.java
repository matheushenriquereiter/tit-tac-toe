package io.github.matheushenriquereiter;

import javax.swing.*;
import java.awt.*;

public class Square extends JButton {
    public Turn marking = null;

    public Square() {
        setBackground(Color.GRAY);
        setSize(60, 60);
    }

    public boolean isMarked() {
        return marking != null;
    }

    public boolean mark(Turn turn) {
        if (isMarked()) {
            return false;
        }

        if (turn == Turn.FIRST_TEAM) {
            Image scaledImage = new ImageIcon("src/main/resources/game-icons/first-team.png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            marking = turn;
            setIcon(new ImageIcon(scaledImage));
        }

        if (turn == Turn.SECOND_TEAM) {
            Image scaledImage = new ImageIcon("src/main/resources/game-icons/second-team.png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            marking = turn;
            setIcon(new ImageIcon(scaledImage));
        }

        return true;
    }
}
