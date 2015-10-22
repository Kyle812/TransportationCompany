import java.util.ArrayList;

/**
 * Created by kylel on 10/20/2015.
 */
public class Airplane implements Vehicle {

    private Route route;
    private int capacity;
    private int count;
    private ArrayList<Passenger> passengers;

    public Airplane (Route route, int capacity) {
        this.route = route;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
        count = 0;
    }

    @Override
    public Route getRoute() {
        return route;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Passenger[] getPassengers() {
        Passenger[] tmp = new Passenger[this.passengers.size()];
        tmp = this.passengers.toArray(tmp);
        return tmp;
    }

    @Override
    public boolean addPassenger(Passenger person, boolean waitingList) {
        if (person == null || person.getRoute() == null || !person.getRoute().equals(this.route))
            return false;
        if (waitingList) {
            if (this.count > this.capacity) {
                this.passengers.add(person);
                this.count++;
                return true;
            }
            this.passengers.add(person);
            this.count++;
            person.confirm();
            return true;
        }
        else {
            if (this.count > this.capacity) {
                person.cancel();
                return false;
            }
            this.passengers.add(person);
            this.count++;
            person.confirm();
            return true;
        }
    }

    @Override
    public boolean addPassenger(Passenger person) {
       return addPassenger(person, false);
    }

    @Override
    public Vehicle upgrade(int capacity) {
        return null;
    }
}
