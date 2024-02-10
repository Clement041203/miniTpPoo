public class Car extends Vehicule {
        private final int numberOfDoors;

    public Car(String immatriculation, int numberOfSeats, int numberOfDoors) {
        super(immatriculation, numberOfSeats);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

}
