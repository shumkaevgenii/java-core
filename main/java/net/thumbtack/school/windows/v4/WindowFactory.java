package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

public class WindowFactory {
    private static int RectButtonCount = 0;
    private static int RoundButtonCount = 0;

    public static RectButton createRectButton(Point leftTop, Point rightBottom, WindowState state, String text) throws WindowException {
        RectButtonCount++;
        return new RectButton(leftTop, rightBottom, state, text);
    }

    public static RoundButton createRoundButton(Point center, int radius, WindowState state, String text) throws WindowException {
        RoundButtonCount++;
        return new RoundButton(center, radius, state, text);
    }

    public static int getRectButtonCount() {
        return RectButtonCount;
    }

    public static int getRoundButtonCount() {
        return RoundButtonCount;
    }

    public static int getWindowCount() {
        return RoundButtonCount + RectButtonCount;
    }

    public static void reset() {
        RectButtonCount = RoundButtonCount = 0;
    }
}
