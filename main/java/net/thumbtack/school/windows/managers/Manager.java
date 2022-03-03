package net.thumbtack.school.windows.managers;

import net.thumbtack.school.windows.v4.base.Window;
import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.iface.Movable;

public class Manager<T extends Window> implements Movable {
    private T Window;

    public Manager(T Window) throws WindowException {
        super();
        if (Window == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        this.Window = Window;
    }

    public T getWindow() {
        return Window;
    }

    public void setWindow(T Window) throws WindowException {
        if (Window == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        this.Window = Window;
    }

    @Override
    public void moveTo(int x, int y) {
        Window.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        Window.moveRel(dx, dy);
    }
}
