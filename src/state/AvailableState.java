package state;

import mediator.Runway;

// quando a pista está disponível para pouso

public class AvailableState implements RunwayState {

    @Override
    public void land(Runway runway) {
        System.out.println("Pista disponível. Pouso autorizado.");
        runway.setState(new BusyState()); // altera para ocupada
    }

    @Override
    public void freeRunway(Runway runway) {
        System.out.println("A pista já está disponível.");
    }
}
