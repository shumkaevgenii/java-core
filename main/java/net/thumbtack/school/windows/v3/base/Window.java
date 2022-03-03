package net.thumbtack.school.windows.v3.base;

import net.thumbtack.school.windows.v3.Desktop;
import net.thumbtack.school.windows.v3.Point;
import net.thumbtack.school.windows.v3.iface.Resizable;
import net.thumbtack.school.windows.v3.iface.Movable;

public abstract class Window implements Movable, Resizable {
    private boolean active;

    public Window(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract boolean isInside(int x, int y);

    public abstract boolean isInside(Point point);

    public abstract boolean isFullyVisibleOnDesktop(Desktop desktop);
}
