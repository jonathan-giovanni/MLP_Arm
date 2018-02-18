package kinematics;

import coordinates.Angle;
import coordinates.Cartesian;

public class InverseK {

    private double L[];

    public InverseK(double[] l) {
        L = l;
    }

    public double[] getAngles(Cartesian coord, Angle angle) {
        //ordenando

        //x->z
        //y->x
        //z->y
        double h     = Math.sqrt( Math.pow(coord.getZ(),2) + Math.pow(coord.getX(),2));
        double c     = Math.sqrt( Math.pow(h,2) + Math.pow(coord.getY()-L[0],2) );
        double gamma = Math.atan2(coord.getY()-L[0],h);
        double alfa  = Math.acos(
                (Math.pow(L[1],2) + Math.pow(c,2) - Math.pow(L[2],2))/
                (2*L[1]*c)
        );
        double Q[] = new double[3];
        Q[0] = Math.atan2(coord.getX(),coord.getZ());
        Q[1] = gamma - alfa;
        Q[2] = Math.acos(
                ( Math.pow(c,2) - Math.pow(L[1],2) - Math.pow(L[2],2) )/
                (2*L[1]*L[2])
        );

        if (angle == Angle.DEGREES)
            for (int i = 0; i < Q.length; i++)
                Q[i] = Q[i] * 180 / Math.PI;

        return Q;
    }
}