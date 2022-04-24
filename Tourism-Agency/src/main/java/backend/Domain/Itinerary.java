package backend.Domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Stream;

public class Itinerary {
    Itinerary(User owner_,Destiny destiny_){
        Objects.requireNonNull(owner_, "Owner can't be null");
        Objects.requireNonNull(destiny_, "Destiny can't be null");
    }

    User owner;
    Destiny destiny;
    String dificulty;

    List<Day> days = new ArrayList<Day>();
    Set<Calification> califications = new HashSet<Calification>();


    

    public double getCost(User user){
        return days.stream().mapToDouble(t->t.getCost()).sum() + destiny.cost(user);
    }

    public boolean canUserUtilizeItinerary(User user){
        return user.vacationDays > daysAmount() || user.criteria.canMakeItinerary(user, this);
    }

    //Validators
    public Boolean minAmountActivities(){
        return activiesAmount() > 1;
    }

    //TO DOO
    public Boolean nonOverlapping(){
        return days.stream().anyMatch(t->t.overlappingActivities)
    }

    public Boolean validCalification(Integer v){
        return (v >=1 || v <= 10);
    }

    public Boolean userNotInCalification(User u){
        return !califications.stream().anyMatch(t->t.user == u);
    }

    //Calification list interactions
    public void addCalification(User u,Integer v){
        if(validCalification(v) && userNotInCalification(u) && u != owner && u.visitedPlace(destiny)){ califications.add(new Calification(u,v)); }
    }

    public void removeCalification(User u, Integer v){
        List<Calification> temporalList = new ArrayList<Calification>();
        califications.stream().filter(t->(t.user == u && t.calificationNumber == v)).forEach(t->temporalList.add(t));

        califications.removeAll(temporalList);
    }

    //Day list interactions
    public void addDay(Day day){
        days.add(day);
    }

    public void removeDay(Day day){
        days.add(day);
    }

    public Integer daysAmount(){
        return days.size();
    }

    public Integer activiesAmount(){
        return days.stream().mapToInt(t->t.activities.size()).sum();
    }

    public Double getDurationOfActivies(){
        return days.stream().mapToDouble(t->t.getDurationOfActivies()).average().getAsDouble();
    }

    //TO DOOO
    public String getDificulty() {
        return "123";
    }
}