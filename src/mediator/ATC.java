package mediator;

import iterator.FlightFila;
import iterator.FlightIterator;
import java.util.ArrayList;
import java.util.List;

public class ATC implements ATCMediator {
    private Runway runway;
    private FlightFila flightFila = new FlightFila(); // Fila de voos usando Iterator
    private SupportTeam supportTeam = new SupportTeam(); // Equipe de apoio
    private List<Flight> waitingTakeOffFlights = new ArrayList<>(); // Fila de decolagem

    @Override
    public void registerRunway(Runway runway) {
        this.runway = runway;
    }

    @Override
    public void registerFlight(Flight flight) {
        addFlightToFila(flight); // Adiciona o voo à fila de espera
    }

    @Override
    public boolean isLandingOk() {
        return runway.isAvailable(); // Verifica se a pista está disponível
    }

    @Override
    public void setLandingStatus(boolean status) {
        if (this.runway != null) {
            this.runway.setAvailable(status);
            if (status) {
                System.out.println("Pista liberada.");
                runway.freeRunway();
            }
        } else {
            System.out.println("A pista não foi inicializada.");
        }
    }

    @Override
    public void addFlightToFila(Flight flight) {
        flightFila.addFlight(flight); // Adiciona o voo à fila de espera
    }

    @Override
    public void processNextFlight() {
        FlightIterator iterator = flightFila.getIterator();
        if (iterator.hasNext() && isLandingOk()) {
            Flight nextFlight = iterator.next();
            nextFlight.land();
            flightFila.removeFlight(nextFlight); // Remove o voo da fila após o pouso
        } else {
            System.out.println("Nenhum voo pode pousar agora.");
        }
    }

    @Override
    public void setRunwayStatus(boolean status) {
        runway.setAvailable(status);
        if (status) {
            notifyRunwayAvailable(); // Notifica que a pista está disponível
        } else {
            supportTeam.prepareRunway(); // Notifica a equipe de apoio para preparar a pista
        }
    }

    @Override
    public void notifyRunwayAvailable() {
        try {
            FlightIterator iterator = flightFila.getIterator();
            if (iterator.hasNext()) {
                Flight nextFlight = iterator.next();
                runway.setAvailable(false);
                nextFlight.land();
                flightFila.removeFlight(nextFlight); // Remove o voo da fila após o pouso
            } else if (!waitingTakeOffFlights.isEmpty()) {
                Flight nextFlight = waitingTakeOffFlights.remove(0);
                runway.setAvailable(false);
                nextFlight.takeOff();
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao notificar a disponibilidade da pista.");
            e.printStackTrace();
        }
    }

    @Override
    public void requestLanding(Flight flight) {
        if (isLandingOk()) {
            flight.land();
        } else {
            addFlightToFila(flight); // Adiciona o voo à fila de espera
            System.out.println("Flight " + flight.getFlight() + " adicionado à fila de desembarque.");
        }
    }

    @Override
    public void requestTakeOff(Flight flight) {
        if (isTakeOffOk()) {
            flight.takeOff();
        } else {
            waitingTakeOffFlights.add(flight); // Adiciona o voo à fila de decolagem
            System.out.println("Flight " + flight.getFlight() + " adicionado à fila de decolagem.");
        }
    }

    @Override
    public boolean isTakeOffOk() {
        return isLandingOk();
    }

    @Override
    public void setTakeOffStatus(boolean status) {
        runway.setAvailable(status);
    }
}