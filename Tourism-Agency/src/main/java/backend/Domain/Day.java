package backend.Domain;

import java.util.ArrayList;
import java.util.List;

import backend.Functions.DifficultyFunction;

public class Day {
    Integer numberDay;
    List<Activity>activities = new ArrayList<Activity>();

    public void addActivity(Activity activity){
        if(nonOverlapping(activity)){
            activities.add(activity);
        }
    }

    public Boolean nonOverlapping(Activity activity){
        return activities.stream().allMatch(t->t.nonOverlapping(activity));
    }

    public void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public Double getDurationOfActivies(){
        return activities.stream().mapToDouble(t->t.getDuration()).average().getAsDouble();
    }

    public double getCost(){
        return activities.stream().mapToDouble(t->t.cost).sum();
    }    

    public Boolean atLeastOneActivity(){
        return activities.size() >= 1;
    }

    public String difficulty(){
        Integer lowAmount = amountOfDifficulty("LOW");
        Integer midAmount = amountOfDifficulty("MID");
        Integer highAmount = amountOfDifficulty("HIGH");
        return DifficultyFunction.calculateDifficulty(lowAmount,midAmount,highAmount);
    }

    public Integer amountOfDifficulty(String s){
        return (int)activities.stream().filter(t->t.dificulty == s).count();
    }
}