package gui;

import arm.Arm;
import coordinates.Angle;
import coordinates.Cartesian;
import javafx.scene.input.KeyCode;
import kinematics.ForwardK;
import kinematics.InverseK;
import processing.core.*;
import processing.event.KeyEvent;

import java.util.Scanner;


public class Window extends PApplet {

    float size;
    PVector origin;
    float rX,rY,zoom;
    Cartesian coord_cartesian;

    Arm arm;
    InverseK ik;
    @Override
    public void settings() {
        //size(400, 400, P3D);
        fullScreen(P3D);

    }

    @Override
    public void setup() {
        strokeWeight(1);
        smooth();
        textMode(SHAPE);
        origin  = new PVector(width / 2, height / 2,0);
        size    = 2000;
        zoom    = 1.5f;
        rX      = -0.51f;
        rY      = -0.65f;
        arm     = new Arm(this);
        ik      = new InverseK(arm.getL());
/***
 *              RANGO DE ANGULOS VALIDOS SOBRE LOS EJES
 *              ________________________________________
 *          q1 = {0,360}  -> vuelta completa
 *          q2 = {40,-90} -> negativos hacia arriba
 *          q3 = {-90,90} -> negativos hacia abajo
 * */


        //TODO se puede hacer pruebas aqui
        //arm.setAngles(new double[]{45,20,20},Angle.DEGREES);
        ForwardK fk = new ForwardK(arm.getL());
        //coord_cartesian = fk.getCartesian(new double[]{0,0,0},Angle.DEGREES);

        arm.setAngles(new double[]{0,0,0},Angle.DEGREES);

        coord_cartesian = new Cartesian();

        //coord_cartesian = new Cartesian(90,10,70);


        // calculando ik
        //InverseK ik2 = new InverseK(arm.getL());
        //double q2[] = ik2.getAngles(coord_cartesian,Angle.DEGREES);
        //q2[0]+=180;
        //arm.setAngles(q2,Angle.DEGREES);

        //System.out.println("--Angulos de ik2 : q1 -> "+q2[0]+" q2 -> "+q2[1]+" q3-> "+q2[2]);
        // System.out.println("Coordenadas X,Y y Z : "+coord_cartesian.getX() + " , "+ coord_cartesian.getY() + " , "+coord_cartesian.getZ());
        //arm.setAngles(ik.getAngles(new Cartesian(0,0,130),Angle.RADIANS),Angle.RADIANS);
        //TODO hasta aqui


    }

    @Override
    public void draw() {
        background(255);
        lights();
        directionalLight(40, 90, 100, 1, 40, 40);

        translate(origin.x,origin.y,origin.z);


        scale(zoom);
        userInput();
        drawAxes();

        hint(ENABLE_DEPTH_TEST);

        pushMatrix();
        noStroke();
        //TODO se puede hacer prueba aqui
        fill(250, 100, 1);
        translate((float)coord_cartesian.getX(),(float)-coord_cartesian.getY(), (float) coord_cartesian.getZ());
        //TODO hasta aqui
        sphere(2);
        popMatrix();

        //70 de altura


        /*pushMatrix();
        noStroke();
        translate(0, -35, 0);
        fill(0, 220, 0,40);
        box(10,70,10);
        popMatrix();

        //antebrazo 60
        pushMatrix();
        noStroke();
        translate(0, -66, 30);
        rotateX(PI/2);
        fill(0, 0, 240,40);
        box(10,60,10);
        popMatrix();

        //brazo 80
        pushMatrix();
        noStroke();
        translate(0, -66, 95);
        rotateX(PI/2);
        fill(100, 0, 220,40);
        box(10,80,10);
        popMatrix();
        */



        pushMatrix();
        arm.drawArm();
        popMatrix();

        //valores : base - brazo - antebrazo
        //arm.setAngles(new double[]{radians(frameCount),0,0}, Angle.RADIANS);


    }

    private void userInput(){
        if(mousePressed){
            rX   -= (mouseY - pmouseY) * 0.002f;//map(mouseY,0,height,-PI,PI);
            rY   -= (mouseX - pmouseX) * 0.002f;// map(mouseX,0,width,PI,-PI);
        }
        rotateX(rX);
        rotateY(rY);

        if(keyPressed){
            if(keyCode == UP){
                zoom += 0.01f;
            }
            if(keyCode == DOWN){
                zoom -= 0.01f;
            }
        }
    }

    private void drawAxes() {
        float margin = 90;

        //X rojo
        text("+X",margin,-2,0);
        text("-X",-margin,-2,0);
        stroke(210, 0, 0);
        line(-size,0,0,size,0,0);

        //Y verde
        text("-Y",2,margin,0);
        text("+Y",2,-margin,0);
        stroke(0, 210, 0);
        line(0,-size,0,0,size,0);

        //Z azul
        text("+Z",5,0,margin);
        text("-Z",5,0,-margin);
        stroke(0, 0, 210);
        line(0, 0, -size,0,0, size);
    }
}
