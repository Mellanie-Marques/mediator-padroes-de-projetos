package mediator;

import state.RunwayState;
import state.AvailableState;
import state.UnsafeState;

public class Runway implements Command {
    private RunwayState state;

    public Runway(ATCMediator atcMediator) {
        this.state = new AvailableState(); // começa disponível
    }

    public void setState(RunwayState state) {
        this.state = state;
    }

    @Override
    public void land() {
        state.land(this); // delega a ação ao estado atual
    }

    public void freeRunway() {
        state.freeRunway(this); // libera a pista
    }

    public void setAvailable(boolean b) {
        if (b) {
            this.setState(new AvailableState()); // Define o estado como disponível
            System.out.println("A pista está disponível.");
        } else {
            this.setState(new UnsafeState()); // Define o estado como indisponível
            System.out.println("A pista está indisponível.");
        }
    }

    public boolean isAvailable() {
        return state instanceof AvailableState;
    }
}