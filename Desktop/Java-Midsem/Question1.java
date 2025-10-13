public class Question1 {
    int length;
    int breadth;
    public void setDim(int l,int b){
        this.length=l;
        this.breadth=b;
    }
    public int getArear(){
        return length*breadth;
    }
    public static void main(String[] args) {
        Question1 q = new Question1();
        q.setDim(20, 30);
        System.out.println(q.getArear());
    }
}
