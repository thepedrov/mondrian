package org.academiadecodigo.notorbios.pedrov.mondrian.gui;

import org.academiadecodigo.notorbios.pedrov.mondrian.Mondrian;
import org.academiadecodigo.notorbios.pedrov.mondrian.settings.Settings;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.IOException;

public class GUIEvents {

    public static void btnOpen() throws IOException {
        JFileChooser openFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        if (openFile.showOpenDialog(Frame.getFrames()[Settings.questionSettings ? 1 : 0]) == JFileChooser.APPROVE_OPTION) {
            String path = openFile.getSelectedFile().getAbsolutePath();

            if (path.substring(path.length() - 5).equals(".mdrw")) {
                Settings.pathSaveFile = path;
                Mondrian.grid.load();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid file.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        focusGrid();
    }

    public static void btnSave() throws IOException {
        if (Settings.pathSaveFile.equals("")) {
            JFrame parentFrame = new JFrame();

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save");

            if (fileChooser.showSaveDialog(parentFrame) == JFileChooser.APPROVE_OPTION) {
                String path = fileChooser.getSelectedFile().getAbsolutePath();

                Settings.pathSaveFile = path;

                if (!path.substring(path.length() - 5).equals(".mdrw")) {
                    Settings.pathSaveFile = path + ".mdrw";
                }

                Mondrian.grid.save();
            }
        } else {
            Mondrian.grid.save();
        }

        focusGrid();
    }

    public static void btnClearGrid() {
        Mondrian.grid.clear();

        focusGrid();
    }

    public static void btnShowHideCursor() {
        Mondrian.cursor.hideShow();

        focusGrid();
    }

    public static void btnPaintAllBorders() {
        Mondrian.grid.paintAllBorders();

        focusGrid();
    }

    public static void btnUnpaintAllBorders() {
        Mondrian.grid.unpaintAllBorders();

        focusGrid();
    }

    public static void btnHelpInfo() {
        GUI.helpInformationWindow();
    }

    public static void focusGrid() {
        Frame.getFrames()[Settings.questionSettings ? 1 : 0].toFront();
    }

}