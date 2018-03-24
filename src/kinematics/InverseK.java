package kinematics;

import coordinates.*;
import static java.lang.Math.*;

public class InverseK {

    private double L[];

    public InverseK(double[] l) {
        L = l;
    }

    public double[] getAngles(Cartesian coord, Angle angle) {

        double Q[] = new double[3];

        System.out.println("\nX " + coord.getX() + " Y "+ coord.getY() + " Z "+ coord.getZ());
        double r  = sqrt(pow(coord.getX(),2) + pow(coord.getY(),2));
        System.out.println("r " + r);
        double d  = sqrt(pow(coord.getZ() - L[0],2) + pow(r,2));
        System.out.println("d " + d);

        Q[0] = atan2(coord.getX(),coord.getY());
        Q[2] = acos(( pow(d,2) - pow(L[2],2) - pow(L[1],2) )/(2*L[1]*L[2]));
        Q[1] = atan2(r,coord.getZ()-L[0]) - atan2(L[1] + L[2]*cos(Q[2]),L[2]*sin(Q[2]));
        System.out.println("Q[0]  "+Q[0] + " Q[1] " +Q[1] + " Q[2] "+Q[2] );

        Q[1] *= -1;
        //Q[2] += -PI/2;

        if (angle == Angle.DEGREES) for (int i = 0; i < Q.length; i++) Q[i] = Q[i] * 180 / PI;



        //redondeando a 8 decimales

        return Q;
    }

    double roundTo(double val,int decimals)
    {
        return Double.parseDouble(String.format("%."+decimals+"f", val));
    }
}