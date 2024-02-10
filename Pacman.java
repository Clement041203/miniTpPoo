import java.util.ArrayList;
import java.util.List;

// Interface Observer
interface Observer {
    void update(Direction direction);
}

// Subject
class Pacman {
    private List<Observer> observers = new ArrayList<Observer>();
    private Direction currentDirection;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void moveTo(Direction direction) {
        currentDirection = direction;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(currentDirection);
        }
    }
}

// Concrete Observer
class Ghost implements Observer {
    private String name;
    private Direction currentDirection;

    public Ghost(String name) {
        this.name = name;
    }

    @Override
    public void update(Direction direction) {
        currentDirection = direction;
        System.out.println(name + " is moving " + getOppositeDirection(direction));
    }

    private Direction getOppositeDirection(Direction direction) {
        switch (direction) {
            case North:
                return Direction.South;
            case South:
                return Direction.North;
            case East:
                return Direction.West;
            case West:
                return Direction.East;
            default:
                return null;
        }
    }
}

// Enum for directions
enum Direction {
    North, South, East, West
}

