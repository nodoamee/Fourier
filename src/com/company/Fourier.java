package com.company;

import static java.lang.StrictMath.PI;
import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

/**
 * Created by abedaigorou on 15/12/17.
 */
public class Fourier
{
    private final int f=2,n=10000;
    private final double pd=0.2,a=0,b=2*PI;
    private double dx;
    private double sum=0;

    public Fourier() {
        dx = (b - a) / n;
    }


    public double fourierCalc() {
        double sum=0;
        for (double i = 0; i < dx * 101; i += dx) {
            sum = 0;
            for (int j = 1; j < 1001; j++) {
                sum += an(j) * cos(j * i) + bn(j) * sin(i * j);
            }
            sum += an(0) / 2;
        }
        return sum;
    }

    private double F(double x)
    {
        double fx=sin(6*PI*f*x)+sin(2*PI*f*x+2*PI*pd);
        //double fx=sin(4*PI*x);
        //System.out.println(fx);
        return (fx);
    }

    private double an(int n)
    {
        double s=0;
        for(double i=0;i<2*PI;i+=dx) {
            s += F(i) * cos(n * i) * dx;
        }
        return (s/PI);
    }

    private double bn(int n)
    {
        double s=0;
        for(double i=0;i<2*PI;i+=dx)
            s+=F(i)*sin(n * i)*dx;
        return (s/PI);
    }
}
