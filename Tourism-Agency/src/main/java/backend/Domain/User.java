package backend.Domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    User(String name_, String lastName_, String userName_, LocalDateTime upDate_, String residenceCountry_, Integer antiquity_, Integer vacationDays_, Criteria criteria_){
        Objects.requireNonNull(name_, "Name can't be null");
        Objects.requireNonNull(lastName_, "LastName can't be null");
        Objects.requireNonNull(userName_, "UserName can't be null");
        Objects.requireNonNull(residenceCountry_, "Residence Country can't be null");
        name = name_;
        lastName = lastName_;
        userName = userName_;
        if(upDate_.compareTo(LocalDateTime.now()) > 0) {
            upDate_ = upDate;
        }
        residenceCountry = residenceCountry_;
        antiquity = antiquity_;
        if(vacationDays_ > 0){ vacationDays = vacationDays_;}
    }

    String name;
    String lastName;
    String userName;
    LocalDateTime upDate;
    String residenceCountry;
    Integer antiquity;
    Integer vacationDays;
    Criteria criteria;

    List<User> friends = new ArrayList<User>();

    List<Destiny> wishListDestiny = new ArrayList<Destiny>();

    List<Destiny> visitedPlaces = new ArrayList<Destiny>();

    public boolean knowsADestiny(Destiny destiny){
        return (wishListDestiny.stream().anyMatch(t -> t.name == destiny.name) || visitedPlaces.stream().anyMatch(t -> t.name == destiny.name));
        
    }

    public Integer getAntiquity() {
        return LocalDate.now().getYear() - upDate.getYear();
    }

    public Boolean canMakeItinerary(Itinerary itinerary){
        return criteria.canMakeItinerary(this, itinerary);
    }

    //Validators

    public Boolean atLeastOneWishListDestinty(){
        return wishListDestiny.size() >= 1;
    }
}

