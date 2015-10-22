
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

    public boolean equals (Object obj) {
        if (obj != null) {
            if (obj instanceof Route) {
                if (this.from.equals(((Route) obj).from) && this.to.equals(((Route) obj).to)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return String.format("Route: From %s to %s\n", this.from, this.to);
    }

}
