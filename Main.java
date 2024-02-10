public class Main {
    public static void main(String[] args) {
        // Création du plateau de jeu
        GameBoard gameBoard = new GameBoard();

        // Ajout des différents objets du jeu Pacman au plateau
        Pacman pacman = new Pacman(0, 0);
        Fruit fruit = new Fruit(5, 0);
        Ghost ghost = new Ghost(10, 0);
        gameBoard.addItem(pacman);
        gameBoard.addItem(fruit);
        gameBoard.addItem(ghost);

        // Utilisation de l'adapter pour intégrer MarioBross
        MarioBross marioBross = new MarioBross();
        MarioBrossAdapter marioBrossAdapter = new MarioBrossAdapter(marioBross, 0, 0);
        gameBoard.addItem(marioBrossAdapter);

        // Affichage du plateau de jeu
        gameBoard.renderBoard();
    }
}
