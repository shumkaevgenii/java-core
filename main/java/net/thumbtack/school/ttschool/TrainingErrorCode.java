package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("WRONG_FIRSTNAME"),
    TRAINEE_WRONG_LASTNAME("WRONG_LASTNAME"),
    TRAINEE_WRONG_RATING("WRONG_RATTING"),
    GROUP_WRONG_NAME("WRONG_GROUP_NAME"),
    GROUP_WRONG_ROOM("WRONG_GROUP_ROOM"),
    TRAINEE_NOT_FOUND("WRONG_TRAINEE_NOT_FOUND"),
    DUPLICATE_TRAINEE("WRONG_DUPLICATE_TRAINEE"),
    SCHOOL_WRONG_NAME("WRONG_GROUP_NAME"),
    DUPLICATE_GROUP_NAME("WRONG_DUPLICATE_GROUP"),
    GROUP_NOT_FOUND("WRONG_GROUP_NOT_FOUND"),
    EMPTY_TRAINEE_QUEUE("WRONG_EMPTY_TRAINEE_QUEUE");

    private String errorString;

    private TrainingErrorCode(String errorString){
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
