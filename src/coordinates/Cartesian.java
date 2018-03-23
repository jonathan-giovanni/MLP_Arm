package coordinates;

public class Cartesian {
    private static double X;
    private static double Y;
    private static double Z;
    private static double STEP;


    public Cartesian(){
        X = Y = Z = 0;
        STEP= 1;
    }
    public Cartesian(double min,int step){
        X = Y = Z = 0;
        STEP  = step;
    }

    public Cartesian(double x, double y, double z) {
        X=x;Y=y;Z=z;
    }

    public void setSTEP(double STEP) {this.STEP = STEP;}
    public void setX(double x){ X =x; }
    public void setY(double y){ Y = y; }
    public void setZ(double z){
        Z = z;
    }
    public double getX(){return X;}
    public double getY(){return Y;}
    public double getZ(){return Z;}
    public double getSTEP() {return STEP;}
    public void decX(){X -=STEP;}
    public void decY(){Y -=STEP;}
    public void decZ(){Z -=STEP;}
    public void incX(){X +=STEP;}
    public void incY(){Y +=STEP;}
    public void incZ(){Z +=STEP;}

}
