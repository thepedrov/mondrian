package org.academiadecodigo.notorbios.pedrov.mondrian.grid;

import org.academiadecodigo.notorbios.pedrov.mondrian.settings.Settings;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private Rectangle cell;

    // Border
    private Line borderLeft;
    private boolean borderLeftState;
    private Line borderTop;
    private boolean borderTopState;
    private Line borderRight;
    private boolean borderRightState;
    private Line borderBottom;
    private boolean borderBottomState;

    public Cell(int x, int y) {
        cell = new Rectangle(x, y, Settings.cellSize, Settings.cellSize);
        cell.setColor(Settings.colorCellBackground);
        cell.fill();

        borderLeft = new Line(x, y, x, y + Settings.cellSize);
        borderLeft.setColor(Settings.colorCellBorder);

        borderTop = new Line(x, y, x + Settings.cellSize, y);
        borderTop.setColor(Settings.colorCellBorder);

        borderRight = new Line(x + Settings.cellSize, y, x + Settings.cellSize, y + Settings.cellSize);
        borderRight.setColor(Settings.colorCellBorder);

        borderBottom = new Line(x, y + Settings.cellSize, x + Settings.cellSize, y + Settings.cellSize);
        borderBottom.setColor(Settings.colorCellBorder);

        showBorders();
    }

    public void changeColor(Color color) {
        cell.setColor(color);
    }

    public void showBorders() {
        borderLeft.draw();
        borderLeftState = true;
        borderTop.draw();
        borderTopState = true;
        borderRight.draw();
        borderRightState = true;
        borderBottom.draw();
        borderBottomState = true;
    }

    public void hideBorders() {
        borderLeft.delete();
        borderLeftState = false;
        borderTop.delete();
        borderTopState = false;
        borderRight.delete();
        borderRightState = false;
        borderBottom.delete();
        borderBottomState = false;
    }

    public void hideShowBorder(Border border) {
        switch (border) {
            case LEFT:
                if (borderLeftState) borderLeft.delete(); else borderLeft.draw();
                borderLeftState = !borderLeftState;
                break;
            case TOP:
                if (borderTopState) borderTop.delete(); else borderTop.draw();
                borderTopState = !borderTopState;
                break;
            case RIGHT:
                if (borderRightState) borderRight.delete(); else borderRight.draw();
                borderRightState = !borderRightState;
                break;
            case BOTTOM:
                if (borderBottomState) borderBottom.delete(); else borderBottom.draw();
                borderBottomState = !borderBottomState;
                break;
        }
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                cell.getColor().getRed(),
                cell.getColor().getGreen(),
                cell.getColor().getBlue(),
                borderLeftState,
                borderTopState,
                borderRightState,
                borderBottomState);
    }

}