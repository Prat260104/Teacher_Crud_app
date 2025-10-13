public class Question4 {
    int l,b;
    public Question4(int l,int b){
        this.l=l;
        this.b=b;
    }
    public int getarea(){
        return l*b;
    }
    public static void main(String[] args) {
        Question4 q1 = new Question4(4, 5);
        Question4 q2 = new Question4(5, 8);
        System.out.println(q1.getarea());
        System.out.println(q2.getarea());
    }
}
