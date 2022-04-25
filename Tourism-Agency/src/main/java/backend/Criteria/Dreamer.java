package backend.Criteria;

import java.util.NoSuchElementException;

import backend.Domain.Itinerary;
import backend.Domain.User;

public class Dreamer extends Criteria{

    @Override
    public boolean canMakeItinerary(User user, Itinerary itinerary) {
        return (user.wishListDestiny.stream().anyMatch(t -> t.name == itinerary.destiny.name) || itinerary.destiny.cost(user) > user.wishListDestiny.stream().mapToDouble(t -> t.cost(user)).max().orElseThrow(NoSuchElementException::new));
    }
}
