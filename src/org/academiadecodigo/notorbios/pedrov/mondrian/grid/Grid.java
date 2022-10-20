package org.academiadecodigo.notorbios.pedrov.mondrian.grid;

import org.academiadecodigo.notorbios.pedrov.mondrian.FileManager;
import org.academiadecodigo.notorbios.pedrov.mondrian.settings.Settings;
import org.academiadecodigo.simplegraphics.graphics.Color;

import javax.swing.*;
import java.io.IOException;

public class Grid {

    private Cell[][] grid;

    public Grid() {
        grid = new Cell[Settings.numColumns][Settings.numRows];

        for (int x = 0; x < Settings.numColumns; x++) {
            for (int y = 0; y < Settings.numRows; y++) {
                grid[x][y] = new Cell(Settings.paddingLef + x * Settings.cellSize, Settings.paddingTop + y * Settings.cellSize);
            }
        }
    }

    public void paintCellByCoordinates(int cursorX, int cursorY, Color color) {
        int[] positions = getPositionsByCoordinates(cursorX, cursorY);

        grid[positions[0]][positions[1]].changeColor(color);
    }

    private int[] getPositionsByCoordinates(int cursorX, int cursorY) {
        for (int x = 0; x < Settings.numColumns; x++) {
            for (int y = 0; y < Settings.numRows; y++) {
                if (grid[x][y].getX() == cursorX && grid[x][y].getY() == cursorY) {
                    return new int[]{x, y};
                }
            }
        }

        return null;
    }

    public void paintAllBorders() {
        for (int x = 0; x < Settings.numColumns; x++) {
            for (int y = 0; y < Settings.numRows; y++) {
                grid[x][y].showBorders();
            }
        }
    }

    public void hideShowBorder(int cursorX, int cursorY, Border border, boolean switchTwainBorder) {
        int[] positions = getPositionsByCoordinates(cursorX, cursorY);
        int x = positions[0];
        int y = positions[1];

        grid[x][y].hideShowBorder(border);

        if (switchTwainBorder) {
            switch (border) {
                case LEFT:
                    if (x != 0) grid[x - 1][y].hideShowBorder(Border.RIGHT);
                    break;
                case TOP:
                    if (y != 0) grid[x][y - 1].hideShowBorder(Border.BOTTOM);
                    break;
                case RIGHT:
                    if (x + 1 != Settings.numColumns) grid[x + 1][y].hideShowBorder(Border.LEFT);
                    break;
                case BOTTOM:
                    if (y + 1 != Settings.numRows) grid[x][y + 1].hideShowBorder(Border.TOP);
                    break;
            }
        }
    }

    public void unpaintAllBorders() {
        for (int x = 0; x < Settings.numColumns; x++) {
            for (int y = 0; y < Settings.numRows; y++) {
                grid[x][y].hideBorders();
            }
        }
    }

    public void clear() {
        for (int x = 0; x < Settings.numColumns; x++) {
            for (int y = 0; y < Settings.numRows; y++) {
                grid[x][y].changeColor(Settings.colorCellBackground);
                grid[x][y].showBorders();
            }
        }
    }

    public void save() throws IOException {
        StringBuilder output = new StringBuilder();

        output.append(Settings.numColumns + ";" + Settings.numRows + "\n");

        for (int x = 0; x < Settings.numColumns; x++) {
            for (int y = 0; y < Settings.numRows; y++) {
                output.append(grid[x][y].toString() + ";");
            }
            output.append(";");
        }

        FileManager.save(output.toString());
    }

    public void load() throws IOException {
        String[] savedContent = FileManager.load().split("\n");

        String[] properties = savedContent[0].split(";");
        if (Integer.parseInt(properties[0]) != Settings.numColumns || Integer.parseInt(properties[1]) != Settings.numRows) {
            JOptionPane.showMessageDialog(null, "This save does not have the same properties (grid)." +
                    " \n\nOpen a new project with the following specifications:" +
                    " \n> Cell size (px x px): Any" +
                    " \n> Number of columns: " + properties[0] +
                    " \n> Number of rows: " + properties[1], "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] gridContent = savedContent[1].split(";;");
        String[] columnContent;
        String[] cell;

        clear();

        for (int x = 0; x < Settings.numColumns; x++) {
            columnContent = gridContent[x].split(";");

            for (int y = 0; y < Settings.numRows; y++) {
                cell = columnContent[y].split(",");

                grid[x][y].changeColor(new Color(Integer.parseInt(cell[0]), Integer.parseInt(cell[1]), Integer.parseInt(cell[2])));

                int cursorX = Settings.paddingLef + x * Settings.cellSize;
                int cursorY = Settings.paddingTop + y * Settings.cellSize;

                if (cell[3].equals("false")) hideShowBorder(cursorX, cursorY, Border.LEFT, false);
                if (cell[4].equals("false")) hideShowBorder(cursorX, cursorY, Border.TOP, false);
                if (cell[5].equals("false")) hideShowBorder(cursorX, cursorY, Border.RIGHT, false);
                if (cell[6].equals("false")) hideShowBorder(cursorX, cursorY, Border.BOTTOM, false);
            }
        }
    }

}