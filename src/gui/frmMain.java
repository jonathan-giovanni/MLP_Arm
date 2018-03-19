package gui;


import coordinates.Angle;
import kinematics.InverseK;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMain extends Window {

    public JFrame frame;
    public frmMain ventana;

    private JPanel panel1;
    private JButton btnMinusX;
    private JButton btnMinusZ;
    private JButton btnMinusY;
    private JButton btnPlusX;
    private JButton btnPlusY;
    private JButton btnPlusZ;
    private JSlider sliderX;
    private JSlider sliderY;
    private JSlider sliderZ;
    private JTextField txtAngle1;
    private JTextField txtAngle2;
    private JTextField txtAngle3;
    private JTextField txtCoordinateX;
    private JTextField txtCoordinateY;
    private JTextField txtCoordinateZ;


    public frmMain() {
        btnMinusX.addActionListener(a -> {
            test = !test;
        });

        txtCoordinateX.addActionListener(a -> {
            coord_cartesian.setX(  Double.parseDouble( txtCoordinateX.getText() ) );
            println( " Coordenada  X "  + txtCoordinateX.getText() );
        });
        txtCoordinateY.addActionListener(a -> {
            coord_cartesian.setX(  Double.parseDouble( txtCoordinateY.getText() ) );
            println( " Coordenada Y "  + txtCoordinateY.getText() );
        });
        txtCoordinateZ.addActionListener(a -> {
            coord_cartesian.setX(  Double.parseDouble( txtCoordinateZ.getText() ) );
            println( " Coordenada Z "  + txtCoordinateZ.getText() );
        });

    }


    @Override
    public void settings() {
        super.settings();
        JFrame frame = new JFrame("frmMain");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new frmMain().panel1);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void draw() {
        super.draw();
        //if(!test) arm.setAngles(new double[]{radians(frameCount),0,0}, Angle.RADIANS);


        // calculando ik
        InverseK ik2 = new InverseK(arm.getL());
        double q2[] = ik2.getAngles(coord_cartesian,Angle.DEGREES);
        //q2[0]+=180;
        arm.setAngles(q2,Angle.DEGREES);

    }
}
