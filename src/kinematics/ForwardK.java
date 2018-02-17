package kinematics;

import coordinates.Angle;
import coordinates.Cartesian;

/*
    Basado en la investigación:
    http://www.utm.mx/~hugo/robot/Robot2.pdf
*/

public class ForwardK {
    private Cartesian coord_cartesian;
    private double Q[];
    private double L[];

    public ForwardK(double[] l) {
        L = l;
    }
    public Cartesian getCartesian(double []q, Angle angle){
        Q = q;
        coord_cartesian = new Cartesian();
        if(angle==Angle.DEGREES)
            for(int i=0;i<Q.length;i++)
                Q[i] = (Q[i]/180)*Math.PI;

        double h  = L[1]*Math.cos(Q[1]) + L[2]*Math.cos(Q[1]+Q[2]);
        //double c  = Math.sqrt( Math.pow(L[1],2) + Math.pow(L[2],2) + 2*L[1]*L[2]*Math.cos(Q[2]));
        coord_cartesian.setX( h*Math.cos(Q[0]));
        coord_cartesian.setY( h*Math.sin(Q[0]));
        coord_cartesian.setZ( L[0]+L[1]*Math.sin(Q[1])+L[2]*Math.sin(Q[1]+Q[2]));

        if(angle==Angle.DEGREES)
            for(int i=0;i<Q.length;i++)
                Q[i] = Q[i]*(180/Math.PI);
        return coord_cartesian;
    }
}
