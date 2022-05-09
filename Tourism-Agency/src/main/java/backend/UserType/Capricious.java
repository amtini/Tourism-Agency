package Domain.UserType;

import backend.Domain.User;
import backend.Domain.Vehicule;

public class Capricious extends UserType{

    @Override
    public Boolean likeVehicule(User u, Vehicule v) {
        return (v.model.toLowerCase()).subSequence(0, 1) == (v.brand.toLowerCase()).substring(0,1);
    }   
}
