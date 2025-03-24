package iterator;

import mediator.Flight;
import java.util.ArrayList;
import java.util.List;

//armazena os voos e fornece um iterator

public class FlightFila {
    private List<Flight> flightList = new ArrayList<>();

    public void addFlight(Flight flight) {
        flightList.add(flight);
    }

    public void removeFlight(Flight flight) {
        flightList.remove(flight);
    }

    public FlightIterator getIterator() {
        return new FlightFilaIterator(flightList);
    }
}
