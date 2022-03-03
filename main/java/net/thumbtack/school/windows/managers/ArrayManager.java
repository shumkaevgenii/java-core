package net.thumbtack.school.windows.managers;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.base.Window;
import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.cursors.Cursor;

public class ArrayManager<T extends Window> {
    private T[] Windows;

    public ArrayManager(T[] Windows) throws WindowException {
        for (T Window : Windows) if (Window == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        this.Windows = Windows;
    }

    public T[] getWindows() {
        return Windows;
    }

    public void setWindows(T[] windows) throws WindowException {
        if (windows == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        Windows = windows;
    }

    public T getWindow(int i) throws WindowException {
        if (Windows[i] == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        return Windows[i];
    }

    public void setWindow(T Window, int i) throws WindowException {
        if (Window == null || Windows == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        Windows[i] = Window;
    }

    public boolean isSameSize(ArrayManager<?> arrayManager) {
        return Windows.length == arrayManager.Windows.length;
    }

    public boolean allWindowsFullyVisibleOnDesktop(Desktop desktop) {
        for (T window : Windows)
            if (!window.isFullyVisibleOnDesktop(desktop))
                return false;
        return true;
    }

    public boolean anyWindowFullyVisibleOnDesktop(Desktop desktop) {
        for (T window : Windows)
            if (window.isFullyVisibleOnDesktop(desktop))
                return true;
        return false;
    }

    public Window getFirstWindowFromCursor(Cursor cursor) {
        for (T Window : Windows) if (Window.isInside(cursor.getX(), cursor.getY())) return Window;
        return null;
    }

}
