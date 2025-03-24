package state;

import mediator.Runway;

// quando a pista precisa de inspeção antes de ser liberada

public class UnsafeState implements RunwayState {

    @Override
    public void land(Runway runway) {
        System.out.println("Pista insegura! Inspeção necessária antes do pouso.");
    }

    @Override
    public void freeRunway(Runway runway) {
        System.out.println("Inspeção concluída. Pista disponível para novos pousos.");
        runway.setState(new AvailableState()); // agora pode ser usada novamente
    }
}
