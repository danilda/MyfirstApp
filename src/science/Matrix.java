package science;

/**
 * Created by User on 21.03.2016.
 */
public class Matrix{
    private final String name;
    private final double em;
    private double cm;
    private final int id;

    public Matrix(int id, String name, double em) {
        this.name = name;
        this.em = em;
        this.id = id;
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public double getEm() {
        return em;
    }

    public double getCm() {
        return cm;
    }

    public void setCm(double cm) {
        this.cm = cm;
    }
}
