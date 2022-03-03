package net.thumbtack.school.windows.v4.base;

public enum WindowErrorCode {
    WRONG_STATE("WRONG_STATE"),
    WRONG_INDEX("WRONG_INDEX"),
    EMPTY_ARRAY("EMPTY_ARRAY"),
    NULL_WINDOW("NULL_WINDOW");

    private String errorString;

    WindowErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
