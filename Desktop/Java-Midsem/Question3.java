public class Question3 {
    int l,b,h;
    public Question3(int l,int b,int h){
        this.l=l;
        this.b=b;
        this.h=h;
    }
    public double getArea(){
        return 0.5*b*h;
    }
    public int getP(){
        return l+b+h;
    }
    public static void main(String[] args) {
       Question3 q = new Question3(3,4 ,5 );
        System.out.println(q.getArea());
        System.out.println(q.getP());
    }
}


