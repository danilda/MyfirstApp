package science;

/**
 * Created by User on 21.03.2016.
 */
public class Value {
    private Matrix matrix;
    private Volokno volokno;
    private Kryg kryg;

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public void setVolokno(Volokno volokno) {
        this.volokno = volokno;
    }

    public void setKryg(Kryg kryg) {
        this.kryg = kryg;
    }

    public Value(Matrix matrix, Volokno volokno){
        this.matrix = matrix;
        this.volokno = volokno;
    }
    public Value(Matrix matrix, Kryg kryg){
        this.matrix = matrix;
        this.kryg = kryg;
    }
    public Value(Matrix matrix, Volokno volokno, Kryg kryg){
        this.matrix = matrix;
        this.kryg = kryg;
        this.volokno = volokno;
    }
    public double liamda(){
        if(volokno != null){
            return Math.sqrt(1 - Math.pow((volokno.getD()/volokno.getL()),2));
        }
        System.out.println("liamda Error");
        return 0;
    }
    public double r1() {
        if (volokno != null && this.liamda() != 0) {
            return ((1-Math.pow(liamda(),2))/(4*Math.pow(liamda(), 5)))*((3 -
                    Math.pow(liamda(),2))*0.5*Math.log((1+liamda())/(1-liamda())) - 3*liamda());
        }
        System.out.println("r1 Error");
        return 0;
    }
    public double r2() {
        if (volokno != null && this.liamda() != 0) {

            return 0.375*(1-4*r1()-r3());
        }
        System.out.println("r2 Error");
        return 0;

    }
    public double r3() {
        if (volokno != null && this.liamda() != 0) {
            return ((1-Math.pow(liamda(),2))/(Math.pow(liamda(), 5)))*((1 -
                    Math.pow(liamda(),2))*liamda() + liamda()*0.5 - (3.0/2.0)*(1 -
                    Math.pow(liamda(),2))*0.5*Math.log((1+liamda())/(1-liamda())));
        }
        System.out.println("r3 Error");
        return 0;
    }
    public double q1(){
        if((volokno != null && this.liamda() != 0)){

            return 2*(1 + (0.1/(6*r2() + (matrix.getEm()/(volokno.getEf()-matrix.getEm())))));
        }
        System.out.println("q1 Error");
        return 0;
    }
    public double q2(){
        if(kryg != null){
            return (1./((matrix.getEm()/(kryg.getEs() - matrix.getEm()))+ 0.4));
        }
        System.out.println("q2 Error");
        return 0;
    }
    public double getEIEm(){
        return 1 + ((q1()*volokno.getCf()+ q2()*kryg.getCs())/
                (1- volokno.getCf() - kryg.getCs() + (q1()*volokno.getCf()
                        *matrix.getEm())/(volokno.getEf() - matrix.getEm())
                        + (q2()*kryg.getCs()*matrix.getEm())/(kryg.getEs() - matrix.getEm())));
    }
    public void logs(){
        System.out.println("liamda =" +  Math.sqrt(1 - Math.pow((volokno.getD()/volokno.getL()),2)) );
        System.out.println("r1 = " + ((1-Math.pow(liamda(),2))/(4*Math.pow(liamda(), 5)))*((3 -
                Math.pow(liamda(),2))*0.5*Math.log((1+liamda())/(1-liamda())) - 3*liamda()));
        System.out.println("r2 = " + 0.375*(1-4*r1()-r3()));
        System.out.println("r3 =" + ((1-Math.pow(liamda(),2))/(Math.pow(liamda(), 5)))*((1 -
                Math.pow(liamda(),2))*liamda() + liamda()*0.5 - (3.0/2.0)*(1 -
                Math.pow(liamda(),2))*0.5*Math.log((1+liamda())/(1-liamda()))));
        System.out.println("q1 =" + 2*(1 + (0.1/(6*r2() + (matrix.getEm()/(volokno.getEf()-matrix.getEm()))))));
        System.out.println("q2 =" + 1/((matrix.getEm()/(kryg.getEs() - matrix.getEm()))+ 0.4));
    }

}
