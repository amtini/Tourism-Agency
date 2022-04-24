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
}