package backend.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;

public class Itinerary {
    Itinerary(User owner_,Destiny destiny_){
        Objects.requireNonNull(owner_, "Owner can't be null");
        Objects.requireNonNull(destiny_, "Destiny can't be null");
    }

    User owner;
    Destiny destiny;
    String dificulty;

    List<Day> days = new ArrayList<Day>();

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

    public OptionalDouble getDurationOfActivies(){
        return days.stream().mapToInt(t->t.getDurationOfActivies()).average();
    }

    //TO DOOO
    public String getDificulty() {
        return "123";
    }

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
}