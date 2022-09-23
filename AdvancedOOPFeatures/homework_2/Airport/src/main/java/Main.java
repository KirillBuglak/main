import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        findPlanesLeavingInTheNextTwoHours(airport);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        long inTwoHours = System.currentTimeMillis() + 7200000;
        List<Flight> list = new ArrayList<>();

        airport.getTerminals().stream().flatMap(e -> e.getFlights().stream())
                .filter(e -> e.getDate().getTime() <= inTwoHours &&
                        e.getDate().getTime() >= System.currentTimeMillis() &&
                        e.getType() == Flight.Type.DEPARTURE)
                .forEach(list::add);
        return list;
    }
}