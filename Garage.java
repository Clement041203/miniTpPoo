import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Vehicule> parkedVehicule;

    public Garage() {
        this.parkedVehicule = new ArrayList<>();
    }

    public void park(Vehicule unVehicule) {
        // Vérifie si la voiture est en état PARKED avant de la garer
        if (unVehicule.getState() != Vehicule.State.PARKED) {
            throw new IllegalStateException("La voiture doit être en état de stationnement pour être garée.");
        }

        parkedVehicule.add(unVehicule);
    }

    public void repair(String immatriculation) {
        Vehicule vehiculeToRemove = null;
        for (Vehicule unVehicule : parkedVehicule) {
            if (unVehicule.getImmatriculation().equals(immatriculation.toUpperCase())) {
                vehiculeToRemove = unVehicule;
                break;
            }
        }

        if (vehiculeToRemove != null) {
            parkedVehicule.remove(vehiculeToRemove);
        } else {
            throw new IllegalArgumentException("La voiture n'est pas présente dans le garage");
        }
    }

    public ArrayList<Vehicule> getParkedVehicule() {
        return new ArrayList<>(parkedVehicule);
    }
}
