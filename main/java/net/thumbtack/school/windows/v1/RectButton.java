package net.thumbtack.school.windows.v1;

import java.util.Objects;

public class RectButton {
    private Point topLeft;
    private Point bottomRight;
    private boolean active;

    public RectButton(Point topLeft, Point bottomRight, boolean active) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.active = active;
    }

    public RectButton(int xLeft, int yTop, int width, int height, boolean active) {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), active);
    }

    public RectButton(Point topLeft, Point bottomRight) {
        this(topLeft, bottomRight, true);
    }

    public RectButton(int xLeft, int yTop, int width, int height) {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), true);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public boolean isActive() {
        return active;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getWidth() {
        return bottomRight.getX() - topLeft.getX() + 1;
    }

    public int getHeight() {
        return bottomRight.getY() - topLeft.getY() + 1;
    }

    public void moveTo(int x, int y) {
        bottomRight.setX(getWidth() - 1 + x);
        bottomRight.setY(getHeight() - 1 + y);
        topLeft.setX(x);
        topLeft.setY(y);
    }

    public void moveTo(Point point) {
        bottomRight.setX(getWidth() - 1 + point.getX());
        bottomRight.setY(getHeight() - 1 + point.getY());
        topLeft.setX(point.getX());
        topLeft.setY(point.getY());
    }

    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
        bottomRight.moveRel(dx, dy);
    }

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

    public boolean isIntersects(RectButton rectButton) {
        for (int x = rectButton.topLeft.getX(); x <= rectButton.bottomRight.getX(); x++) {
            for (int y = rectButton.topLeft.getY(); y <= rectButton.bottomRight.getY(); y++) {
                if (isInside(x, y)) return true;
            }
        }
        return false;
    }

    public boolean isInside(RectButton rectButton) {
        if (topLeft.getX() <= rectButton.topLeft.getX() && bottomRight.getX() >= rectButton.bottomRight.getX() &&
                topLeft.getY() <= rectButton.topLeft.getY() && bottomRight.getY() >= rectButton.bottomRight.getY())
            return true;
        else return false;
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
        RectButton that = (RectButton) o;
        return active == that.active &&
                topLeft.equals(that.topLeft) &&
                bottomRight.equals(that.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight, active);
    }
}
