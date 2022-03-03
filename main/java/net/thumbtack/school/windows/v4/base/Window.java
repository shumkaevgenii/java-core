package net.thumbtack.school.windows.v4.base;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.iface.Resizable;
import net.thumbtack.school.windows.v4.iface.Movable;

public abstract class Window implements Movable, Resizable {
    private WindowState state;

    public Window(WindowState state) throws WindowException {
        if (state == WindowState.ACTIVE || state == WindowState.INACTIVE)
            this.state = state;
        else
            throw new WindowException(WindowErrorCode.WRONG_STATE);
    }

    public void setState(WindowState state) throws WindowException {
        if (this.state == WindowState.DESTROYED && state != WindowState.DESTROYED)
            throw new WindowException(WindowErrorCode.WRONG_STATE);
        this.state = state;
    }

    public WindowState getState() {
        return state;
    }

    public abstract boolean isInside(int x, int y);

    public boolean isInside(Point point){
        return isInside(point.getX(), point.getY());
    }

    public abstract boolean isFullyVisibleOnDesktop(Desktop desktop);
}
