import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestUnitaire {

    @Test
    void testParkAndRepairCar() {
        Garage garage = new Garage();
        Car car1 = new Car("AB-123-CD", 4, 4);
        Car car2 = new Car("XY-456-ZZ", 4, 4);

        // Park car1
        garage.park(car1);
        assertTrue(garage.getParkedVehicule().contains(car1), "La première voiture doit être dans le garage");

        // Park car2
        garage.park(car2);
        assertTrue(garage.getParkedVehicule().contains(car2), "La deuxième voiture doit être dans le garage");

        // Repair car1
        garage.repair(car1.getImmatriculation());
        assertFalse(garage.getParkedVehicule().contains(car1), "La première voiture doit être retirée du garage après réparation");

        // Tentative de réparation d'une voiture qui n'est pas présente dans le garage, une exception doit être levée
        assertThrows(IllegalArgumentException.class, () -> garage.repair("ZZ-999-AA"), "Une exception doit être levée si la voiture n'est pas dans le garage");
    }

    @Test
    void testParkAndRepairMoto() {
        Garage garage = new Garage();
        Moto moto1 = new Moto("M-001-AB", 2);
        Moto moto2 = new Moto("M-002-CD", 2);

        // Park moto1
        garage.park(moto1);
        assertTrue(garage.getParkedVehicule().contains(moto1), "La première moto doit être dans le garage");

        // Park moto2
        garage.park(moto2);
        assertTrue(garage.getParkedVehicule().contains(moto2), "La deuxième moto doit être dans le garage");

        // Repair moto1
        garage.repair(moto1.getImmatriculation());
        assertFalse(garage.getParkedVehicule().contains(moto1), "La première moto doit être retirée du garage après réparation");

        // Tentative de réparation d'une moto qui n'est pas présente dans le garage, une exception doit être levée
        assertThrows(IllegalArgumentException.class, () -> garage.repair("M-999-ZZ"), "Une exception doit être levée si la moto n'est pas dans le garage");
    }

    @Test
    void testInvalidImmatriculation() {
        // Tentative de création d'une voiture avec une immatriculation invalide, une exception doit être levée
        assertThrows(IllegalArgumentException.class, () -> new Car("Immatriculation Invalide", 4, 4), "Une exception doit être levée pour une immatriculation invalide");
    }

    @Test
    void testSetImmatriculation() {
        // Création d'une voiture avec une immatriculation initiale
        Car car = new Car("AB-123-CD", 4, 4);


        // Utilisation du setter pour définir une nouvelle immatriculation
        car.setImmatriculation("XY-789-ZZ");
        assertEquals("XY-789-ZZ", car.getImmatriculation(), "La nouvelle immatriculation doit être définie correctement");

        // Tentative d'utiliser le setter avec une immatriculation invalide doit lever une exception
        assertThrows(IllegalArgumentException.class, () -> car.setImmatriculation("Immatriculation Invalide"), "Une exception doit être levée pour une immatriculation invalide");
    }

    @Test
    void testCarStartAndStop() {
        Car car = new Car("AB-123-CD", 4, 4);

        assertEquals(Car.State.PARKED, car.getState(), "L'état initial doit être PARKED");

        car.start();
        assertEquals(Car.State.DRIVING, car.getState(), "L'état doit être DRIVING après le démarrage");

        car.stop();
        assertEquals(Car.State.PARKED, car.getState(), "L'état doit être PARKED après l'arrêt");
    }

    @Test
    void testGarageParkInvalidState() {
        Garage garage = new Garage();
        Car car = new Car("AB-123-CD", 4, 4);

        // Tentez de garer une voiture en état "DRIVING", une exception doit être levée
        car.start();
        assertThrows(IllegalStateException.class, () -> garage.park(car), "Une exception doit être levée si la voiture n'est pas en état de stationnement");
    }

}
