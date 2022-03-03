package net.thumbtack.school.windows.v2;

import java.util.Objects;

public class RectButton3D extends RectButton {
    private int zHeight;

    public RectButton3D(Point topLeft, Point bottomRight, boolean active, String text, int zHeight) {
        super(topLeft, bottomRight, active, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, boolean active, String text, int zHeight) {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), active, text, zHeight);
    }

    public RectButton3D(Point topLeft, Point bottomRight, String text, int zHeight) {
        this(topLeft, bottomRight, true, text, zHeight);
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, String text, int zHeight) {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), true, text, zHeight);
    }

    public int getZHeight() {
        return this.zHeight;
    }

    public void setZHeight(int zHeight) {
        this.zHeight = zHeight;
    }

    public boolean isInside(RectButton3D rectButton3D) {
        if (isInside(new RectButton(rectButton3D.getTopLeft(), rectButton3D.getBottomRight(), rectButton3D.isActive(), rectButton3D.getText()))
                && this.getZHeight() >= rectButton3D.getZHeight()) return true;
        else return false;
    }
}

