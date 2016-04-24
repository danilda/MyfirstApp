package science;

/**
 * Created by User on 21.03.2016.
 */
public class Volokno {
    private final String name;
    private final double ef;
    private double cf;
    private final double l;
    private final double d;
    private final int id;


    public Volokno(int id, String name, double ef, double l, double d) {
        this.name = name;
        this.ef = ef;
        this.l = l;
        this.d = d;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getEf() {
        return ef;
    }

    public double getCf() {
        return cf;
    }

    public double getL() {
        return l;
    }

    public double getD() {
        return d;
    }

    public void setCf(double cf) {
        this.cf = cf;
    }
}
