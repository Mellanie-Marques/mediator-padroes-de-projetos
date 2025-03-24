package mediator;

import iterator.FlightFila;

public interface ATCMediator {
    void registerRunway(Runway runway);

    void registerFlight(Flight flight);

    boolean isLandingOk();

    void setLandingStatus(boolean status);

    // adicionando suporte à fila de espera
    void addFlightToFila(Flight flight);

    void processNextFlight();


    void setRunwayStatus(boolean status);

    void notifyRunwayAvailable();

    void requestLanding(Flight flight);

    void requestTakeOff(Flight flight);

    boolean isTakeOffOk();

    void setTakeOffStatus(boolean status);
}
