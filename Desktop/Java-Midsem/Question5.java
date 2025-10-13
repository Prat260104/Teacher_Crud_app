import java.util.Scanner;

class Complex {
    double re, im;

    Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    Complex add(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    Complex subtract(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    Complex multiply(Complex c) {
        double real = re * c.re - im * c.im;
        double imag = re * c.im + im * c.re;
        return new Complex(real, imag);
    }

    public String toString() {
        return re + " + " + im + "i";
    }
}

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first complex number (re im): ");
        double r1 = sc.nextDouble(), i1 = sc.nextDouble();
        System.out.print("Enter second complex number (re im): ");
        double r2 = sc.nextDouble(), i2 = sc.nextDouble();

        Complex c1 = new Complex(r1, i1);
        Complex c2 = new Complex(r2, i2);

        System.out.println("Sum: " + c1.add(c2));
        System.out.println("Difference: " + c1.subtract(c2));
        System.out.println("Product: " + c1.multiply(c2));
    }
}
