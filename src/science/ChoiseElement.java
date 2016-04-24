package science;

/**
 * Created by User on 31.03.2016.
 */
public class ChoiseElement {
    private static Matrix matrix;
    private static Volokno volokno;
    private static Kryg kryg;

    public static Matrix getMatrix() {
        return matrix;
    }

    public static void setMatrix(Matrix matrix) {
        ChoiseElement.matrix = matrix;
    }

    public static Volokno getVolokno() {
        return volokno;
    }

    public static void setVolokno(Volokno volokno) {
        ChoiseElement.volokno = volokno;
    }

    public static Kryg getKryg() {
        return kryg;
    }

    public static void setKryg(Kryg kryg) {
        ChoiseElement.kryg = kryg;
    }
}
