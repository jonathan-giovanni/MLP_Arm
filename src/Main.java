import coordinates.Angle;
import coordinates.Cartesian;
import kinematics.ForwardK;
import kinematics.InverseK;
import processing.core.PApplet;

public class Main {

    public static void main(String[] args) {

        //TODO se puede modificar todo esto
        System.out.println("--------Pruebas de cinematica----------");
        System.out.println("---------------------------------------");

        System.out.println("Cinematica directa");
        double l[] = new double[]{66,70,62};
        double q[] = new double[]{45,0,0};
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
        double q2[] = ik.getAngles(coord_cartesian,Angle.DEGREES);

        System.out.println("Angulos de fk : q1 -> "+q[0]+" q2 -> "+q[1]+" q3-> "+q[2]);
        System.out.println("Angulos de ik : q1 -> "+q2[0]+" q2 -> "+q2[1]+" q3-> "+q2[2]);

        //TODO hasta aqui
        PApplet.main(new String[]{"gui.Window"});
    }
}
