package backend.Criteria;

import backend.Domain.Itinerary;
import backend.Domain.User;

public class Active extends Criteria{

    @Override
    public boolean canMakeItinerary(User user, Itinerary itinerary) {
        return itinerary.oneActivityPerDay();
    }   
}
