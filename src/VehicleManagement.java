import java.util.ArrayList;

/**
 * Created by kylel on 10/20/2015.
 */
public class VehicleManagement {

    private int maxBus;
    private int bus;
    private int maxPlane;
    private int plane;
    private ArrayList<Vehicle> vehicles;

    public VehicleManagement (int bus, int plane) {
        this.maxBus = bus;
        this.maxPlane = plane;
        this.bus = 0;
        this.plane = 0;
        this.vehicles = new ArrayList<>();
    }

    public boolean createRoute (Route route, int capacity) {
        if (route != null) {
            if (lookupVehicle(route) == -1) {
                if (getAvailableBus() > 0) {
                    bus++;
                    Bus b = new Bus(route, capacity);
                    vehicles.add(b);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean addPassengerToVehicle(Passenger person) {
        if (person != null) {
            if (lookupVehicle(person.getRoute()) != -1) {
                Vehicle temp = vehicles.get(lookupVehicle(person.getRoute()));
                if (getAvailablePlane() > 0) {
                    if (temp.addPassenger(person)) {
                        if (temp instanceof Bus) {
                            if (((Bus) temp).isReadyForUpgrade()) {
                                bus--;
                                plane++;
                                vehicles.add(temp.upgrade(temp.getCapacity() * 3));
                                vehicles.remove(lookupVehicle(person.getRoute()));
                                return true;
                            } else {
                                return true;
                            }
                        } else {
                            return true;
                        }
                    }
                } else {
                    if (temp.addPassenger(person, false)) {
                        return true;
                    }
                }
            }
            person.cancel();
        }
        return false;
    }

    public Vehicle[] getVehicles() {
        Vehicle[] tmp = new Vehicle[this.vehicles.size()];
        tmp = this.vehicles.toArray(tmp);
        return tmp;
    }

    public int getCount() {
        return vehicles.size();
    }

    public int getAvailableBus() {
        return maxBus - bus;
    }

    public int getAvailablePlane() {
        return maxPlane - plane;
    }

    public int lookupVehicle (Route route) {
        if (route != null) {
            for (int i = 0; i < vehicles.size(); i++) {
                if (vehicles.get(i).getRoute().equals(route)) {
                    return i;
                }
            }
        }
        return -1;
    }
}

