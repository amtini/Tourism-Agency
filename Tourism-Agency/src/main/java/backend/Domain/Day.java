package backend.Domain;

import java.util.ArrayList;
import java.util.List;
/*import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;*/

public class Day {
    Integer numberDay;
    List<Activity>activities = new ArrayList<Activity>();

    public void addActivity(Activity activity){
        activities.add(activity);
    }

    public void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public Double getDurationOfActivies(){
        return activities.stream().mapToDouble(t->t.getDuration()).average().getAsDouble();
    }

    //TO DOOO
    /*public Map<Object, Long> getDificulty(){
        return activities.stream().collect(Collectors.toMap(t->t.dificulty, 1 ,Long::sum));
    }*/

    public double getCost(){
        return activities.stream().mapToDouble(t->t.cost).sum();
    }

    //Validators
    
}