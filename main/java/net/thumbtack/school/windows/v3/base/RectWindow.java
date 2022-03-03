package net.thumbtack.school.windows.v3.base;

import net.thumbtack.school.windows.v3.Desktop;
import net.thumbtack.school.windows.v3.ListBox;
import net.thumbtack.school.windows.v3.Point;
import net.thumbtack.school.windows.v3.RectButton;

import java.util.Objects;

public abstract class RectWindow extends Window {
    private Point topLeft;
    private Point bottomRight;

    public RectWindow(Point topLeft, Point bottomRight, boolean active) {
        super(active);
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public RectWindow(int xLeft, int yTop, int width, int height, boolean active, String text) {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), active);
    }

    public RectWindow(Point topLeft, Point bottomRight, String text) {
        this(topLeft, bottomRight, true);
    }

    public RectWindow(int xLeft, int yTop, int width, int height, String text) {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), true);
    }


    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public int getWidth() {
        return bottomRight.getX() - topLeft.getX() + 1;
    }

    public int getHeight() {
        return bottomRight.getY() - topLeft.getY() + 1;
    }

    @Override
    public void moveTo(int x, int y) {
        bottomRight.setX(getWidth() - 1 + x);
        bottomRight.setY(getHeight() - 1 + y);
        topLeft.setX(x);
        topLeft.setY(y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
        bottomRight.moveRel(dx, dy);
    }

    @Override
    public void resize(double ratio) {
        int width = ((int) (getWidth() * ratio));
        if (width < 1) width = 1;
        bottomRight.setX(width + topLeft.getX() - 1);

        int height = (int) (getHeight() * ratio);
        if (height < 1) height = 1;
        bottomRight.setY(height + topLeft.getY() - 1);
    }


    public boolean isInside(int x, int y) {
        if (x >= topLeft.getX() && x <= bottomRight.getX() && y >= topLeft.getY() && y <= bottomRight.getY())
            return true;
        else return false;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isInside(RectButton rectButton) {
        if (topLeft.getX() <= rectButton.getTopLeft().getX() && bottomRight.getX() >= rectButton.getBottomRight().getX() &&
                topLeft.getY() <= rectButton.getTopLeft().getY() && bottomRight.getY() >= rectButton.getBottomRight().getY())
            return true;
        else return false;
    }

    public boolean isIntersects(ListBox listBox) {
        for (int x = listBox.getTopLeft().getX(); x <= listBox.getBottomRight().getX(); x++) {
            for (int y = listBox.getTopLeft().getY(); y <= listBox.getBottomRight().getY(); y++) {
                if (isInside(x, y)) return true;
            }
        }
        return false;
    }

    public boolean isInside(ListBox listBox) {
        if (topLeft.getX() <= listBox.getTopLeft().getX() && bottomRight.getX() >= listBox.getBottomRight().getX() &&
                topLeft.getY() <= listBox.getTopLeft().getY() && bottomRight.getY() >= listBox.getBottomRight().getY())
            return true;
        else return false;
    }


    public boolean isIntersects(RectButton rectButton) {
        for (int x = rectButton.getTopLeft().getX(); x <= rectButton.getBottomRight().getX(); x++) {
            for (int y = rectButton.getTopLeft().getY(); y <= rectButton.getBottomRight().getY(); y++) {
                if (isInside(x, y)) return true;
            }
        }
        return false;
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        if (topLeft.getX() >= 0 && topLeft.getX() <= desktop.getWidth()
                && topLeft.getY() >= 0 && topLeft.getY() <= desktop.getHeight()
                && bottomRight.getX() >= 0 && bottomRight.getX() <= desktop.getWidth()
                && bottomRight.getY() >= 0 && bottomRight.getY() <= desktop.getHeight()) return true;
        else return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectWindow that = (RectWindow) o;
        return Objects.equals(topLeft, that.topLeft) &&
                Objects.equals(bottomRight, that.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }
}
