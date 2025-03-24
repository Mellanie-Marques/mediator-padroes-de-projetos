package iterator;

import mediator.Flight;

public interface FlightIterator {
    boolean hasNext();  // retorna se há mais elementos na fila
    Flight next();   // retorna o próximo voo na fila

}
