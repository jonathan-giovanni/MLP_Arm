function R=pruebasCinematica()
L = [50,50,70]; 
for i=0:1:25
   disp('Angulos ') 
   Q = [i+0.25,i+0.5,i];
   disp(Q);
   disp('Cinematica directa');
   P = Cdirecta2(Q,L);
   disp(P);
   disp('Cinematica inversa');
   Q2 = Cinversa2(P,L);
   disp(Q2);
   disp('------------------------')
end


R=0;
end