package kinematics;

import coordinates.Angle;
import coordinates.Cartesian;

import static java.lang.Math.*;


public class ForwardK {
    private double Q[];
    private double L[];

    public ForwardK(double[] l) {
        L = l;
    }
    public Cartesian getCartesian(double []q, Angle angle){
        Q = q;
        if(angle==Angle.DEGREES) for(int i=0;i<Q.length;i++) Q[i] = (Q[i]/180)*Math.PI;

        //ordenando
        //x->y
        //y->z
        //z->x

        //aqui opera solo con radianes
        double x = (L[1]*cos(Q[1])+L[2]*cos(Q[1]+Q[2]))*sin(Q[0]);
        double y = (L[1]*cos(Q[1])+L[2]*cos(Q[1]+Q[2]))*cos(Q[0]);
        double z =  L[1]*sin(Q[1])+L[2]*sin(Q[1]+Q[2]) +    L[0];


        //if(angle==Angle.DEGREES) for(int i=0;i<Q.length;i++) Q[i] = Q[i]*(180/Math.PI);

        return new Cartesian(x,y,z);
    }
}
