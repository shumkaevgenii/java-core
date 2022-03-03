package net.thumbtack.school.windows.v3;

public class WindowFactory {
    private static int RectButtonCount = 0;
    private static int RoundButtonCount = 0;

    public static RectButton createRectButton(Point leftTop, Point rightBottom, boolean active, String text) {
        RectButtonCount++;
        return new RectButton(leftTop, rightBottom, active, text);
    }

    public static RoundButton createRoundButton(Point center, int radius, boolean active, String text) {
        RoundButtonCount++;
        return new RoundButton(center, radius, active, text);
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
