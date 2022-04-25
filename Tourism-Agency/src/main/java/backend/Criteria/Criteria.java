package backend.Criteria;

import backend.Domain.Itinerary;
import backend.Domain.User;

public abstract class Criteria {
    public abstract boolean canMakeItinerary(User user, Itinerary itinerary);
}