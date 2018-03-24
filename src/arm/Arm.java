package arm;

import coordinates.Angle;
import processing.core.PApplet;
import processing.core.PShape;

import static java.lang.Math.PI;

public class Arm {

    PApplet context;
    PShape base, shoulder, upArm, loArm, end;
    double L[];
    double Q[];

    public Arm(PApplet pApplet){
        context     = pApplet;
        //TODO se puede modificar la longitud de cada elemento
        L = new double[]{50,50,70};
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
        if(angle==Angle.DEGREES) for(int i=0;i<Q.length;i++) Q[i] = (Q[i]/180)* PI;
    }

    public void drawArm(){

        //context.translate(0,0);

        context.scale(-1.20f);
        /**     base no rotatoria   **/
        context.fill(255, 200, 10,100);
        context.translate(0,26,0); // 0 , 26, 0 para que quede alineado en el centro de los ejes
        context.shape(base);
        /**     base rotatoria      **/
        context.translate(0, 4, 0);
        context.rotateY((float) Q[1]);//gamma
        context.shape(shoulder);
        /**     antebrazo           **/
        context.fill(60, 200, 130);
        context.translate(0, 25, 0);
        context.rotateY(context.PI);
        context.rotateX((float) Q[2]);//alpha
        context.shape(upArm);
        /**      brazo               **/
        context.translate(0, 0, 50);
        context.rotateY(context.PI);
        context.rotateX((float) Q[0]);//beta
        context.shape(loArm);
        /**     orientacion         **/
        context.fill(140, 200, 100);
        context.translate(0, 0, -50);
        context.rotateY(context.PI);
        context.shape(end);
    }

    public double[] getL(){return L;}
    public double[] getQ(){return Q;}
}
