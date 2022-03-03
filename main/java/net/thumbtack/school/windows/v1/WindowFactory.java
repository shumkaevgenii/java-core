package net.thumbtack.school.windows.v1;

public class WindowFactory {
    private static int RectButtonCount = 0;
    private static int RoundButtonCount = 0;

    public static RectButton createRectButton(Point leftTop, Point rightBottom, boolean active) {
        RectButtonCount++;
        return new RectButton(leftTop, rightBottom, active);
    }

    public static RoundButton createRoundButton(Point center, int radius, boolean active) {
        RoundButtonCount++;
        return new RoundButton(center, radius, active);
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
