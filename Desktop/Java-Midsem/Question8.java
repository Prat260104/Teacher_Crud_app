abstract class Marks{
    abstract double getpercentage();
}

class A extends Marks{
    double m1,m2,m3;
    A(double m1,double m2,double m3){
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
    }
    double getpercentage(){
        return (m1+m2+m3)/2;
    }
}
class B extends Marks{
    double m1,m2,m3,m4;
    B(double m1,double m2,double m3,double m4){
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
        this.m4=m4;
    }
    double getpercentage(){
        return (m1+m2+m3+m4)/2;
    }
}
public class Question8 {
    public static void main(String[] args) {
        A a = new A(10,30,50);
        B b = new B(100, 80, 70, 40);
        System.out.println(a.getpercentage());
        System.out.println(b.getpercentage());
    }
}
