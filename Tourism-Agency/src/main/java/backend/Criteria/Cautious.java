package backend.Criteria;

import backend.Domain.Itinerary;
import backend.Domain.User;

public class Cautious extends Criteria{

    @Override
    public boolean canMakeItinerary(User user, Itinerary itinerary) {
        return (user.knowsADestiny(itinerary.destiny) || user.friends.stream().anyMatch(t -> t.knowsADestiny(itinerary.destiny)));
    }
}