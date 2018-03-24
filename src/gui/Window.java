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
    static Cartesian coord_cartesian = new Cartesian(0,120,50);;
    public static boolean test = false;

    static double angles[];

    Arm arm;
    InverseK ik;
    @Override
    public void settings() {
        size(800, 800, P3D);
        //fullScreen(P3D);
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


        //TODO pruebas FK

        /*

        angles = new double[]{0,0,0};
        ForwardK fk = new ForwardK(arm.getL());
        coord_cartesian = fk.getCartesian(angles,Angle.DEGREES);

        arm.setAngles(angles,Angle.DEGREES);

        println("Fk x: "+coord_cartesian.getX() + " y: "+coord_cartesian.getY()+ " z: "+ coord_cartesian.getZ() );

        */

        //TODO pruebas IK

        //coord_cartesian = new Cartesian(0,120,50);
        InverseK ik2 = new InverseK(arm.getL());
        double q2[] = ik2.getAngles(coord_cartesian,Angle.DEGREES);
        arm.setAngles(q2,Angle.DEGREES);

        System.out.println("--Angulos de ik2 : q1 -> "+q2[0]+" q2 -> "+q2[1]+" q3-> "+q2[2]);
        System.out.println("Coordenadas X,Y y Z : "+coord_cartesian.getX() + " , "+ coord_cartesian.getY() + " , "+coord_cartesian.getZ());
        //arm.setAngles(ik.getAngles(new Cartesian(0,0,130),Angle.RADIANS),Angle.RADIANS);


    }

    @Override
    public void draw() {
        background(255);
        lights();
        directionalLight(40, 90, 100, 1, 40, 40);

        translate(origin.x,origin.y);
        scale(zoom);


        userInput();
        drawAxes();


        hint(ENABLE_DEPTH_TEST);



        pushMatrix();
        noStroke();
        //TODO hasta aqui
        fill(250, 100, 1);
        //x->y
        //y->z
        //z->x
        //translate((float)coord_cartesian.getX() ,-(float)coord_cartesian.getZ() , (float)coord_cartesian.getY() );
        translate((float)coord_cartesian.getX() ,-(float)coord_cartesian.getZ() , (float)coord_cartesian.getY() );
        //TODO hasta aqui
        sphere(2);
        popMatrix();


        pushMatrix();
        arm.drawArm();
        popMatrix();





        //valores : base - brazo - antebrazo
        //if(!test) arm.setAngles(new double[]{radians(frameCount),0,0}, Angle.RADIANS);


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
