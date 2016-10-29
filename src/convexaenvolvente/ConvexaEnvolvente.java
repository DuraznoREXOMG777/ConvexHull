/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convexaenvolvente;

/**
 *
 * @author Yue
 */
public class ConvexaEnvolvente {

    public void convexHull(Point[] points){
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
            stack.showLista();
        }
    }
    
    public int findMinimumY(Point[] points){
        int l=0;
        for (int i = 1; i < points.length; i++)  //Loop para recorrer todos los puntos.
                if((i+1)<points.length && points[l].getY()>=points[i].getY()) //Condición que me busca el menor.
                    l=i;
        return l;
    }
    
    public int orientation(Point p1, Point p2, Point p3){ //Si son colineares.. no sé que hacer
        double or;
        or = (((p2.getY()-p1.getY())*(p3.getX()-p2.getX()))-((p3.getY()-p2.getY())*(p2.getX()-p1.getX())));
        if(or==0)  //Son colineares.
            return 0;
        return (or>0)?1:2;  //Si es positivo es Clockwise, si no, Counterclockwise
    }

    public ConvexaEnvolvente() {
    }
    
    public static void main(String[] args) {
        Point[] points;
        points = new Point[10];
        points[0]=new Point(1,2);
        points[1]=new Point(4,5);
        points[2]=new Point(6,4);
        points[3]=new Point(5,8);
        points[4]=new Point(3,3);
        points[5]=new Point(2,6);
        points[6]=new Point(7,0);
        points[7]=new Point(3,-1);
        points[8]=new Point(5,1);
        points[9]=new Point(7,6);
        ConvexaEnvolvente ce=new ConvexaEnvolvente();
        ce.convexHull(points);
    }
}
