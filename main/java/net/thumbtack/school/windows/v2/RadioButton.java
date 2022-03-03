package net.thumbtack.school.windows.v2;

import java.util.Objects;

public class RadioButton extends RoundButton {
    boolean checked;

    public RadioButton(Point center, int radius, boolean active, String text, boolean checked) {
        super(center, radius, active, text);
        this.checked = checked;
    }

    public RadioButton(int xCenter, int yCenter, int radius, boolean active, String text, boolean checked) {
        this(new Point(xCenter, yCenter), radius, active, text, checked);
    }

    public RadioButton(Point center, int radius, String text, boolean checked) {
        this(center, radius, true, text, checked);
    }

    public RadioButton(int xCenter, int yCenter, int radius, String text, boolean checked) {
        this(new Point(xCenter, yCenter), radius, true, text, checked);
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
