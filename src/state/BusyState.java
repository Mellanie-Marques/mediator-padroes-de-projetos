package state;

import mediator.Runway;

// quando a pista está ocupada e reservada para um pouso

public class BusyState implements RunwayState {

    @Override
    public void land(Runway runway) {
        System.out.println("Pista ocupada. Aguarde liberação.");
    }

    @Override
    public void freeRunway(Runway runway) {
        System.out.println("A pista foi liberada para inspeção.");
        runway.setState(new UnsafeState()); // Agora precisa ser inspecionada
    }
}
