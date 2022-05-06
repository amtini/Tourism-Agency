package Domain.UserType;

import backend.Domain.User;
import backend.Domain.Vehicule;

public class Neophyte extends UserType{

    @Override
    public Boolean likeVehicule(User u, Vehicule v) {
        return v.getAntiquity() < 2;
    }
    
}