package net.thumbtack.school.ttschool;

import java.io.Serializable;
import java.util.Objects;

public class Trainee implements Serializable {
    private String LastName;
    private String FirstName;
    private int Rating;

    public Trainee(String firstName, String lastName, int rating) throws TrainingException {
        if (firstName == null || firstName.equals(""))
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_FIRSTNAME);
        if (lastName == null || lastName.equals(""))
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_LASTNAME);
        if (rating < 1 || rating > 5) throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_RATING);
        LastName = lastName;
        FirstName = firstName;
        Rating = rating;
    }

    public void setFirstName(String firstName) throws TrainingException {
        if (firstName == null || firstName.equals(""))
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_FIRSTNAME);
        FirstName = firstName;
    }

    public void setLastName(String lastName) throws TrainingException {
        if (lastName == null || lastName.equals(""))
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_LASTNAME);
        LastName = lastName;
    }

    public void setRating(int rating) throws TrainingException {
        if (rating < 1 || rating > 5) throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_RATING);
        Rating = rating;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getRating() {
        return Rating;
    }

    public String getFullName(){
        return FirstName + " " + LastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainee trainee = (Trainee) o;
        return Rating == trainee.Rating &&
                Objects.equals(LastName, trainee.LastName) &&
                Objects.equals(FirstName, trainee.FirstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LastName, FirstName, Rating);
    }
}
