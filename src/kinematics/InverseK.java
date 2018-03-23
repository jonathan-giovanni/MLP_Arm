package kinematics;

import coordinates.Angle;
import coordinates.Cartesian;

import static java.lang.Math.*;

public class InverseK {

    private double L[];

    public InverseK(double[] l) {
        L = l;
    }

    public double[] getAngles(Cartesian coord, Angle angle) {
        //ordenando

        //x->z
        //y->x
        //
        // F > L1
        // T > L2

        System.out.println("\nX " + coord.getX() + " Y "+ coord.getY() + " Z "+ coord.getZ());
        double h   = sqrt(pow(coord.getY(),2) + pow(coord.getX(),2));
        System.out.println("L " + h);
        double dia = sqrt(pow(coord.getZ(),2) + pow(h,2));
        System.out.println("dia "+dia);

        /*
        double alpha1 = (Math.pow(L[2],2)-Math.pow(L[1],2)-Math.pow(dia,2));
        System.out.println("alpha 1 "+  alpha1);
        double alpha2 = (Math.pow(L[2],2)-Math.pow(L[1],2)-Math.pow(dia,2))/(-2*L[1]*dia);
        System.out.println("alpha 2 " + alpha2);
        */
        double alpha = PI/2 - (atan2(h, coord.getZ())+ acos( (pow(L[2],2)-pow(L[1],2)- pow(dia,2) ) /(-2*L[1]*dia)));
        double beta  = -PI+acos((pow(dia,2)-pow(L[2],2)-pow(L[1],2))/(-2*L[1]*L[2]));
        double gamma = atan2(coord.getY(),coord.getX());

        System.out.println("alpha  "+alpha + " beta " +beta + " gamma "+gamma );
        double Q[] = new double[3];


       /* double h     = Math.sqrt( Math.pow(coord.getZ(),2) + Math.pow(coord.getX(),2));
        double c     = Math.sqrt( Math.pow(h,2) + Math.pow(coord.getY()-L[0],2) );
        double gamma = Math.atan2(coord.getY()-L[0],h);
        double alfa  = -PI/+ Math.acos(
                (Math.pow(L[1],2) + Math.pow(c,2) - Math.pow(L[2],2))/
                (2*L[1]*c)
        );
        double Q[] = new double[3];
        Q[0] = Math.atan2(coord.getX(),coord.getZ());
        Q[1] = -1*(gamma - alfa);
        Q[2] = -PI/2 + Math.acos(
                ( Math.pow(c,2) - Math.pow(L[1],2) - Math.pow(L[2],2) )/
                (2*L[1]*L[2])
        );
        */


       Q[0] = gamma;
       Q[1] = alpha;
       Q[2] = beta;


       /*
        if (angle == Angle.DEGREES)
            for (int i = 0; i < Q.length; i++)
                Q[i] = Q[i] * 180 / PI;
       */
        return Q;
    }
}