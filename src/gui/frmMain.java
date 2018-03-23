package gui;


import coordinates.Angle;
import coordinates.Cartesian;
import kinematics.InverseK;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class frmMain extends Window {

    float millisOld, gTime, gSpeed = 8;
    InverseK ik2;
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

        //modificar para que se inicialize con los valores por defecto

        //valores temporales debería inicializarse por defecto con estos valores
        txtCoordinateX.setText(""+incPlusX);
        txtCoordinateY.setText(""+incPlusY);
        txtCoordinateZ.setText(""+incPlusZ);


        txtCoordinateX.addActionListener(a -> {
            coord_cartesian.setX(Double.parseDouble(txtCoordinateX.getText()));
            println(" Coordenada  X " + txtCoordinateX.getText());
        });
        txtCoordinateY.addActionListener(a -> {
            coord_cartesian.setY(Double.parseDouble(txtCoordinateY.getText()));
            println(" Coordenada Y " + txtCoordinateY.getText());
        });
        txtCoordinateZ.addActionListener(a -> {
            coord_cartesian.setZ(Double.parseDouble(txtCoordinateZ.getText()));
            println(" Coordenada Z " + txtCoordinateZ.getText());
        });


        btnPlusX.addActionListener(a -> {
            coord_cartesian.incX();
            txtCoordinateX.setText(String.valueOf(coord_cartesian.getX()) );
            println(" Coordenada  X " + coord_cartesian.getX());
        });
        btnMinusX.addActionListener(a -> {
            coord_cartesian.decX();
            txtCoordinateX.setText(""+coord_cartesian.getX() );
        });

        btnPlusY.addActionListener(a -> {
            coord_cartesian.incY();
            txtCoordinateY.setText(""+coord_cartesian.getY() );
        });

        btnMinusY.addActionListener(a -> {
            coord_cartesian.decY();
            txtCoordinateY.setText(""+coord_cartesian.getY() );
        });

        btnPlusZ.addActionListener(a -> {
            coord_cartesian.incZ();
            txtCoordinateZ.setText(""+coord_cartesian.getZ() );
        });

        btnMinusZ.addActionListener(a -> {
            coord_cartesian.decZ();
            txtCoordinateZ.setText(""+coord_cartesian.getZ() );
        });



        //SLIDER for X
        sliderX.setMaximum(360);
        sliderX.setMajorTickSpacing(90);
        sliderX.setPaintLabels(true);
        Hashtable position1 = new Hashtable();

        position1.put(0, new JLabel("0"));

        position1.put(360, new JLabel("360"));
        sliderX.setLabelTable(position1);


        sliderX.addChangeListener(e -> {
            txtAngle1.setText(String.valueOf(((JSlider)e.getSource()).getValue()));
        });

        //SLIDER for Y
        sliderY.setMaximum(40);
        sliderY.setMinimum(-90);
        sliderY.setMajorTickSpacing(45);
        sliderY.setPaintLabels(true);
        Hashtable position2 = new Hashtable();

        position2.put(-90, new JLabel("-90"));

        position2.put(40, new JLabel("40"));

        sliderY.setLabelTable(position2);


        sliderY.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e2) {

                txtAngle2.setText(String.valueOf(((JSlider)e2.getSource()).getValue()));
            }
        });

        //SLIDER for Z
        sliderZ.setMaximum(90);
        sliderZ.setMinimum(-90);
        sliderZ.setMajorTickSpacing(45);
        sliderZ.setPaintLabels(true);
        Hashtable position3 = new Hashtable();
        position3.put(-90, new JLabel("-90"));
        position3.put(90, new JLabel("90"));
        sliderZ.setLabelTable(position3);


        sliderZ.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e3) {

                txtAngle3.setText(String.valueOf(((JSlider)e3.getSource()).getValue()));
            }
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
        ik2 = new InverseK(arm.getL());
        writePos();
        super.draw();
        //if(!test) arm.setAngles(new double[]{radians(frameCount),0,0}, Angle.RADIANS);


        // calculando ik


        //q2[0]+=180;
    }


    void setTime(){
        gTime += ((float)millis()/1000 - millisOld)*(gSpeed/4);
        if(gTime >= 4)  gTime = 0;
        millisOld = (float)millis()/1000;
    }

    void writePos(){
        double q2[] = ik2.getAngles(coord_cartesian,Angle.DEGREES);
        arm.setAngles(q2,Angle.RADIANS);
        setTime();
        coord_cartesian.setX(sin(gTime*PI/2)*20);
        coord_cartesian.setY(90);
        coord_cartesian.setZ(sin(gTime*PI)*10);
    }
}
