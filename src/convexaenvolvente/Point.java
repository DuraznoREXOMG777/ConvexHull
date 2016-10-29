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
public class Point implements Comparable{
    private double x,y, angulo;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setAngulo(Point point) { //Point es el punto base. El punto inicial es y1.
        double yabs=y-point.getY();
        double xabs=x-point.getX();
        if(x<0)
            angulo=180+Math.toDegrees(Math.atan2(yabs,xabs));
        angulo=Math.toDegrees(Math.atan2(yabs,xabs));
    }
    
    public double getAngulo(){
        return angulo;
    }

    @Override
    public int compareTo(Object o) {
        Point tmp=(Point) o;
        if(angulo>tmp.getAngulo())
            return 1;
        else if(angulo==tmp.getAngulo())
            return 0;
        return -1;
    }

    @Override
    public String toString() {
        return "{" + "x=" + x + ", y=" + y + '}';
    }
}
