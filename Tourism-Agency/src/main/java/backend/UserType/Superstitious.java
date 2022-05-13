package backend.UserType;

import backend.Domain.User;
import backend.Domain.Vehicule;

public class Superstitious extends UserType{

    @Override
    public Boolean likeVehicule(User u, Vehicule v) {
        return (v.yearOfFabrication %2) == 0;
    }
    
}
