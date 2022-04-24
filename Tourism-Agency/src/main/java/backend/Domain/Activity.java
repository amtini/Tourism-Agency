package backend.Domain;

import java.util.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Activity {
    Activity(Double cost_, String description_, Date startSchedule_, Date finishSchedule_, String dificulty_){
        if(cost_ >= 0){
            cost = cost_;
        }

        Objects.requireNonNull(description_, "description can't be null");
        
        if(finishSchedule_.compareTo(startSchedule_) > 0){
            startSchedule = startSchedule_;
            finishSchedule = finishSchedule_;
        }

        if(dificulty_ == "BAJA" || dificulty_ == "MEDIA" || dificulty_ == "ALTA"){
            dificulty = dificulty_;
        }
    }

    Double cost;
    String description;
    Date startSchedule;
    Date finishSchedule;
    Double duration;
    String dificulty;

    public double getDuration(){
        return (double)TimeUnit.MILLISECONDS.toMinutes(finishSchedule.getTime() - startSchedule.getTime());
    }

    public Boolean nonOverlapping(Activity activity) {
        int s1 = startSchedule.compareTo(activity.startSchedule);
        int s2 = startSchedule.compareTo(activity.finishSchedule);
        int f1 = finishSchedule.compareTo(activity.startSchedule);
        int f2 = finishSchedule.compareTo(activity.finishSchedule);
        return (s1 > 0 && s2 > 0) || (f1 < 0 && f2 < 0);
    }
}