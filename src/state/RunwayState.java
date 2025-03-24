package state;

import mediator.Runway;

// define os métodos para os estados

public interface RunwayState {
    void land(Runway runway);
    void freeRunway(Runway runway);
}
