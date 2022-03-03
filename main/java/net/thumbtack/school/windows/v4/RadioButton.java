package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

public class RadioButton extends RoundButton {
    private boolean checked;

    public RadioButton(Point center, int radius, WindowState state, String text, boolean checked) throws WindowException {
        super(center, radius, state, text);
        this.checked = checked;
    }

    public RadioButton(Point center, int radius, String state, String text, boolean checked) throws WindowException {
        this(center, radius, WindowState.fromString(state), text, checked);
    }

    public RadioButton(int xCenter, int yCenter, int radius, WindowState state, String text, boolean checked) throws WindowException {
        this(new Point(xCenter, yCenter), radius, state, text, checked);
    }

    public RadioButton(Point center, int radius, String text, boolean checked) throws WindowException {
        this(center, radius, WindowState.ACTIVE, text, checked);
    }

    public RadioButton(int xCenter, int yCenter, int radius, String text, boolean checked) throws WindowException {
        this(new Point(xCenter, yCenter), radius, WindowState.ACTIVE, text, checked);
    }

    public RadioButton(int xCenter, int yCenter, int radius, String state, String text, boolean checked) throws WindowException {
        this(new Point(xCenter, yCenter), radius, WindowState.fromString(state), text, checked);
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
