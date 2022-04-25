package backend.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import backend.Criteria.Criteria;

public class User {
    public User(String name_, String lastName_, String userName_, Date upDate_, String residenceCountry_, Integer vacationDays_, Criteria criteria_){
        Objects.requireNonNull(name_, "Name can't be null");
        Objects.requireNonNull(lastName_, "LastName can't be null");
        Objects.requireNonNull(userName_, "UserName can't be null");
        Objects.requireNonNull(residenceCountry_, "Residence Country can't be null");
        name = name_;
        lastName = lastName_;
        userName = userName_;
        if(new Date().compareTo(upDate_) > 0) {
            upDate = upDate_;
        }
        residenceCountry = residenceCountry_;
        if(vacationDays_ > 0){ vacationDays = vacationDays_;}
    }

    String name;
    String lastName;
    String userName;
    Date upDate;
    public String residenceCountry;
    Double antiquity;
    Integer vacationDays;
    Criteria criteria;

    public List<User> friends = new ArrayList<User>();

    public List<Destiny> wishListDestiny = new ArrayList<Destiny>();

    List<Destiny> visitedPlaces = new ArrayList<Destiny>();

    public boolean knowsADestiny(Destiny destiny){
        return (wishListDestiny.stream().anyMatch(t -> t.name == destiny.name) || visitedPlaces.stream().anyMatch(t -> t.name == destiny.name));
    }

    public Integer getAntiquity() {
        return (int)TimeUnit.MILLISECONDS.toDays(new Date().getTime() - upDate.getTime()) / 365;
    }

    public Boolean canMakeItinerary(Itinerary itinerary){
        return criteria.canMakeItinerary(this, itinerary);
    }

    public void changeCriteria(Criteria c){
        criteria = c;
    }

    //Validators

    public Boolean atLeastOneWishListDestinty(){
        return wishListDestiny.size() >= 1;
    }

    public Boolean visitedPlace(Destiny d){
        return visitedPlaces.stream().anyMatch(t->t == d);
    }
}

