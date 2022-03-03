package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.RectWindow;
import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

public class RectButton extends RectWindow {
    private String text;

    public RectButton(Point topLeft, Point bottomRight, WindowState state, String text) throws WindowException {
        super(topLeft, bottomRight, state);
        this.text = text;
    }

    public RectButton(Point topLeft, Point bottomRight, String state, String text) throws WindowException {
        this(topLeft, bottomRight, WindowState.fromString(state), text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, WindowState state, String text) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), state, text);
    }

    public RectButton(Point topLeft, Point bottomRight, String text) throws WindowException {
        this(topLeft, bottomRight, WindowState.ACTIVE, text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, String text) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), WindowState.ACTIVE, text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, String state, String text) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), WindowState.fromString(state), text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isIntersects(RectButton rectButton) {
        for (int x = rectButton.getTopLeft().getX(); x <= rectButton.getBottomRight().getX(); x++) {
            for (int y = rectButton.getTopLeft().getY(); y <= rectButton.getBottomRight().getY(); y++) {
                if (isInside(x, y)) return true;
            }
        }
        return false;
    }

    public boolean isInside(RectButton rectButton) {
        if (getTopLeft().getX() <= rectButton.getTopLeft().getX() && getBottomRight().getX() >= rectButton.getBottomRight().getX() &&
                getTopLeft().getY() <= rectButton.getTopLeft().getY() && getBottomRight().getY() >= rectButton.getBottomRight().getY())
            return true;
        else return false;
    }
}
