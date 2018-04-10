package gui;


import coordinates.Angle;
import coordinates.Cartesian;
import kinematics.ForwardK;
import kinematics.InverseK;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import static java.lang.Math.PI;

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

    public frmMain() {

        //modificar para que se inicialize con los valores por defecto

        //valores temporales debería inicializarse por defecto con estos valores
        txtCoordinateX.setText(""+coord_cartesian.getX());
        txtCoordinateY.setText(""+coord_cartesian.getY());
        txtCoordinateZ.setText(""+coord_cartesian.getZ());


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
            println(" Coordenada  X " + coord_cartesian.getX());
        });

        btnPlusY.addActionListener(a -> {
            coord_cartesian.incY();
            txtCoordinateY.setText(""+coord_cartesian.getY() );
            println(" Coordenada  Y " + coord_cartesian.getX());
            applyIK();
        });

        btnMinusY.addActionListener(a -> {
            coord_cartesian.decY();
            txtCoordinateY.setText(""+coord_cartesian.getY() );
            println(" Coordenada  Y " + coord_cartesian.getX());
            applyIK();
        });

        btnPlusZ.addActionListener(a -> {
            coord_cartesian.incZ();
            txtCoordinateZ.setText(""+coord_cartesian.getZ() );
            println(" Coordenada  Z " + coord_cartesian.getX());
            applyIK();
        });

        btnMinusZ.addActionListener(a -> {
            coord_cartesian.decZ();
            txtCoordinateZ.setText(""+coord_cartesian.getZ() );
            println(" Coordenada  Z " + coord_cartesian.getX());
            applyIK();
        });

        //angles

        angles = new double[]{0,0,0};


        //SLIDER for X
        sliderX.setMaximum(360);
        sliderX.setMajorTickSpacing(90);
        sliderX.setPaintLabels(true);
        Hashtable position1 = new Hashtable();

        position1.put(0, new JLabel("0"));

        position1.put(360, new JLabel("360"));
        sliderX.setLabelTable(position1);



        sliderX.addChangeListener(e -> {
            int angle1 = ((JSlider)e.getSource()).getValue();
            txtAngle1.setText(String.valueOf(angle1));
            angles[0] = angle1;
            angles[0] = (angles[0]/180)* PI ;
            if(arm!=null) arm.setAngles(angles,Angle.RADIANS);
            System.out.println("Angulos  1 -> "+angles[0] + " 2 -> "+angles[1]+ " 3 -> "+angles[2]);
        });

        sliderX.setValue((int)angles[0]);

        //SLIDER for Y
        sliderY.setMaximum(40);
        sliderY.setMinimum(-90);
        sliderY.setMajorTickSpacing(45);
        sliderY.setPaintLabels(true);
        Hashtable position2 = new Hashtable();

        position2.put(-90, new JLabel("-90"));

        position2.put(40, new JLabel("40"));

        sliderY.setLabelTable(position2);


        sliderY.addChangeListener(e ->{
            int angle2 = ((JSlider)e.getSource()).getValue();
            txtAngle2.setText(String.valueOf(angle2));
            angles[1] = angle2;
            angles[1] = (angles[1]/180)* PI ;
            if(arm!=null) arm.setAngles(angles,Angle.RADIANS);
            System.out.println("Angulos  1 -> "+angles[0] + " 2 -> "+angles[1]+ " 3 -> "+angles[2]);
        });

        sliderY.setValue((int)angles[1]);

        //SLIDER for Z
        sliderZ.setMaximum(90);
        sliderZ.setMinimum(-90);
        sliderZ.setMajorTickSpacing(45);
        sliderZ.setPaintLabels(true);
        Hashtable position3 = new Hashtable();
        position3.put(-90, new JLabel("-90"));
        position3.put(90, new JLabel("90"));
        sliderZ.setLabelTable(position3);


        sliderZ.addChangeListener(e -> {
            int angle3 = ((JSlider)e.getSource()).getValue();
            txtAngle3.setText(String.valueOf(angle3));
            angles[2] = angle3;
            angles[2] = (angles[2]/180)* PI ;
            if(arm!=null) arm.setAngles(angles,Angle.RADIANS);
            System.out.println("Angulos  1 -> "+angles[0] + " 2 -> "+angles[1]+ " 3 -> "+angles[2]);
        });

        sliderZ.setValue((int)angles[2]);


    }


    @Override
    public void settings() {
        super.settings();
        //ik2 = new InverseK(arm.getL());
        JFrame frame = new JFrame("frmMain");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new frmMain().panel1);
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void draw() {
        //ik2 = new InverseK(arm.getL());
        applyIK();
        //writePos();
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
        arm.setAngles(q2,Angle.DEGREES);
        setTime();
        coord_cartesian.setZ(sin(gTime*PI/2)*20);
        coord_cartesian.setY(90);
        coord_cartesian.setX(sin(gTime*PI)*10);
    }

    void applyIK(){

        //InverseK ikT = new InverseK(arm.getL());
        //double q2[] = ikT.getAngles(coord_cartesian,Angle.DEGREES);

        //TODO modificar aqui antes del ARM.java
        //arm.setAngles(q2,Angle.DEGREES);




        fill(100, 250, 1);
        if(arm!=null) {
            //ForwardK fk2 = new ForwardK(arm.getL());
            //Cartesian c = fk2.getCartesian(angles, Angle.DEGREES);
            Cartesian c = coord_cartesian;
            InverseK ik2 = new InverseK(arm.getL());

            arm.setAngles( ik2.getAngles(c,Angle.DEGREES), Angle.DEGREES);


            //y->z
            //z->y
            //translate((float)c.getX() ,-(float)c.getZ() , (float)c.getY() );
            //sphere(2);
        }
        System.out.println("Angulos de ik : q1 -> "+angles[0]+" q2 -> "+angles[1]+" q3-> "+angles[2]);
    }

}
