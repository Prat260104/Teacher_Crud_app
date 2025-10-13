abstract class Bank{
    abstract int getbalance();
}
class banka extends Bank{
    int getbalance(){
        return 100;
    }
}
class bankb extends Bank{
    int getbalance(){
        return 200;
    }
}
class bankc extends Bank{
    int getbalance(){
        return 300;
    }
}

public class Question7 {
    public static void main(String[] args) {
        banka b = new banka();
        bankb bb=new bankb();
        bankc bc=new bankc();
        System.out.println(b.getbalance());
        System.out.println(bb.getbalance());
        System.out.println(bc.getbalance());
    }
}
