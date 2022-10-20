package org.academiadecodigo.notorbios.pedrov.mondrian.cursor;

import org.academiadecodigo.notorbios.pedrov.mondrian.settings.Settings;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Cursor {

    private Picture cursor;
    private boolean isHidden;

    public Cursor() {
        // Center On Grid
        int x = Settings.paddingLef + Settings.numColumns / 2 * Settings.cellSize;
        int y = Settings.paddingTop + Settings.numRows / 2 * Settings.cellSize;

        cursor = new Picture(x, y, String.format("cursors/cursor_%s.png", Settings.cellSize));
        cursor.draw();

        isHidden = false;
    }

    public void move(int x, int y) {
        cursor.translate(x, y);
    }

    public void hideShow() {
        if(isHidden) cursor.draw(); else cursor.delete();
        isHidden = !isHidden;
    }

    public int getX() {
        return cursor.getX();
    }

    public int getY() {
        return cursor.getY();
    }

}