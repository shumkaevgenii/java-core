package net.thumbtack.school.windows.v2;

import java.util.Arrays;
import java.util.Objects;

public class ListBox {
    private Point topLeft;
    private Point bottomRight;
    private boolean active;
    private String lines[];


    public ListBox(Point topLeft, Point bottomRight, boolean active, String[] lines) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.active = active;
        if (lines == null) this.lines = null;
        else this.lines = Arrays.copyOf(lines, lines.length);
    }

    public ListBox(int xLeft, int yTop, int width, int height, boolean active, String[] lines) {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), active, lines);
    }

    public ListBox(Point topLeft, Point bottomRight, String[] lines) {
        this(topLeft, bottomRight, true, lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, String[] lines) {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), true, lines);
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

    public String[] getLines() {
        return lines;
    }

    public void setLines(String[] lines) {
        if (lines == null) {
            this.lines = null;
            return;
        }
        this.lines = Arrays.copyOf(lines, lines.length);
    }

    public String[] getLinesSlice(int from, int to) {
        if (lines == null) return null;
        int size = lines.length - from;
        size -= to > lines.length ? 0 : lines.length - to;
        int end = to > lines.length ? lines.length : to;
        String str[] = new String[size];
        for (int i = from, j = 0; i < end; i++) str[j++] = new String(lines[i]);
        return str;
    }

    public String getLine(int index) {
        if (index >= lines.length || lines[index] == null) return null;
        return new String(lines[index]);
    }

    public void setLine(int index, String line) {
        if (lines == null) return;
        lines[index] = new String(line);
    }

    public Integer findLine(String line) {
        if (lines == null) return null;
        for (int i = 0; i < lines.length; i++) if (lines[i].equals(line)) return i;
        return null;
    }

    public void reverseLineOrder() {
        if (lines == null) return;
        String str[] = new String[lines.length];
        for (int i = 0, j = lines.length - 1; i < lines.length; i++) str[i] = lines[j--];
        lines = str;
    }

    public void reverseLines() {
        if (lines == null) return;
        StringBuilder str;
        for (int i = 0; i < lines.length; i++) {
            str = new StringBuilder(lines[i]);
            setLine(i, str.reverse().toString());
        }
    }

    public void duplicateLines() {
        if (lines == null) return;
        String str[] = new String[lines.length * 2];
        for (int i = 0, j = 0; i < str.length; j++) {
            str[i++] = lines[j];
            str[i++] = lines[j];
        }
        lines = str;
    }

    public void removeOddLines() {
        if (lines == null || lines.length == 1) return;
        int odd = lines.length % 2 == 0 ? lines.length / 2 : lines.length / 2 + 1;
        String str[] = new String[odd];
        for (int i = 0, j = 0; i < lines.length; i++) {
            if ((i + 1) % 2 != 0) str[j++] = lines[i];
        }
        lines = str;
    }

    public boolean isSortedDescendant() {
        if (lines == null) return true;
        for (int i = 0; i < lines.length - 1; i++) if (lines[i].compareTo(lines[i + 1]) <= 0) return false;
        return true;
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

    public boolean isIntersects(ListBox listBox) {
        for (int x = listBox.topLeft.getX(); x <= listBox.bottomRight.getX(); x++) {
            for (int y = listBox.topLeft.getY(); y <= listBox.bottomRight.getY(); y++) {
                if (isInside(x, y)) return true;
            }
        }
        return false;
    }

    public boolean isInside(ListBox listBox) {
        if (topLeft.getX() <= listBox.topLeft.getX() && bottomRight.getX() >= listBox.bottomRight.getX() &&
                topLeft.getY() <= listBox.topLeft.getY() && bottomRight.getY() >= listBox.bottomRight.getY())
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
        ListBox listBox = (ListBox) o;
        return active == listBox.active &&
                Objects.equals(topLeft, listBox.topLeft) &&
                Objects.equals(bottomRight, listBox.bottomRight) &&
                Arrays.equals(lines, listBox.lines);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(topLeft, bottomRight, active);
        result = 31 * result + Arrays.hashCode(lines);
        return result;
    }
}
