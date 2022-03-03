package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

public class ComboBox extends ListBox {
    public Integer selected;

    public ComboBox(Point topLeft, Point bottomRight, WindowState state, String[] lines, Integer selected) throws WindowException {
        super(topLeft, bottomRight, state, lines);
        if (selected == null) {
            this.selected = null;
            return;
        }
        if (getLines() == null) throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        if (selected > getLines().length - 1 || selected < 0) throw new WindowException(WindowErrorCode.WRONG_INDEX);
        this.selected = selected;
    }

    public ComboBox(Point topLeft, Point bottomRight, String state, String[] lines, Integer selected) throws WindowException {
        this(topLeft, bottomRight, WindowState.fromString(state), lines, selected);
    }

    public ComboBox(int xLeft, int yTop, int width, int height, WindowState state, String[] lines, Integer selected) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), state, lines, selected);
    }

    public ComboBox(Point topLeft, Point bottomRight, String[] lines, Integer selected) throws WindowException {
        this(topLeft, bottomRight, WindowState.ACTIVE, lines, selected);
    }

    public ComboBox(int xLeft, int yTop, int width, int height, String[] lines, Integer selected) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), WindowState.ACTIVE, lines, selected);
    }

    public ComboBox(int xLeft, int yTop, int width, int height, String state, String[] lines, Integer selected) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), WindowState.fromString(state), lines, selected);
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) throws WindowException {
        if (selected == null) {
            this.selected = null;
            return;
        }
        if (getLines() == null) throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        if (selected > getLines().length - 1 || selected < 0) throw new WindowException(WindowErrorCode.WRONG_INDEX);
        this.selected = selected;
    }

    public void setLines(String[] lines) {
        super.setLines(lines);
        selected = null;
    }
}
