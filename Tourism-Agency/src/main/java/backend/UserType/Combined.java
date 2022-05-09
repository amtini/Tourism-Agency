package Domain.UserType;

import java.util.ArrayList;
import java.util.List;

import backend.Domain.User;
import backend.Domain.Vehicule;

public class Combined extends UserType{

    List<UserType> userTypes = new ArrayList<UserType>();

    public void addUserType(UserType ut){
        if(!userTypes.contains(ut)){
            userTypes.add(ut);
        }
    }

    public void removeUserType(UserType ut){
        userTypes.remove(ut);
    }

    @Override
    public Boolean likeVehicule(User u, Vehicule v) {
        return (userTypes.size() >= 2) ? userTypes.stream().allMatch(t -> t.likeVehicule(u, v)) : false;
    }
}
