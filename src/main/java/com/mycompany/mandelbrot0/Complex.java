package com.mycompany.mandelbrot0;

/**
 *
 * @author katie
 */
public class Complex {
    
    double real, imaginary;
    
    Complex(){   
        real = 0;
        imaginary = 0;
    }
    
    Complex(double tempReal, double tempImaginary){
        real = tempReal;
        imaginary = tempImaginary;
    }
    
    public Complex sum(Complex c2){
        return new Complex(this.real + c2.real, this.imaginary + c2.imaginary);
    }
    
    public Complex product(Complex C2){
        return new Complex(this.real*C2.real - this.imaginary*C2.imaginary, this.real*C2.imaginary + this.imaginary*C2.real);   
    }
    
    public double mag(){
        return Math.sqrt((this.real*this.real) + (this.imaginary*this.imaginary));
    }
    
    public String toString(){ 
        return real + " + " + imaginary + "i";
    } 
    
    public double getReal(){
        return this.real;
    }
    
    public double getImaginary(){
        return this.imaginary;
    }
}
