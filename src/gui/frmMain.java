package gui;


import javax.swing.*;

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

}
