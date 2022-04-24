package backend.Domain;

import java.nio.file.WatchService;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;

import javax.swing.plaf.metal.MetalFileChooserUI.FilterComboBoxRenderer;

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

//FIX
class Dreamers extends Criteria{

    @Override
    boolean canMakeItinerary(User user, Itinerary itinerary) {
        return (user.wishListDestiny.stream().anyMatch(t -> t.name == itinerary.destiny.name) || itinerary.destiny.cost(user) > user.wishListDestiny.stream().map(t -> t.cost(user)).max(Comparator<Double>.comparing(Double::valueOf).get()));
    }
}