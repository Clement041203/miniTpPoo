import java.util.ArrayList;
import java.util.List;

// Interface IPositionnable
interface IPositionnable {
    void moveTo(int x, int y);
}

// Interface IRenderable
interface IRenderable {
    String render();
}

// Classe abstraite Item
abstract class Item implements IPositionnable, IRenderable {
    protected int x;
    protected int y;

    public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// Classe Pacman
class Pacman extends Item {
    public Pacman(int x, int y) {
        super(x, y);
    }

    @Override
    public String render() {
        return "@";
    }
}

// Classe Fruit
class Fruit extends Item {
    public Fruit(int x, int y) {
        super(x, y);
    }

    @Override
    public String render() {
        return "*";
    }
}

// Classe Ghost
class Ghost extends Item {
    public Ghost(int x, int y) {
        super(x, y);
    }

    public String render() {
        return "$";
    }
}

class MarioBross {

    public void display() {
        System.out.println("Displaying MarioBross");
    }

    public void goTo(int x, int y) {
        System.out.println("Moving MarioBross to position: (" + x + ", " + y + ")");
    }
}

class MarioBrossAdapter extends Item {
    private MarioBross marioBross;

    public MarioBrossAdapter(MarioBross marioBross, int x, int y) {
        super(x, y);
        this.marioBross = marioBross;
    }

    public String render() {
        return "M";
    }

    public void display() {
        marioBross.display();
    }

    public void goTo(int x, int y) {
        marioBross.goTo(x, y);
    }
}

// Classe GameBoard pour générer la vue du jeu
class GameBoard {
    private List<Item> items;

    public GameBoard() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void renderBoard() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.render());
        }
        System.out.println(sb.toString());
    }
}
