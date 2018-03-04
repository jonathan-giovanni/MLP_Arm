function P0=CinematicaDirecta(Q,Lados)
l1=Lados(1); l2=Lados(2); l3=Lados(3);
q1=Q(1); q2=Q(2); q3=Q(3);
h=l2*cos(q2)+l3*cos(q2+q3);
c=sqrt(l2^2+l3^2+2*l2*l3*cos(q3));
x=h*cos(q1);
y=h*sin(q1);
z=l1+l2*sin(q2)+l3*sin(q2+q3);
P0=[x,y,z];