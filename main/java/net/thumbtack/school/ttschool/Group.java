package net.thumbtack.school.ttschool;

import java.util.*;

public class Group {
    private String name;
    private String room;
    private List<Trainee> trainees;

    public Group(String name, String room) throws TrainingException {
        if (name == null || name.equals(""))
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        if (room == null || room.equals(""))
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        this.name = name;
        this.room = room;
        trainees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.equals(""))
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) throws TrainingException {
        if (room == null || room.equals(""))
            throw new TrainingException((TrainingErrorCode.GROUP_WRONG_ROOM));
        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (!trainees.remove(trainee)) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void removeTrainee(int index) throws TrainingException {
        try {
            trainees.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        for(Trainee t:trainees){
            if(t.getFirstName().equals(firstName)) return t;
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        for(Trainee t:trainees){
            if(t.getFullName().equals(fullName)) return t;
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant() {
        trainees.sort(new Comparator<Trainee>() {
            @Override
            public int compare(Trainee o1, Trainee o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
    }

    public void sortTraineeListByRatingDescendant() {
        trainees.sort(new Comparator<Trainee>() {
            @Override
            public int compare(Trainee o1, Trainee o2) {
                return Integer.compare(o2.getRating(), o1.getRating());
            }
        });
    }

    public void reverseTraineeList() {
        Collections.reverse(trainees);
    }

    public void rotateTraineeList(int positions) {
        Collections.rotate(trainees, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        List<Trainee> list = new ArrayList<>();
        int maxRatting = 1;
        for (int count = 0; count < trainees.size(); count++) {
            if (trainees.get(count).getRating() > maxRatting) {
                maxRatting = trainees.get(count).getRating();
                list.clear();
                list.add(trainees.get(count));
            } else if(trainees.get(count).getRating() == maxRatting) list.add(trainees.get(count));
        }
        if (list.size() == 0) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        return list;
    }

    public boolean hasDuplicates() {
        for (int i = 0; i < trainees.size(); i++)
            for (int j = 0; j < trainees.size(); j++) {
                if(i==j) continue;
                if (trainees.get(i).equals(trainees.get(j))) return true;
            }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(room, group.room) &&
                Objects.equals(trainees, group.trainees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room, trainees);
    }
}
