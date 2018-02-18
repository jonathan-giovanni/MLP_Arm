package arm;

import coordinates.Angle;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

public class Arm {
    double F = 50;
    double T = 70;

    PApplet context;
    PShape base, shoulder, upArm, loArm, end;
    double L[];
    double Q[];

    public Arm(PApplet pApplet){
        context     = pApplet;

        //TODO se puede modificar la longitud de cada elemento
        L = new double[]{66,70,62};
        //TODO hasta aqui
        Q = new double[]{0,0,0};

        base        = context.loadShape("r5.obj");
        shoulder    = context.loadShape("r1.obj");
        upArm       = context.loadShape("r2.obj");
        loArm       = context.loadShape("r3.obj");
        end         = context.loadShape("r4.obj");

        shoulder.disableStyle();
        upArm.disableStyle();
        loArm.disableStyle();
    }

    public void setAngles(double q[], Angle angle){
        Q = q;
            if(angle==Angle.DEGREES)
                for(int i=0;i<Q.length;i++)
                    Q[i] = (Q[i]/180)*Math.PI;
    }

    public void drawArm(){
        context.noStroke();
        context.scale(-1.20f);

        //base no rotatoria
        context.fill(255, 227, 8);
        context.translate(0,26,0);
        context.shape(base);
        //base rotatoria
        context.translate(0, 4, 0);
        context.rotateY((float) Q[0]);
        context.shape(shoulder);
        //antebrazo
        context.fill(66, 244, 131,40);
        context.translate(0, 25, 0);
        context.rotateY(context.PI);
        context.rotateX((float) Q[1]);
        context.shape(upArm);
        //brazo
        context.translate(0, 0, 50);
        context.rotateY(context.PI);
        context.rotateX((float) Q[2]);
        context.shape(loArm);
        //orientacion (NO USADA)
        context.translate(0, 0, -50);
        context.rotateY(context.PI);
        context.shape(end);
    }

    public double[] getL(){return L;}
    public double[] getQ(){return Q;}
}
