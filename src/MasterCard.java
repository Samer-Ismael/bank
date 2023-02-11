import java.util.Scanner;
public class MasterCard {
    final String cardNumber = "123_321_123_1369";
    public static void cardPayment (Account account, Credit credit, MasterCard card1){
        System.out.println( "Card number : " + card1.cardNumber);
        System.out.println("----------------------");
        System.out.println("How much do you want to pay? ");
        Scanner pay = new Scanner(System.in);
        double input = pay.nextDouble();
        if (account.balance - input < credit.creditLimit) {
            System.out.println("You don't have enough credit! Your max credit is: " + -credit.creditLimit);
        } else if (account.balance - input >= credit.creditLimit) {
            if (input < 150){ // Will not ask for Pin code for payment less than 150kr
                System.out.print("Your balance is: ");
                account.balance = (account.balance - input);
                System.out.println(account.balance + " kr");
                Statement.addToList("Payment ", -input); //This will save this action in a statement list
                System.out.println("-------------------------");
            } else if (input >= 150) { //Pin code needed for payment over 150kr
                pinCode();
                System.out.print("Your balance is: ");
                account.balance = (account.balance - input);
                System.out.println(account.balance + " kr");
                Statement.addToList("Payment ", -input); //This will save this action in a statement list
                System.out.println("-------------------------");
            }
        }
    }
    public static void pinCode (){
        String pin = "1234";
        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.print("Your PIN code: ");
            String input = scan.next();
            if (input.contains(pin)){
                break;
            } else {
                System.out.println("Wrong code! try again:  ");
                System.out.println("-------------------------");
            }
        }
    }
}
