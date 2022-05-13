package backend.UserType;

import backend.Domain.User;
import backend.Domain.Vehicule;

public class Selective extends UserType{
    String preferedBrand;
    @Override
    public Boolean likeVehicule(User u, Vehicule v) {
        return v.brand == preferedBrand;
    }
    
}
