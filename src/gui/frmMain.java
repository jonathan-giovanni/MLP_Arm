package gui;

import processing.core.PApplet;

import javax.swing.*;

public class frmMain extends PApplet {

    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;

    static int angle = 0;
    static int valor=0;

    public frmMain() {
        button1.addActionListener(a -> {
            valor = valor + 5;
            println("valor boton 1 "+valor);
            //this.pWindow.test=!this.pWindow.test;
        });
    }


    public static void maina(String[] args){
        JFrame frame = new JFrame("frmMain");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new frmMain().panel1);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void settings() {
        size(640, 360);
        JFrame frame = new JFrame("frmMain");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new frmMain().panel1);
        frame.pack();
        frame.setVisible(true);
        //fullScreen(P3D);

    }

    @Override
    public void setup() {
        strokeWeight(1);
        smooth();
        textMode(SHAPE);
    }

    @Override
    public void draw() {

        if (mousePressed == true) {
            angle += 5;
            double val =  Math.cos(radians(angle)) * 12.0;
            for (int a = 0; a < 360; a += 75) {
                double xoff = Math.cos(radians(a)) * val;
                double yoff = Math.sin(radians(a)) * val;
                fill(40+valor);
                ellipse((float)(mouseX + xoff), (float)(mouseY + yoff), (float) val, (float) val);
            }
            fill(20+valor);
            ellipse(mouseX, mouseY, 2, 2);
            println("valor boton 2 "+valor);
        }
    }
}
