package mediator;

/**
 * Componente 1: Flight (representa um vôo de uma empresa aérea)
 * @author alexs
 *
 */
public class Flight implements Command {
    private ATCMediator atcMediator = null;
    private String flightNumber = null;
    private String airline = null;



    public Flight(ATCMediator atcMediator, String airline, String flight ) {
        this.atcMediator = atcMediator;
        this.flightNumber = flight;
        this.airline = airline;
    }

    @Override
    public void land() {
        if (atcMediator.isLandingOk()) {
            System.out.println("Voo " + flightNumber + " Aterrissado com sucesso.");
            atcMediator.setLandingStatus(false); //a pista agora está ocupada
            //atcMediator.processNextFlight(); // processa o próximo avião
        } else
            System.out.println("Voo " + flightNumber + " aguardando pista.");
    }

    public void getReady() {
        System.out.println("Voo " + this.flightNumber + " da " + this.airline + " solicitando autorizacao para pouso...");
        atcMediator.addFlightToFila(this); // adiciona o voo à fila de espera
        atcMediator.processNextFlight(); // verifica se pode pousar
    }

    public String getFlight() {
        return this.flightNumber;
    }


    public void takeOff() {
    }
}
