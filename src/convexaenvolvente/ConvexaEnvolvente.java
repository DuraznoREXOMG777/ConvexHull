/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convexaenvolvente;

import java.util.Arrays;

/**
 *
 * @author Yue
 */
public class ConvexaEnvolvente {

    public Point[] ordenarHull(Point[] points){
        if(points.length>=3 && orientation(points[0], points[1], points[2])!=0){ //Se necesitan 3 puntos y no ser colineares.
            Point tmp;
            StackListaLigadaGeneralizado stack=new StackListaLigadaGeneralizado<Point>(); //Estructura más simple.
            Ordenamientos ord=new Ordenamientos<Point>(); //Clase de ordenamientos.
            int l; //
            l=findMinimumY(points); //Encuentra la Y más pequeña.
            for(int i = 0; i < points.length; i++)//Va a obtener todos los angulos.
                points[i].setAngulo(points[l]);
            ord.bubbleSort(points); //Ordenamos todos los puntos en torno a mi Y mínima.
            stack.push(points[0]);
            stack.push(points[1]);
            stack.push(points[2]); //Tecnicamente estos están orientados bien.
            for (int i = 3; i < points.length; i++) {
                tmp=(Point) stack.pop();
                if(orientation((Point)stack.top(),tmp, points[i])==2){
                    stack.push(tmp);
                    stack.push(points[i]);
                }
            }
            Point[] result=new Point[stack.getTamano()];
            StackListaLigadaGeneralizado stack2=new StackListaLigadaGeneralizado<Point>(stack); //Copia del Stack
            for (int i = 0; i < result.length; i++)
                result[i]= (Point) stack2.pop();
            return result;
        }
        return null;
    }
    
    private int findMinimumY(Point[] points){
        int l=0;
        for (int i = 1; i < points.length; i++)  //Loop para recorrer todos los puntos.
                if((i+1)<points.length && points[l].getY()>=points[i].getY()) //Condición que me busca el menor.
                    l=i;
        return l;
    }
    
    private int orientation(Point p1, Point p2, Point p3){ //Si son colineares.. no sé que hacer
        double or;
        or = (((p2.getY()-p1.getY())*(p3.getX()-p2.getX()))-((p3.getY()-p2.getY())*(p2.getX()-p1.getX())));
        if(or==0)  //Son colineares.
            return 0;
        return (or>0)?1:2;  //Si es positivo es Clockwise, si no, Counterclockwise
    }
    
    private boolean CCW(Point p, Point q, Point r){ //Counterclockwise
        double val = (q.getY() - p.getY()) * (r.getX() - q.getX()) - (q.getX() - p.getX()) * (r.getY() - q.getY()); //Producto cruz. Vectorial
         if (val >= 0)
             return false;
         return true;
    }
    
    public Point[] convexHull(Point[] points){
        if (points.length < 3) //Mínimo se usan tres puntos para el Convex Hull.
            return null;     
        int[] chull = new int[points.length]; //Pude haber usado una pila, jmmm.
        Arrays.fill(chull, -1); //Vamos a rellenar para que no nos queden espacios nulos y den error al final.
        int xMin = 0;
        for (int i = 1; i < points.length; i++)
            if (points[i].getX() < points[xMin].getX()) //Encontrar la menor X
                xMin = i;
        int p = xMin, q;
        do{
            q = (p+1)%points.length;  //Se utiliza para tomar un punto aleatorio sin tomar el mismo.
            for (int i = 0; i < points.length; i++)
              if (CCW(points[p], points[i], points[q]))
                 q = i;
            chull[p] = q;  
            p = q; 
        } while (p!= xMin); //Loop hasta que el último punto sea el inicial.
        int l=0;
        for (int i = 0; i < chull.length; i++) //Obtener tamaño del arreglo.
            if(chull[i]!=-1)
                l++;
        Point[] point=new Point[l];
        int j=0;
        for (int i = 0; i < chull.length; i++) {
            if(chull[i]!=-1)
                point[j++]=points[i];
        }
        point=ordenarHull(point);
        for (Point point1 : point) 
            System.out.println(point1);
        return point;
    }
    
    public static void main(String[] args) {
        Point[] points;
        points = new Point[7];
        points[0]=new Point(2,3);
        points[1]=new Point(5,1);
        points[2]=new Point(9,2);
        points[3]=new Point(5,6);
        points[4]=new Point(7,5);
        points[5]=new Point(1,2);
        points[6]=new Point(3,6);
        ConvexaEnvolvente ce=new ConvexaEnvolvente();
        ce.convexHull(points);
    }
}
