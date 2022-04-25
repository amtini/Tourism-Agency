package backend.Criteria;

import backend.Domain.Itinerary;
import backend.Domain.User;

public class Relaxed extends Criteria{

    @Override
    public boolean canMakeItinerary(User user, Itinerary itinerary) {
        return true;
    }
}