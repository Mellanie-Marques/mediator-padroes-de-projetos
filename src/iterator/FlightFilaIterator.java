package iterator;

import mediator.Flight;
import java.util.List;

// iterator para percorrer a fila

public class FlightFilaIterator implements FlightIterator {
    private List<Flight> flights;
    private int position = 0;

    public FlightFilaIterator(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean hasNext() {
        return position < flights.size();
    }

    @Override
    public Flight next() {
        return hasNext() ? flights.get(position++) : null;
    }
}
