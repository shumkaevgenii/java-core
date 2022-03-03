package net.thumbtack.school.windows.v2;

import java.util.Arrays;
import java.util.Objects;

public class ComboBox extends ListBox {
    public Integer selected;

    public ComboBox(Point topLeft, Point bottomRight, boolean active, String[] lines, Integer selected) {
        super(topLeft, bottomRight, active, lines);
        this.selected = selected;
    }

    public ComboBox(int xLeft, int yTop, int width, int height, boolean active, String[] lines, Integer selected) {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), active, lines, selected);
    }

    public ComboBox(Point topLeft, Point bottomRight, String[] lines, Integer selected) {
        this(topLeft, bottomRight, true, lines, selected);
    }

    public ComboBox(int xLeft, int yTop, int width, int height, String[] lines, Integer selected) {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), true, lines, selected);
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }
}
