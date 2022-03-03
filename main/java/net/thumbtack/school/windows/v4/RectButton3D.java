package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

import java.util.Objects;

public class RectButton3D extends RectButton {
    private int zHeight;

    public RectButton3D(Point topLeft, Point bottomRight, WindowState state, String text, int zHeight) throws WindowException {
        super(topLeft, bottomRight, state, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(Point topLeft, Point bottomRight, String state, String text, int zHeight) throws WindowException {
        this(topLeft, bottomRight, WindowState.fromString(state), text, zHeight);
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, WindowState state, String text, int zHeight) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), state, text, zHeight);
    }

    public RectButton3D(Point topLeft, Point bottomRight, String text, int zHeight) throws WindowException {
        this(topLeft, bottomRight, WindowState.ACTIVE, text, zHeight);
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, String text, int zHeight) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), WindowState.ACTIVE, text, zHeight);
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, String state, String text, int zHeight) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), WindowState.fromString(state), text, zHeight);
    }

    public int getZHeight() {
        return this.zHeight;
    }

    public void setZHeight(int zHeight) {
        this.zHeight = zHeight;
    }

    public boolean isInside(RectButton3D rectButton3D) {
        return isInside((RectButton) rectButton3D) && getZHeight() >= rectButton3D.getZHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RectButton3D that = (RectButton3D) o;
        return zHeight == that.zHeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), zHeight);
    }
}

