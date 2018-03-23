function Q=Cinversa2(P,Lados)

l1=Lados(1); l2=Lados(2); l3=Lados(3);
px=P(1); py=P(2); pz=P(3);

r  = sqrt(px^2 + py^2);
d  = sqrt( (pz - l1)^2 + r^2 );
q1 = atan2d(px,py);
q3 = acosd( (d^2 - l3^2 - l2^2)/(2*l2*l3));
q2 = atan2d(r,pz-l1) - atan2d(l2 + l3*cosd(q3),l3*sind(q3));

Q=[q1,-q2,q3];
end