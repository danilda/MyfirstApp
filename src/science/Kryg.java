package science;

/**
 * Created by User on 21.03.2016.
 */
public class Kryg {
    private final String name;
    private final double es;
    private double cs;
    private final int id;

    public Kryg( int id, String name, double em) {
        this.name = name;
        this.es = em;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public double getEs() {
        return es;
    }

    public double getCs() {
        return cs;
    }

    public int getId() {
        return id;
    }

    public void setCs(double cs) {
        this.cs = cs;
    }
}
