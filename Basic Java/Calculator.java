class Calci{
    double n1,n2;

    public Calci(double n1, double n2){
        this.n1 = n1;
        this.n2 = n2;
    }

    double add(){
        return n1+n2;
    } 
    
    double subtract(){
        return n1-n2;
    } 
    
    double multiply(){
        return n1*n2;
    } 
    
    double divide(){
        return n1/n2;
    } 
}

public class Calculator {
    public static void main(String[] args){
        Calci c = new Calci(20, 10);
        System.out.println(c.add());
        System.out.println(c.subtract());
        System.out.println(c.multiply());
        System.out.println(c.divide());
    }
}
