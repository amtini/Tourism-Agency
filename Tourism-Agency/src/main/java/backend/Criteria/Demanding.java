package backend.Criteria;

import backend.Domain.Itinerary;
import backend.Domain.User;

public class Demanding extends Criteria{
    String difficulty;
    Double porcentualOFDifficulty;

    @Override
    public boolean canMakeItinerary(User user, Itinerary itinerary) {
            return ((itinerary.activiesAmount() - itinerary.amountOfActivitiesWithSpecificDifficulty(difficulty)) /itinerary.activiesAmount() * 100) >= porcentualOFDifficulty;
    }
}
