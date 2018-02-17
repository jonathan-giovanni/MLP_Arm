package gui;

import arm.Arm;
import kinematics.InverseK;
import processing.core.*;

import java.util.Scanner;


public class Window extends PApplet {

    float size;
    PVector origin;

    @Override
    public void settings() {
        //size(400, 400, P3D);
        fullScreen(P3D);

    }

    @Override
    public void setup() {
        strokeWeight(1);
        smooth();
        origin  = new PVector(width / 2, height / 2,0);
        size    = 2000;
    }

    @Override
    public void draw() {
        translate(origin.x,origin.y,origin.z);

        scale(1.5f);

        background(105);
        //draw original coordinate system

        //draw from centre and rotate with mouse



        float rX=  map(mouseY,0,height,-PI,PI);
        float rY=  map(mouseX,0,width,PI,-PI);
        rotateX(rX);
        rotateY(rY);

        System.out.println("rotacion X "+rX);
        System.out.println("rotacion Y "+rY);


        //draw centred coordinate system
        drawAxes();

    }

    private void drawAxes() {

        float margin = 100;

        //X rojo
        text("+X",margin,0,0);
        text("-X",-margin,0,0);
        stroke(250, 0, 0);
        line(-size,0,0,size,0,0);
        //Y verde

        text("-Y",0,margin,0);
        text("+Y",0,-margin,0);
        stroke(0, 250, 0);
        line(0,-size,0,0,size,0);
        //Z azul
        text("+Z",0,0,margin);
        text("-Z",0,0,-margin);
        stroke(0, 0, 250);
        line(0, 0, -size,0,0, size);
    }
    public void mouseDragged() {
        //rotateX(map(mouseY,0,height,-PI,PI));
        //rotateY(map(mouseX,0,width,PI,-PI));

    }
    /*
    Scanner scanner = new Scanner( System.in );

    //arm 3d
    Arm genericArm;
    //inverse kinematic
    InverseK ik;

    double posX = 1, posY = 60, posZ = 60;
    PVector origin;


    @Override
    public void settings() {
        size(1280, 800, P3D);
        //fullScreen(P3D);
        origin = new PVector(width / 2, height / 2,0);

    }

    @Override
    public void setup() {
        //surface.setResizable(true);
        genericArm  = new Arm(this);
        //colorMode(HSB, 100, 100, 100, 100);
        //frameRate(60);

        IkToArm(posX,posY,posZ);
    }

    @Override
    public void draw() {

        hint(ENABLE_DEPTH_TEST);
        background(170);
        smooth();
        lights();
        directionalLight(51, 102, 126, -1, 0, 0);
        drawAxis();
        genericArm.drawArm();
    }

    private void drawAxis() {
        translate(0, 0, 0);
        stroke(0, 0, 250);
        line(0, origin.y, width, origin.y);//azul y
        stroke(250, 0, 0);
        line(origin.x, 0, origin.x, height);//rojo x
        stroke(0, 250, 0);
        line(-origin.x, height, origin.x, origin.y);//verde z
        line(origin.x, origin.y, width * 2, -origin.y);//z
    }

    public void mouseDragged() {
        genericArm.rotY -= (mouseX - pmouseX) * 0.01;
        genericArm.rotX -= (mouseY - pmouseY) * 0.01;
    }




    private void IkToArm(double x,double y,double z){

        System.out.println( "Pos X : " + x);
        System.out.println( "Pos Y : " + y);
        System.out.println( "Pos Z : " + z);


        double angles[] = ik.evaluate(x,y,z);


        genericArm.drawArm(angles[0],angles[1],angles[2]);

        // 4. Now, you can do anything with the input string that you need to.
        // Like, output it to the user.
        System.out.println( "alpha : " + angles[0]);
        System.out.println( "beta  : " + angles[1]);
        System.out.println( "gamma : " + angles[2]);

    }
    */


}
