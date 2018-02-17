package coordinates;

public class Cartesian {
    private double X;
    private double Y;
    private double Z;
    private double MIN;

    public Cartesian(){
        X = Y = Z = 0;
        MIN = 0.00001;
    }
    public Cartesian(double min){
        X = Y = Z = 0;
        MIN = min;
    }

    public Cartesian(double x, double y, double z) {
        X = (x>MIN)?x:0;
        Y = (y>MIN)?y:0;
        Z = (z>MIN)?z:0;
    }
    public void setX(double x){
        X = (x>MIN)?x:0;
    }
    public void setY(double y){
        Y = (y>MIN)?y:0;
    }
    public void setZ(double z){
        Z = (z>MIN)?z:0;
    }
    public double getX(){return X;}
    public double getY(){return Y;}
    public double getZ(){return Z;}
}
