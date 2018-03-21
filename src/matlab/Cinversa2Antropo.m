function Q2=Cinversa2Antropo(PO)
 F=50;
 T=70;
 x = PO(1);
 y = PO(2);
 z = PO(3);
 L = sqrt(y^2 +x^2);
 dia =  sqrt(z^2+L^2);
 alfa = pi/2 - atan2(L,z) + acos(T^2-F^2- dia^2) / (-2*F*dia);
 beta = -pi + acos((dia^2-T^2-F^2) / (-2*F*T));
% gama = atan2(y,x);
 q1 = alfa;
 q2 = beta;
 Q2=[q1,q2];
end