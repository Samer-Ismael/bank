import java.util.Scanner;
public class SavingAccount {
    final String savingAccountNumber = "789_456_987_1473";
    public static void addToSaving (Account account){
        System.out.println("-------------------------");
        System.out.println("How much money do you want to move to your saving account? ");
        Scanner save = new Scanner(System.in);
        double input = save.nextDouble();
        if (account.balance < input) {
            System.out.println("You don't have enough money in your balance! ");
        } else if (account.balance >= input) {
            account.Saving = account.Saving + input;
            account.balance = account.balance - input;
            Statement.addToList("Saving  ",  input); //This will save this action in a statement list
            System.out.println("Your saving account balance is: " + account.Saving + " kr");
            System.out.println("-------------------------");
        }
    }
    public static void removeFromSaving (Account account){
        System.out.println("-------------------------");
        System.out.println("How much money do you want to remove from your saving account? ");
        Scanner save = new Scanner(System.in);
        double input = save.nextDouble();
        if (account.Saving < input) {
            System.out.println("You don't have enough money! ");
        } else if (account.Saving >= input) {
            account.Saving = account.Saving - input;
            account.balance = account.balance + input;
            Statement.addToList("Saving  ", -input); //This will save this action in a statement list
            System.out.println("Your saving account balance is: " + account.Saving + " kr");
            System.out.println("-------------------------");
        }
    }
}
