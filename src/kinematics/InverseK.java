package kinematics;

public class InverseK {

    /*

    //Codigo de TestArmTesis ik processing
    double F = 50;
    double T = 70;
    double millisOld, gTime, gSpeed = 8;

    void IK(){

        float X = posX;
        float Y = posY;
        float Z = posZ;

        float L = sqrt(Y*Y+X*X);
        float dia = sqrt(Z*Z+L*L);

        alpha = Math.PI/2-(atan2(L, Z)+acos((T*T-F*F-dia*dia)/(-2*F*dia)));
        beta = -PI+acos((dia*dia-T*T-F*F)/(-2*F*T));
        gamma = atan2(Y, X);

    }

    void setTime(){
        gTime += ((float)millis()/1000 - millisOld)*(gSpeed/4);
        if(gTime >= 4)  gTime = 0;
        millisOld = (float)millis()/1000;
    }

    void writePos(){
        IK();
        setTime();
        posX = sin(gTime*PI/2)*20;
        posZ = sin(gTime*PI)*10;
    }
    */
}
