/**
 * Created by kylel on 10/20/2015.
 */
public interface Vehicle {

    public int getCapacity();
    public Route getRoute();
    public int getCount();
    public Passenger[] getPassengers();
    public boolean addPassenger(Passenger person, boolean waitingList);
    public boolean addPassenger(Passenger person);
    public Vehicle upgrade(int capacity);

}
