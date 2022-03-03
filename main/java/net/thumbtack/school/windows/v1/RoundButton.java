package net.thumbtack.school.windows.v1;

import java.util.Objects;

public class RoundButton {
    private Point center;
    private int radius;
    private boolean active;

    public RoundButton(Point center, int radius, boolean active) {
        this.center = center;
        this.radius = radius;
        this.active = active;
    }

    public RoundButton(int xCenter, int yCenter, int radius, boolean active) {
        this(new Point(xCenter, yCenter), radius, active);
    }

    public RoundButton(Point center, int radius) {
        this(center, radius, true);
    }

    public RoundButton(int xCenter, int yCenter, int radius) {
        this(new Point(xCenter, yCenter), radius, true);
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public boolean isActive() {
        return active;
    }

    public void moveTo(int x, int y) {
        center.setX(x);
        center.setY(y);
    }

    public void moveTo(Point point) {
        center = point;
    }

    public void setCenter(int x, int y) {
        moveTo(x, y);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        int R = (int) (radius * ratio);
        if (R < 1) R = 1;
        setRadius(R);
    }

    public boolean isInside(int x, int y) {
        double X = Math.abs(center.getX()) - (Math.abs(x));
        double Y = Math.abs(center.getY()) - (Math.abs(y));
        double length = Math.sqrt(X * X + Y * Y);
        if (radius >= length) return true;
        else return false;
    }

    public boolean isInside(Point point) {
        double X = Math.abs(center.getX()) - (Math.abs(point.getX()));
        double Y = Math.abs(center.getY()) - (Math.abs(point.getY()));
        double length = Math.sqrt(X * X + Y * Y);
        if (radius >= length) return true;
        else return false;
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        if (center.getX() - radius >= 0 && center.getY() - radius >= 0
                && center.getX() + radius < desktop.getWidth() && center.getY() + radius < desktop.getHeight())
            return true;
        else return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundButton that = (RoundButton) o;
        return radius == that.radius &&
                active == that.active &&
                center.equals(that.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius, active);
    }
}
