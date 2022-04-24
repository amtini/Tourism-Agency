package backend.Domain;

import java.time.LocalDateTime;
import java.util.Objects;

import backend.Functions.DateFunctions;

public class Activity {
    Activity(Double cost_, String description_, LocalDateTime startSchedule_, LocalDateTime finishSchedule_, String dificulty_){
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
    LocalDateTime startSchedule;
    LocalDateTime finishSchedule;
    Double duration;
    String dificulty;

    //TO DO
    public Integer getDuration(){
        return DateFunctions.getMinutesOfDay(finishSchedule) - DateFunctions.getMinutesOfDay(startSchedule);
        
    }
}