package net.thumbtack.school.windows.v4.base;

public class WindowException extends Exception {
    public WindowException(WindowErrorCode errorCode, Throwable cause) {
        super(errorCode.getErrorString(), cause);
        this.errorCode = errorCode;
    }

    public WindowException(WindowErrorCode errorCode) {
        super(errorCode.getErrorString());
        this.errorCode = errorCode;
    }

    public WindowException(WindowErrorCode errorCode, String param) {
        super(String.format(errorCode.getErrorString(), param));
        this.errorCode = errorCode;
    }

    private WindowErrorCode errorCode;

    public WindowErrorCode getWindowErrorCode() {
        return errorCode;
    }
}
