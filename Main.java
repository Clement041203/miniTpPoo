// Classe principale pour tester le fonctionnement du design pattern
public class Main {
    public static void main(String[] args) {
        // Création des cellules
        Cell emptyCell1 = new EmptyCell();
        Cell emptyCell2 = new EmptyCell();
        Cell occupiedCell = new OccupiedCell();
        
        // Configuration de la chaîne de responsabilité
        emptyCell1.setNext(emptyCell2);
        emptyCell2.setNext(occupiedCell);
        
        // Test de la chaîne
        Item fruit = new Item("Fruit");
        Item dot = new Item("Dot");
        Item ghost = new Item("Ghost");
        Item pacman = new Item("Pacman");

        emptyCell1.handleRequest(fruit);
        emptyCell1.handleRequest(dot);
        emptyCell1.handleRequest(ghost);
        emptyCell1.handleRequest(pacman);
    }
}
