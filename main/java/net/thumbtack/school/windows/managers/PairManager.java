package net.thumbtack.school.windows.managers;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.base.Window;
import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;

public class PairManager<T extends Window, V extends Window> {
    private T FirstWindow;
    private V SecondWindow;

    public PairManager(T firstWindow, V secondWindow) throws WindowException {
        if (firstWindow == null || secondWindow == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        FirstWindow = firstWindow;
        SecondWindow = secondWindow;
    }

    public T getFirstWindow() {
        return FirstWindow;
    }

    public V getSecondWindow() {
        return SecondWindow;
    }

    public void setFirstWindow(T firstWindow) throws WindowException {
        if (firstWindow == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        FirstWindow = firstWindow;
    }

    public void setSecondWindow(V secondWindow) throws WindowException {
        if (secondWindow == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        SecondWindow = secondWindow;
    }

    public boolean allWindowsFullyVisibleOnDesktop(PairManager<?, ?> pairManager, Desktop desktop) {
        return FirstWindow.isFullyVisibleOnDesktop(desktop) && SecondWindow.isFullyVisibleOnDesktop(desktop)
                && pairManager.FirstWindow.isFullyVisibleOnDesktop(desktop) && pairManager.SecondWindow.isFullyVisibleOnDesktop(desktop);
    }

    public static boolean allWindowsFullyVisibleOnDesktop(PairManager<?, ?> FPair, PairManager<?, ?> Spair, Desktop desktop) {
        return FPair.FirstWindow.isFullyVisibleOnDesktop(desktop) && FPair.SecondWindow.isFullyVisibleOnDesktop(desktop)
                && Spair.FirstWindow.isFullyVisibleOnDesktop(desktop) && Spair.SecondWindow.isFullyVisibleOnDesktop(desktop);
    }
}
