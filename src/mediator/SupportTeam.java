package mediator;

public class SupportTeam {
    public void prepareRunway() {
        System.out.println("Equipe de Apoio: Preparando a pista...");

        try {
            Thread.sleep(2000); // 2 segundos
        } catch (InterruptedException e) {
            System.out.println("Equipe de Apoio: Preparação interrompida.");
            Thread.currentThread().interrupt();
        }
        System.out.println("Equipe de Apoio: A pista está pronta.");
    }

    public void inspectRunway() {
        System.out.println("Equipe de Apoio: Realizando inspeção na pista...");

        try {
            Thread.sleep(1000); // 1 segundo
        } catch (InterruptedException e) {
            System.out.println("Equipe de Apoio: Inspeção interrompida.");
            Thread.currentThread().interrupt();
        }
        System.out.println("Equipe de Apoio: Inspeção concluída.");
    }
}
