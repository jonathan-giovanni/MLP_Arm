package coordinates;

public class Cartesian {
    public double X;
    public double Y;
    public double Z;

    public Cartesian(){
        X = Y = Z = 0;
    }

    public Cartesian(double x, double y, double z) {
        X = x;
        Y = y;
        Z = z;
    }
}
