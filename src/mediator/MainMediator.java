package mediator;

public class MainMediator {
    public static void main(String[] args) {
        ATCMediator atcMediator = new ATC();
        Runway mainRunway = new Runway(atcMediator);

        Flight f1 = new Flight(atcMediator, "LATAM", "LA4542");
        Flight f2 = new Flight(atcMediator, "GOL", "GL1273");

        atcMediator.registerFlight(f1);
        atcMediator.registerFlight(f2);
        atcMediator.registerRunway(mainRunway);

        System.out.println(">> Contato das aeronaves....");
        f1.getReady();
        f2.getReady();
        System.out.println();

        System.out.println(">> Consultando situacao da pista....");
        mainRunway.land(); // pouso autorizado
        System.out.println();

        f1.land();
        mainRunway.land(); // libera para o próximo avião

        f2.land();
        System.out.println();

        System.out.println(">> Tentando outro pouso...");
        mainRunway.land(); // agora deve recusar
        System.out.println();

        System.out.println(">> Finalizando inspeção...");
        mainRunway.freeRunway(); // Agora pode pousar de novo
        System.out.println();

        System.out.println(">> Liberando pista...");
        mainRunway.freeRunway(); // agora precisa de inspeção
        System.out.println();

        System.out.println(">> Novo pouso...");
        mainRunway.land(); // Agora pode pousar
    }
}