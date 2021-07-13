/**
 * @author Hasan Semih Aktaş, <hsemihaktas@gmail.com>
 * @since 20.03.2021 15.00
 */

import java.util.Scanner;

public class Quadratic{

    double a,b,c,x1,x2;

    public double getX1(){
        return x1;
    }
    public double getX2(){
        return x2;
    }
    public double getDiscriminant() {
        return b*b-4*a*c;
    }
    public Quadratic(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
        double d=getDiscriminant();

        x1 = (-b + Math.sqrt(d)) / (2 * a);
        x2 = (-b - Math.sqrt(d)) / (2 * a);

    }
    public void quadraticPrint(double a,double b,double c){
        double d=getDiscriminant();
        if(d<0){
            System.out.println("The equation has no root in the set of real numbers!");
        }
        else if(d==0){
            System.out.println("x1: "+x1);
        }
        else{
            System.out.println("x1: "+x1);
            System.out.println("x2: "+x2);
        }
    }
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        Quadratic q=new Quadratic(a, b, c);
        q.quadraticPrint(a,b,c);
    }
}
