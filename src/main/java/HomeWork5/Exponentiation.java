package HomeWork5;

public class Exponentiation {

    public static void main(String[] args) {
        System.out.println(exponentiation(2,-4));
    }

    public static double exponentiation (int number, int power) {
       if (number == 0) return 0;
       else if (power == 1) return number;
       else if (power > 0){
           return (number*exponentiation(number,power-1));
       }
       else if (power != 0){
           return 1./number*exponentiation(number, power+1);
       }
       else{
           return 1;
       }
    }

}
