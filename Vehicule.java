import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  abstract class Vehicule  {
   private String immatriculation;
    private State state;
   private final int numberOfSeats;
   private int currentSpeed;
   private int numberOfSpeed;


    public Vehicule(String immatriculation, int numberOfSeats ){
        validateImmatriculation(immatriculation);
        this.immatriculation = immatriculation.toUpperCase();
        this.state = State.PARKED;
        this.numberOfSeats = numberOfSeats;
        this.currentSpeed = 0;
    }


    private void validateImmatriculation(String immatriculation) {
        String pattern = "^[A-Z]{2}-\\d{3}-[A-Z]{2}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(immatriculation);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Immatriculation invalide");
        }
    }

    public String getImmatriculation()   {
        return immatriculation;
    }
    public void setImmatriculation(String immatriculation) {
        validateImmatriculation(immatriculation);
        this.immatriculation = immatriculation.toUpperCase();
    }

    public State getState() {
        return state;
    }

    public void start() {
        if (state == State.PARKED) {
            state = State.DRIVING;
            currentSpeed = 1;
        } else {
            throw new IllegalStateException("La voiture ne peut pas démarrer car elle n'est pas garée.");
        }
    }

    public void stop() {
        if (state == State.DRIVING) {
            state = State.PARKED;
            currentSpeed = 0;
        } else {
            throw new IllegalStateException("La voiture ne peut pas s'arrêter car elle n'est pas en mouvement.");
        }
    }

    public enum State {
        PARKED,
        DRIVING
    }

    public int getNumberOfSeats() {

        return numberOfSeats;
    }
}


