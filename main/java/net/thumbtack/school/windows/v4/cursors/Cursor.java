package net.thumbtack.school.windows.v4.cursors;

import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.iface.Movable;

public class Cursor implements Movable {
    private int x;
    private int y;
    private CursorForm cursorForm;

    public Cursor(int x, int y, CursorForm cursorForm) {
        this.x = x;
        this.y = y;
        this.cursorForm = cursorForm;
    }

    public Cursor(Point point, CursorForm cursorForm) {
        this(point.getX(), point.getY(), cursorForm);
    }

    public CursorForm getCursorForm() {
        return cursorForm;
    }

    public void setCursorForm(CursorForm cursorForm) {
        this.cursorForm = cursorForm;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void moveTo(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        setX(x + dx);
        setY(y + dy);
    }
}
