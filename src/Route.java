
/**
 * Created by kylel on 10/20/2015.
 */
public class Route {

    private String from;
    private String to;

    public Route (String from, String to) {
        this.from = from;
        this.to = to;
    }

    public boolean equals (Route obj) {
        if (this.from.equals(obj.getFrom()) && this.to.equals(obj.getTo())) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return String.format("Route: From %s to %s\n", this.from, this.to);
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
