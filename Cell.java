// Classe abstraite représentant une cellule
abstract class Cell {
    protected Cell nextCell;

    public void setNext(Cell nextCell) {
        this.nextCell = nextCell;
    }

    // Méthode abstraite pour gérer la demande de placement d'un élément
    public abstract void handleRequest(Item item);
}

// Classe représentant une cellule vide
class EmptyCell extends Cell {
    @Override
    public void handleRequest(Item item) {
        System.out.println(item + " placed at this cell.");
    }
}

// Classe représentant une cellule occupée
class OccupiedCell extends Cell {
    @Override
    public void handleRequest(Item item) {
        System.out.println("Cell is occupied. Passing request to the next cell.");
        if (nextCell != null) {
            nextCell.handleRequest(item);
        } else {
            System.out.println("End of the chain reached. Cannot place the item.");
        }
    }
}

// Classe représentant un item du jeu Pacman
class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

