import coordinates.Angle;
import coordinates.Cartesian;
import kinematics.ForwardK;

public class Main {

    public static void main(String[] args) {
        System.out.println("--------Pruebas de cinematica----------");
        System.out.println("Cinematica directa");


        double l[] = new double[]{2,2,2};
        double q[] = new double[]{90,0,0};
        double orientacion;
        Cartesian coord_cartesian;
        ForwardK fk = new ForwardK(l);

        System.out.println("Longitudes de cada piezas : l1 -> "+l[0]+" l2 -> "+l[1]+" l3-> "+l[2]);
        System.out.println("Angulos de evaluacion     : q1 -> "+q[0]+" q2 -> "+q[1]+" q3-> "+q[2]);

        coord_cartesian = fk.getCartesian(q, Angle.DEGREES);
        orientacion = fk.getOrientation();

        System.out.println("Coordenadas X,Y y Orientacion : "+coord_cartesian.X + " , "+ coord_cartesian.Y + " , "+orientacion);




    }
}
