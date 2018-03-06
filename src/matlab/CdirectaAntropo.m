
function P0=CdirectaAntropo(Q,Lados)

l1=Lados(1); l2=Lados(2); l3=Lados(3);
q1=Q(1); q2=Q(2); q3=Q(3);
h=l2*cosd(q2)+l3*cosd(q2+q3);
c=sqrt(l2^2+l3^2+2*l2*l3*cosd(q3));
z=h*cosd(q1); 
x=h*sind(q1);
y=l1+l2*sind(q2)+l3*sind(q2+q3);
P0=[x,y,z];
end