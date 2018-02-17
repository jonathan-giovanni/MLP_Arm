package kinematics;

import coordinates.Angle;
import coordinates.Cartesian;

public class InverseK {

    private Cartesian coord_cartesian;
    private double L[];

    public InverseK(double[] l) {
        L = l;
    }

    public double[] getAngles(Cartesian coord, Angle angle) {
        double h     = Math.sqrt( Math.pow(coord.X,2) + Math.pow(coord.Y,2));
        double c     = Math.sqrt( Math.pow(h,2) + Math.pow(coord.Z-L[0],2) );
        double gamma = Math.atan2(coord.Z-L[0],h);
        double alfa  = Math.acos(
                (Math.pow(L[1],2) + Math.pow(c,2) - Math.pow(L[2],2))/
                (2*L[1]*c)
        );
        double Q[] = new double[3];
        Q[0] = Math.atan2(coord.Y,coord.X);
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




    /*

    //Codigo de TestArmTesis ik processing
    double F = 50;
    double T = 70;
    double millisOld, gTime, gSpeed = 8;

    void IK(){

        float X = posX;
        float Y = posY;
        float Z = posZ;

        float L = sqrt(Y*Y+X*X);
        float dia = sqrt(Z*Z+L*L);

        alpha = Math.PI/2-(atan2(L, Z)+acos((T*T-F*F-dia*dia)/(-2*F*dia)));
        beta = -PI+acos((dia*dia-T*T-F*F)/(-2*F*T));
        gamma = atan2(Y, X);

    }

    void setTime(){
        gTime += ((float)millis()/1000 - millisOld)*(gSpeed/4);
        if(gTime >= 4)  gTime = 0;
        millisOld = (float)millis()/1000;
    }

    void writePos(){
        IK();
        setTime();
        posX = sin(gTime*PI/2)*20;
        posZ = sin(gTime*PI)*10;
    }
    */
