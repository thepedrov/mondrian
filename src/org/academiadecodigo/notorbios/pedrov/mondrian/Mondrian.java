package org.academiadecodigo.notorbios.pedrov.mondrian;

import org.academiadecodigo.notorbios.pedrov.mondrian.cursor.Cursor;
import org.academiadecodigo.notorbios.pedrov.mondrian.grid.Border;
import org.academiadecodigo.notorbios.pedrov.mondrian.grid.Grid;
import org.academiadecodigo.notorbios.pedrov.mondrian.gui.GUI;
import org.academiadecodigo.notorbios.pedrov.mondrian.gui.ToolsBar;
import org.academiadecodigo.notorbios.pedrov.mondrian.settings.KeyboardSettings;
import org.academiadecodigo.notorbios.pedrov.mondrian.settings.Settings;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Mondrian implements KeyboardHandler {

    public static Grid grid;
    public static Cursor cursor;
    private int KeyPressed;

    public Mondrian() {
        if (Settings.questionSettings) GUI.questionSettings();

        grid = new Grid();
        cursor = new Cursor();

        ToolsBar toolsBar = new ToolsBar();

        GUI.fixWindow();

        KeyPressed = -1;
        KeyboardSettings.startKeyboard(this);
    }

    private void drawOnCell() {
        switch (KeyPressed) {
            case 65: // A
                grid.hideShowBorder(cursor.getX(), cursor.getY(), Border.LEFT, true);
                break;
            case 87: // W
                grid.hideShowBorder(cursor.getX(), cursor.getY(), Border.TOP, true);
                break;
            case 68: // D
                grid.hideShowBorder(cursor.getX(), cursor.getY(), Border.RIGHT, true);
                break;
            case 83: // S
                grid.hideShowBorder(cursor.getX(), cursor.getY(), Border.BOTTOM, true);
                break;
            default:
                grid.paintCellByCoordinates(cursor.getX(), cursor.getY(), KeyboardSettings.keyPaintColor.get(KeyPressed));
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            // GO LEFT
            case KeyboardEvent.KEY_LEFT:
                if (cursor.getX() != Settings.paddingLef) {
                    cursor.move(-Settings.cellSize, 0);

                    if (KeyPressed != -1) drawOnCell();
                }

                break;
            // GO UP
            case KeyboardEvent.KEY_UP:
                if (cursor.getY() != Settings.paddingTop) {
                    cursor.move(0, -Settings.cellSize);

                    if (KeyPressed != -1) drawOnCell();
                }

                break;
            // GO RIGHT
            case KeyboardEvent.KEY_RIGHT:
                if (cursor.getX() != Settings.paddingLef + (Settings.cellSize * (Settings.numColumns - 1))) {
                    cursor.move(Settings.cellSize, 0);

                    if (KeyPressed != -1) drawOnCell();
                }

                break;
            // GO DOWN
            case KeyboardEvent.KEY_DOWN:
                if (cursor.getY() != Settings.paddingTop + (Settings.cellSize * (Settings.numRows - 1))) {
                    cursor.move(0, Settings.cellSize);

                    if (KeyPressed != -1) drawOnCell();
                }

                break;
            // HIDE/SHOW LEFT/TOP/RIGHT/BOTTOM BORDER AND OTHERS KEYS (VAR:keyPaintColor in CLASS:KeyboardSettings)
            default:
                if (KeyPressed == -1) {
                    KeyPressed = keyboardEvent.getKey();
                    drawOnCell();
                }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyPressed) {
            KeyPressed = -1;
        }
    }

}