package net.thumbtack.school.windows.v3.base;

import net.thumbtack.school.windows.v3.Desktop;
import net.thumbtack.school.windows.v3.Point;

import java.util.Objects;

public abstract class RoundWindow extends Window {
    private Point center;
    private int radius;
    private String text;

    public RoundWindow(Point center, int radius, String text, boolean active) {
        super(active);
        this.center = center;
        this.radius = radius;
        this.text = text;
    }

    public RoundWindow(int x, int y, int radius, String text, boolean active) {
        this(new Point(x, y), radius, text, active);
    }

    public RoundWindow(Point center, int radius, String text) {
        this(center, radius, text, true);
    }

    public RoundWindow(int x, int y, int radius, String text) {
        this(new Point(x, y), radius, text, true);
    }


    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public String getText() {
        return text;
    }

    public void setCenter(int x, int y) {
        center.setX(x);
        center.setY(y);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public void moveTo(int x, int y) {
        setCenter(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        setCenter(center.getX() + dx, center.getY() + dy);
    }

    @Override
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
        return isInside(point.getX(), point.getY());
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
        RoundWindow that = (RoundWindow) o;
        return radius == that.radius &&
                Objects.equals(center, that.center) &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius, text);
    }
}
