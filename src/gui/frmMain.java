package gui;

import javax.swing.*;

public class frmMain {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;


    public frmMain() {
        button1.addActionListener(a -> System.out.println("Hola click"));
    }

    public static void main(String args[]){
        JFrame frame = new JFrame("frmMain");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new frmMain().panel1);
        frame.pack();
        frame.setVisible(true);
    }
}
