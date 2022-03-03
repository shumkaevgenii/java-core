package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.RectWindow;
import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

import java.util.Arrays;

public class ListBox extends RectWindow {
    private String[] lines;

    public ListBox(Point topLeft, Point bottomRight, WindowState state, String[] lines) throws WindowException {
        super(topLeft, bottomRight, state);
        if (lines == null) this.lines = null;
        else this.lines = Arrays.copyOf(lines, lines.length);
    }

    public ListBox(Point topLeft, Point bottomRight, String state, String[] lines) throws WindowException {
        this(topLeft, bottomRight, WindowState.fromString(state), lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, WindowState state, String[] lines) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), state, lines);
    }

    public ListBox(Point topLeft, Point bottomRight, String[] lines) throws WindowException {
        this(topLeft, bottomRight, WindowState.ACTIVE, lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, String[] lines) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), WindowState.ACTIVE, lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, String state, String[] lines) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), WindowState.fromString(state), lines);
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

    public String[] getLinesSlice(int from, int to) throws WindowException {
        if (lines == null) throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        if (from < 0 || lines.length < to || from > to - 1) throw new WindowException(WindowErrorCode.WRONG_INDEX);
        int size = lines.length - from;
        size -= to > lines.length ? 0 : lines.length - to;
        int end = Math.min(to, lines.length);
        String[] str = new String[size];
        for (int i = from, j = 0; i < end; i++) str[j++] = new String(lines[i]);
        return str;
    }

    public String getLine(int index) throws WindowException {
        if (lines == null) throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        if (index >= lines.length) throw new WindowException(WindowErrorCode.WRONG_INDEX);
        return new String(lines[index]);
    }

    public void setLine(int index, String line) throws WindowException {
        if (lines == null) throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        if (index >= lines.length || index < 0) throw new WindowException(WindowErrorCode.WRONG_INDEX);
        lines[index] = line;
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

    public void reverseLines() throws WindowException {
        if (lines == null) return;
        StringBuilder str;
        for (int i = 0; i < lines.length; i++) {
            str = new StringBuilder(lines[i]);
            setLine(i, str.reverse().toString());
        }
    }

    public void duplicateLines() {
        if (lines == null) return;
        String[] str = new String[lines.length * 2];
        for (int i = 0, j = 0; i < str.length; j++) {
            str[i++] = lines[j];
            str[i++] = lines[j];
        }
        lines = str;
    }

    public void removeOddLines() {
        if (lines == null || lines.length == 1) return;
        int odd = lines.length % 2 == 0 ? lines.length / 2 : lines.length / 2 + 1;
        String[] str = new String[odd];
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

    public boolean isIntersects(ListBox listBox) {
        for (int x = listBox.getTopLeft().getX(); x <= listBox.getBottomRight().getX(); x++) {
            for (int y = listBox.getTopLeft().getY(); y <= listBox.getBottomRight().getY(); y++) {
                if (isInside(x, y)) return true;
            }
        }
        return false;
    }

    public boolean isInside(ListBox listBox) {
        if (getTopLeft().getX() <= listBox.getTopLeft().getX() && getBottomRight().getX() >= listBox.getBottomRight().getX() &&
                getTopLeft().getY() <= listBox.getTopLeft().getY() && getBottomRight().getY() >= listBox.getBottomRight().getY())
            return true;
        else return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ListBox listBox = (ListBox) o;
        return Arrays.equals(lines, listBox.lines);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(lines);
        return result;
    }
}
