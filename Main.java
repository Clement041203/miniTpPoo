public class Main {
    public static void main(String[] args) {
        Pacman pacman = new Pacman();
        Ghost shadow = new Ghost("Shadow");
        Ghost speedy = new Ghost("Speedy");
        Ghost bashful = new Ghost("Bashful");
        Ghost pokey = new Ghost("Pokey");

        pacman.addObserver(shadow);
        pacman.addObserver(speedy);
        pacman.addObserver(bashful);
        pacman.addObserver(pokey);

        pacman.moveTo(Direction.North);
        pacman.moveTo(Direction.East);
    }
}