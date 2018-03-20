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
        incPlusX = 20;
        incPlusY = 40;
        incPlusZ = 45;

        //valores temporales debería inicializarse por defecto con estos valores
        txtCoordinateX.setText("20");
        txtCoordinateY.setText("40");
        txtCoordinateZ.setText("45");


        btnMinusX.addActionListener(a -> {
            test = !test;
        });

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


        btnMinusX.addActionListener(a -> {

            --incPlusX;

            txtCoordinateX.setText(String.valueOf(incPlusX));
            coord_cartesian.setX(Double.parseDouble(txtCoordinateX.getText()));

        });


        btnPlusX.addActionListener(a -> {

            ++incPlusX;

            txtCoordinateX.setText(String.valueOf(incPlusX));
            coord_cartesian.setX(Double.parseDouble(txtCoordinateX.getText()));

        });
        btnPlusY.addActionListener(a -> {

            ++incPlusY;

            txtCoordinateY.setText(String.valueOf(incPlusY));
            coord_cartesian.setY(Double.parseDouble(txtCoordinateY.getText()));

        });

        btnMinusY.addActionListener(a -> {

            --incPlusY;

            txtCoordinateY.setText(String.valueOf(incPlusY));
            coord_cartesian.setY(Double.parseDouble(txtCoordinateY.getText()));

        });

        btnPlusZ.addActionListener(a -> {

            ++incPlusZ;

            txtCoordinateZ.setText(String.valueOf(incPlusZ));
            coord_cartesian.setZ(Double.parseDouble(txtCoordinateZ.getText()));

        });

        btnMinusZ.addActionListener(a -> {

            --incPlusZ;

            txtCoordinateZ.setText(String.valueOf(incPlusZ));
            coord_cartesian.setZ(Double.parseDouble(txtCoordinateZ.getText()));

        });
        //SLIDER for X
        sliderX.setMaximum(360);
        sliderX.setMajorTickSpacing(90);
        sliderX.setPaintLabels(true);
        Hashtable position = new Hashtable();

        position.put(0, new JLabel("0"));

        position.put(360, new JLabel("360"));
        sliderX.setLabelTable(position);


        sliderX.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

                txtAngle1.setText(String.valueOf(((JSlider)e.getSource()).getValue()));
            }
        });

        //SLIDER for Y
        sliderY.setMaximum(40);
        sliderY.setMinimum(-90);
        sliderY.setMajorTickSpacing(45);
        sliderY.setPaintLabels(true);
        Hashtable positionY = new Hashtable();

        positionY.put(-90, new JLabel("-90"));

        positionY.put(40, new JLabel("40"));

        sliderY.setLabelTable(positionY);


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
        Hashtable positionZ = new Hashtable();

        positionZ.put(-90, new JLabel("-90"));

        positionZ.put(90, new JLabel("90"));
        sliderZ.setLabelTable(positionZ);


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
        super.draw();
        //if(!test) arm.setAngles(new double[]{radians(frameCount),0,0}, Angle.RADIANS);


        // calculando ik
        InverseK ik2 = new InverseK(arm.getL());
        double q2[] = ik2.getAngles(coord_cartesian,Angle.DEGREES);
        arm.setAngles(q2,Angle.DEGREES);

    }
}
