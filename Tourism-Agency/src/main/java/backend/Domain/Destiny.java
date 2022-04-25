package backend.Domain;

import java.util.Objects;

public class Destiny {
    public Destiny(String name_, String country_, String city_, Double baseCost_){
        name = name_;
        Objects.requireNonNull(country_, "country can't be null");
        country = country_;
        Objects.requireNonNull(city_, "city can't be null");
        city = city_;
        if(baseCost_ > 0){baseCost = baseCost_;}
    }
    
    public String name;
    public String country;
    String city;
    public Double baseCost;

    public Double cost(User user) {
        return baseCost * isLocal(user);
    }

    public Double isLocal(User user) {
        return (country == "Argentina") ? 1.2 : 1.0 - ((user.residenceCountry == country) ? ((user.antiquity>15) ? 15.0: user.antiquity) * 0.01 : 0);
    }
}
