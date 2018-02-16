package kinematics;

import coordinates.Angle;
import coordinates.Cartesian;

public class ForwardK {
    private Cartesian coord_cartesian;
    private double Q[];
    private double L[];

    private double Orientation;

    public ForwardK(double[] l) {

        L = l;
    }
    public Cartesian getCartesian(double []q, Angle angle){
        Q = q;
        coord_cartesian = new Cartesian();
        if(angle==Angle.DEGREES)
            for(int i=0;i<Q.length;i++)
                Q[i] = (Q[i]/180)*Math.PI;

        coord_cartesian.X = L[0]*Math.cos(Q[0]) + L[1]*Math.cos(Q[0]+Q[1]) + L[2]*Math.cos(Q[0]+Q[1]+Q[2]);
        coord_cartesian.Y = L[0]*Math.sin(Q[0]) + L[1]*Math.sin(Q[0]+Q[1]) + L[2]*Math.sin(Q[0]+Q[1]+Q[2]);
        Orientation       = Math.atan(coord_cartesian.Y/coord_cartesian.X);
        Orientation       = (angle == Angle.DEGREES)?Orientation * (180/Math.PI):Orientation;
        return coord_cartesian;
    }

    public double getOrientation() {
        return Orientation;
    }
}
