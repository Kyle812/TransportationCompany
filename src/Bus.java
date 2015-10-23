import java.util.ArrayList;

/**
 * Created by kylel on 10/20/2015.
 */
public class Bus implements Vehicle {

    private Route route;
    private int capacity;
    private int count;
    private ArrayList <Passenger> passengers;

    public Bus(Route route, int capacity) {
        this.route = route;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
        count = 0;
    }

    public Bus(Route route) {
         this(route, 2);
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
//        if (person.getRoute().equals(route)) {
//            count++;
//            if (count > capacity) {
//                if(count * 2 >= capacity) {
//                    upgrade(capacity);
//                }
//                if (!waitingList) {
//                    person.cancel();
//                } else {
//                    passengers.add(passengers.size(), person);
//                    return true;
//                }
//            } else {
//                person.confirm();
//                passengers.add(passengers.size(), person);
//                return true;
//            }
//        } else {
//            person.cancel();
//            return false;
//        }
        if (person == null || person.getRoute() == null) {
            return false;
        }
        if (!person.getRoute().equals(this.route)) {
            person.cancel();
            return false;
        }
        if (waitingList) {
            if (this.count >= this.capacity) {
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
            if (this.count >= this.capacity) {
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
        return addPassenger(person, true);
    }

    @Override
    public Vehicle upgrade(int capacity) {
        Airplane plane = new Airplane(route, capacity * 3);
        for (int i = 0; i < passengers.size(); i++) {
            plane.addPassenger(passengers.get(i));
        }
        return plane;
    }

    public boolean isReadyForUpgrade() {
        if (passengers.size() >= capacity * 2) {
            return true;
        }
        return false;
    }
}
