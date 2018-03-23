import coordinates.Angle;
import coordinates.Cartesian;
import gui.Window;
import gui.frmMain;
import kinematics.ForwardK;
import kinematics.InverseK;
import mlp.MultiLayerPerceptron;
import mlp.transferfunctions.HyperbolicTransfer;
import mlp.transferfunctions.SigmoidalTransfer;
import processing.core.PApplet;

public class Main {

    public static void main(String[] args) {

        System.out.println("--------Pruebas de cinematica----------");
        System.out.println("---------------------------------------");

        System.out.println("Cinematica directa");

        double l[] = new double[]{50,50,85};
        double q[] = new double[]{0,0,0};
        Cartesian coord_cartesian;
        ForwardK fk = new ForwardK(l);


        System.out.println("Longitudes de cada piezas : l1 -> "+l[0]+" l2 -> "+l[1]+" l3-> "+l[2]);
        System.out.println("Angulos de evaluacion     : q1 -> "+q[0]+" q2 -> "+q[1]+" q3-> "+q[2]);

        coord_cartesian = fk.getCartesian(q, Angle.DEGREES);

        System.out.println("Coordenadas  X , Y ,Z : "+coord_cartesian.getX() + " , "+ coord_cartesian.getY() + " , "+coord_cartesian.getZ());
        System.out.println("---------------------------------------");
        System.out.println("Cinematica inversa");
        System.out.println("Coordenadas de entrada X,Y y Z : "+coord_cartesian.getX() + " , "+ coord_cartesian.getY() + " , "+coord_cartesian.getZ());

        InverseK ik = new InverseK(l);
        double q2[] = ik.getAngles(new Cartesian(130,0,0),Angle.DEGREES);

        System.out.println("Angulos de fk : q1 -> "+q[0]+" q2 -> "+q[1]+" q3-> "+q[2]);
        System.out.println("Angulos de ik : q1 -> "+q2[0]+" q2 -> "+q2[1]+" q3-> "+q2[2]);

        //TODO hasta aqui

        /**interfaces graficas**/

        frmMain pWindow = new frmMain();
        //PApplet.main(pWindow.getClass());



        /**pruebas sobre la MLP*/

        /*

        int[] layers = new int[]{ 2, 5, 1 };

        MultiLayerPerceptron net = new MultiLayerPerceptron(layers, 0.6, new SigmoidalTransfer());

        for(int i = 0; i < 10000; i++)
        {
            double[] inputs = new double[]{Math.round(Math.random()), Math.round(Math.random())};
            double[] output = new double[1];
            double error;


            if((inputs[0] == inputs[1]) && (inputs[0] == 1))
                output[0] = 1.0;
            else
                output[0] = 0.0;


            System.out.println(inputs[0]+" and "+inputs[1]+" = "+output[0]);

            error = net.backPropagate(inputs, output);
            System.out.println("Error at step "+i+" is "+error);
        }

        System.out.println("\nLearning completed!");

        double[] inputs = new double[]{1.0, 0.0};
        double[] output = net.execute(inputs);

        System.out.println(inputs[0]+" and "+inputs[1]+" = "+Math.round(output[0])+" ("+output[0]+")");
        */


    }
}
