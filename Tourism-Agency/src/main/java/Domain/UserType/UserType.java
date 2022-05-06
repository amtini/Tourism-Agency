package Domain.UserType;

import backend.Domain.User;
import backend.Domain.Vehicule;

public abstract class UserType{
    public abstract Boolean likeVehicule(User u, Vehicule v);
}