package net.thumbtack.school.ttschool;

public class TrainingException extends Exception {

    public TrainingException(TrainingErrorCode errorCode, Throwable cause) {
        super(errorCode.getErrorString(), cause);
        this.errorCode = errorCode;
    }

    public TrainingException(TrainingErrorCode errorCode) {
        super(errorCode.getErrorString());
        this.errorCode = errorCode;
    }

    public TrainingException(TrainingErrorCode errorCode, String param) {
        super(String.format(errorCode.getErrorString(), param));
        this.errorCode = errorCode;
    }

    private TrainingErrorCode errorCode;

    public TrainingErrorCode getErrorCode() {
        return errorCode;
    }
}
