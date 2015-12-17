package com.company;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Scanner;

import static java.lang.StrictMath.PI;
import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

public class Main {
    private final static int f=2,n=10000;
    private final static double pd=0.2,a=0,b=2*PI;
    private static double dx;
    private static double sum=0;
    private static Scanner scan=new Scanner(System.in);

    public static void main(String[] args) {
        dx=(b-a)/n;
        //System.out.println(dx);
        //System.out.println(integral(a,b,dx));
        //System.out.println(an(0));
        //System.out.println(bn(0));

        for(double i=0;i<dx*101;i+=dx)
        {
            //double i=scan.nextInt();
            sum=0;
            for(int j=1;j<1001;j++)
            {
                sum+=an(j)*cos(j*i)+bn(j)*sin(i*j);
            }
            sum+=an(0)/2;
            //System.out.println("a0:"+an(0)+"a0/2:"+an(0)/2);
            System.out.println("sum:"+sum);
            System.out.println("F("+i+")"+F(i));
        }
    }

    private static double F(double x)
    {
        double fx=sin(6*PI*f*x)+sin(2*PI*f*x+2*PI*pd);
        //double fx=sin(4*PI*x);
        //System.out.println(fx);
        return (fx);
    }

    private static double integral(double a,double b,double dx)
    {
        double sum=0;
        for(double i=a;i<b;i+=dx)
            sum+=F(i)*dx;
        return sum;
    }

    private static double an(int n)
    {
        double s=0;
        for(double i=0;i<2*PI;i+=dx) {
            s += F(i) * cos(n * i) * dx;
        }
        return (s/PI);
    }

    private static double bn(int n)
    {
        double s=0;
        for(double i=0;i<2*PI;i+=dx)
            s+=F(i)*sin(n * i)*dx;
        return (s/PI);
    }


}

