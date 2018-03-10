function Q=CinversaAntropo(P0,Lados)
 l1=Lados(1); l2=Lados(2); l3=Lados(3);
 z=P0(1); x=P0(2); y=P0(3);
 h=sqrt(z^2+x^2);
 c=sqrt(h^2+(y-l1)^2);
 gama=atan2d((y-l1),h);
 alfa=acosd((l2^2+c^2-l3^2)/(2*l2*c+1e-9));
 q1=atan2d(x,z);
 q2=gama-alfa;
 q3=acosd((c^2-l2^2-l3^2)/(2*l2*l3));
 Q=[q1,q2,q3];
end