package backend.Domain;

import java.util.NoSuchElementException;


abstract class Criteria {
    abstract boolean canMakeItinerary(User user, Itinerary itinerary);
}

class Relaxed extends Criteria{

    @Override
    boolean canMakeItinerary(User user, Itinerary itinerary) {
        return true;
    }
}

class Cautious extends Criteria{

    @Override
    boolean canMakeItinerary(User user, Itinerary itinerary) {
        return (user.knowsADestiny(itinerary.destiny) || user.friends.stream().anyMatch(t -> t.knowsADestiny(itinerary.destiny)));
    }
}

class Parochial extends Criteria{

    @Override
    boolean canMakeItinerary(User user, Itinerary itinerary) {
        return itinerary.destiny.country == "Argentina";
    }
}

class Dreamer extends Criteria{

    @Override
    boolean canMakeItinerary(User user, Itinerary itinerary) {
        return (user.wishListDestiny.stream().anyMatch(t -> t.name == itinerary.destiny.name) || itinerary.destiny.cost(user) > user.wishListDestiny.stream().mapToDouble(t -> t.cost(user)).max().orElseThrow(NoSuchElementException::new));
    }
}

class Active extends Criteria{

    @Override
    boolean canMakeItinerary(User user, Itinerary itinerary) {
        return itinerary.oneActivityPerDay();
    }    
}

class Demanding extends Criteria{
    String difficulty;
    Double porcentualOFDifficulty;

    @Override
    boolean canMakeItinerary(User user, Itinerary itinerary) {
            return ((itinerary.activiesAmount() - itinerary.amountOfActivitiesWithSpecificDifficulty(difficulty)) /itinerary.activiesAmount() * 100) >= porcentualOFDifficulty;
    }
}