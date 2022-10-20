package org.academiadecodigo.notorbios.pedrov.mondrian.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ToolsBar {

    private JPanel panelTools;
    private JLabel txtProject;
    private JLabel txtBorders;
    private JButton btnOpen;
    private JButton btnSave;
    private JButton btnClearGrid;
    private JButton btnShowHideCursor;
    private JButton btnPaintAllBorders;
    private JButton btnUnpaintAllBorders;
    private JButton btnHelpInfo;

    public ToolsBar() {
        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    GUIEvents.btnOpen();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    GUIEvents.btnSave();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnClearGrid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GUIEvents.btnClearGrid();
            }
        });

        btnShowHideCursor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GUIEvents.btnShowHideCursor();
            }
        });

        btnPaintAllBorders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GUIEvents.btnPaintAllBorders();
            }
        });

        btnUnpaintAllBorders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GUIEvents.btnUnpaintAllBorders();
            }
        });

        btnHelpInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GUIEvents.btnHelpInfo();
            }
        });

        // Window
        JFrame window = new JFrame("Tools");

        GUI.formatWindow(window, window.getTitle(), false);

        window.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        window.setContentPane(panelTools);

        window.pack();

        window.setVisible(true);

        window.setLocation(0, (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - window.getHeight()) / 2));
    }

}