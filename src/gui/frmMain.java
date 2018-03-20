package gui;


import coordinates.Angle;
import coordinates.Cartesian;
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
    private int incPlusX, incPlusY, incPlusZ;
    public frmMain() {
        incPlusX = 20;
        incPlusY = 40;
        incPlusZ = 45;
        txtCoordinateX.setText("20");
        txtCoordinateY.setText("40");
        txtCoordinateZ.setText("45");

        btnMinusX.addActionListener(a -> {
            test = !test;
        });

        txtCoordinateX.addActionListener(a -> {
            coord_cartesian.setX(  Double.parseDouble( txtCoordinateX.getText() ) );
            println( " Coordenada  X "  + txtCoordinateX.getText() );
        });
        txtCoordinateY.addActionListener(a -> {
            coord_cartesian.setY(  Double.parseDouble( txtCoordinateY.getText() ) );
            println( " Coordenada Y "  + txtCoordinateY.getText() );
        });
        txtCoordinateZ.addActionListener(a -> {
            coord_cartesian.setZ(  Double.parseDouble( txtCoordinateZ.getText() ) );
            println( " Coordenada Z "  + txtCoordinateZ.getText() );
        });


        btnPlusX.addActionListener(a ->{

            incPlusX++;

            txtCoordinateX.setText(String.valueOf(incPlusX));
            coord_cartesian.setX(  Double.parseDouble( txtCoordinateX.getText() ) );

        });
        btnPlusY.addActionListener(a ->{

            incPlusY++;

            txtCoordinateY.setText(String.valueOf(incPlusY));
            coord_cartesian.setY(  Double.parseDouble( txtCoordinateY.getText() ) );

        });

        btnPlusZ.addActionListener(a ->{

            incPlusZ++;

            txtCoordinateZ.setText(String.valueOf(incPlusZ));
            coord_cartesian.setZ(  Double.parseDouble( txtCoordinateZ.getText() ) );

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
        arm.setAngles(q2,Angle.DEGREES);

    }
}
