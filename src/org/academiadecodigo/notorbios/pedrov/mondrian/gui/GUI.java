package org.academiadecodigo.notorbios.pedrov.mondrian.gui;

import org.academiadecodigo.notorbios.pedrov.mondrian.settings.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class GUI {

    private static boolean helpWindowIsOpen = false;

    public static void formatWindow(Frame frame, String title, boolean center) {
        // Title
        frame.setTitle(title);

        // Icon
        // https://www.flaticon.com/free-icon/mondrian_853391
        frame.setIconImage(new ImageIcon(Objects.requireNonNull(Settings.class.getResource("/icon.png"))).getImage());

        // Non-Resizable
        frame.setResizable(false);

        // Center Window
        if (center) {
            frame.pack();
            frame.setLocationRelativeTo(null);
        }
    }

    public static void fixWindow() {
        int index = Settings.questionSettings ? 1 : 0;

        formatWindow(Frame.getFrames()[index], "Mondrian", true);

        // No Cursor
        if (Settings.disableSOCursorOnGrid) {
            BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
            Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
            Frame.getFrames()[index].setCursor(blankCursor);
        }

        Frame.getFrames()[index].setVisible(true);

        Frame.getFrames()[index].addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public static void questionSettings() {
        String[] options;
        Object question;

        ImageIcon icon = new ImageIcon(Settings.class.getResource("/icon.png"));

        // Set max width and height
        Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
        Settings.windowMaxWidth = (int) displaySize.getWidth() - 120;
        Settings.windowMaxHeight = (int) displaySize.getHeight() - 120;

        // Cell Size
        options = new String[20];

        for (int i = 0; i < options.length; i++) {
            options[i] = String.valueOf(5 * (i + 1));
        }

        question = JOptionPane.showInputDialog(null, null, "Cell size (px x px)?", JOptionPane.QUESTION_MESSAGE, icon, options, options[4]);

        if (question != null) Settings.cellSize = Integer.parseInt(question.toString());

        // Columns
        Settings.numColumns = Settings.windowMinWidth / Settings.cellSize;

        options = new String[Settings.windowMaxWidth / Settings.cellSize - Settings.numColumns + 1];

        for (int i = 0; i < options.length; i++) {
            options[i] = String.valueOf(Settings.numColumns + i);
        }

        question = JOptionPane.showInputDialog(null, null, "Number of columns?", JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);

        if (question != null) Settings.numColumns = Integer.parseInt(question.toString());

        // Rows
        Settings.numRows = Settings.windowMinHeight / Settings.cellSize;

        options = new String[Settings.windowMaxHeight / Settings.cellSize - Settings.numRows + 1];

        for (int i = 0; i < options.length; i++) {
            options[i] = String.valueOf(Settings.numRows + i);
        }

        question = JOptionPane.showInputDialog(null, null, "Number of rows?", JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);

        if (question != null) Settings.numRows = Integer.parseInt(question.toString());
    }

    public static void helpInformationWindow() {
        if (!helpWindowIsOpen) {
            JFrame window = new JFrame("Help / Info");

            window.setSize(450, 500);

            window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            window.getContentPane().add(new JLabel("<html><body><div style='border: none; width: 350px; text-align: center'><h1>Mondrian</h1><br>Key <b>Left</b>: Go to left<br>Key <b>Up</b>: Go to top<br>Key <b>Right</b>: Go to right<br>Key <b>Down</b>: Go to bottom<br>&nbsp;<br>Key <b>Space</b>: Paint white<br>Key <b>1</b>: Paint black<br>Key <b>2</b>: Paint white gray<br>Key <b>3</b>: Paint blue<br>Key <b>4</b>: Paint red<br>Key <b>5</b>: Paint yellow<br>&nbsp;<br>Key <b>A</b>: Show/Hide left border<br>Key <b>W</b>: Show/Hide top border<br>Key <b>D</b>: Show/Hide right border<br>Key <b>S</b>: Show/Hide bottom border<br>&nbsp;<br><b>* Can hold down the (paint/border) key and walk *</b><br>&nbsp;</div></body></html>"));

            formatWindow(window, window.getTitle(), true);

            window.setVisible(true);

            window.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    helpWindowIsOpen = false;

                    GUIEvents.focusGrid();
                }
            });

            helpWindowIsOpen = true;
        }
    }

}