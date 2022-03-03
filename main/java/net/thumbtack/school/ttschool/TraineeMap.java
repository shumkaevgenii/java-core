package net.thumbtack.school.ttschool;

import java.util.*;

public class TraineeMap {
    private Map<Trainee,String> map;

    public TraineeMap(){
        map = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException{
        if(map.containsKey(trainee)) throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        map.put(trainee,institute);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if(!map.containsKey(trainee)) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        map.put(trainee,institute);
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        if(!map.containsKey(trainee)) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        map.remove(trainee);
    }

    public int getTraineesCount(){
        return map.size();
    }

    public String getInstituteByTrainee(Trainee trainee)throws TrainingException{
        if(map.get(trainee)==null) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        return map.get(trainee);
    }

    public Set<Trainee> getAllTrainees(){
        return map.keySet();
    }

    public Set<String> getAllInstitutes(){
        return new HashSet<String>(map.values());
    }

    public boolean isAnyFromInstitute(String institute){
        Set<String> set = getAllInstitutes();
        return set.contains(institute);
    }

}
