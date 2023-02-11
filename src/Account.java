import java.util.Scanner;
public class Account {
    final String accountNumber = "654_456_654_3693";
    double balance = 0;
    double Saving = 0;
    public static void moneyManagement (Account account, Credit credit, SavingAccount saving){
        Scanner scan = new Scanner(System.in);
        System.out.println("Account number: " + account.accountNumber) ;
        System.out.println("----------------------");
        System.out.println("1- to see balance.");
        System.out.println("2- to deposit money. ");
        System.out.println("3- to withdraw. ");
        System.out.println("4- to save money. ");
        System.out.println("5- to remove money from saving account. ");
        int input = scan.nextInt();

        if (input == 1) {
            seeBalance(account, credit);
        } else if (input == 2) {
            deposit(account);
        } else if (input == 3) {
            withdraw(account, credit);
        } else if (input == 4) {
            System.out.println( "Saving account number: " + saving.savingAccountNumber);
            System.out.println("----------------------");
            SavingAccount.addToSaving(account);
        } else if (input == 5) {
            System.out.println("Saving account number: " + saving.savingAccountNumber);
            System.out.println("----------------------");
            SavingAccount.removeFromSaving(account);
        }
    }
    public static void withdraw (Account account, Credit credit){
        System.out.println("-------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("How much do you want to withdraw? ");
        double input = scan.nextDouble();
        if (account.balance - input < -500) { // Will not allow withdrawal more than 500kr from credit
            System.out.println("You're trying to withdraw from the credit! over 500 kr is not allowed!");
        } else if (account.balance - input >= credit.creditLimit) {
            MasterCard.pinCode();
            account.balance = (account.balance - input);
            System.out.print("Withdrawal is successful! Your balance is: ");
            System.out.println(account.balance + " kr");
            Statement.addToList("Withdraw", -input); //This will save this action in a statement list
            System.out.println("-------------------------");
        }
    }
    public static void deposit (Account account){
        System.out.println("-------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("How much do you want to deposit? ");
        double input = scan.nextDouble();
        account.balance = (account.balance + input);
        System.out.print("Deposit is successful! Your balance is: ");
        System.out.println(account.balance + " kr");
        Statement.addToList("Deposit ",  input); //This will save this action in a statement list
        System.out.println("-------------------------");
    }
    public static void seeBalance (Account account, Credit credit){
        System.out.println("-------------------------");
        System.out.print("Your balance is: ");
        System.out.println(account.balance + " kr");
        System.out.print("Your saving account balance is: ");
        System.out.println(account.Saving + " kr");
        System.out.print("Your credit is: ");
        if (account.balance >= 0){  //This will make sure that credit is always att the credit limit
            System.out.println(- credit.creditLimit + " kr");
            System.out.println("-------------------------");
        }else if (account.balance < 0){  // This will show the left credit if the balance is minus
            System.out.println( account.balance - credit.creditLimit + " kr");
            System.out.println("-------------------------");
        }
    }
    public static void login (){
        String Username = "Name";
        String Password = "Pass";
        System.out.println("Enter your username and password to login! ");
        while (true){
        Scanner scan = new Scanner(System.in);
        System.out.print("Username: ");
        String input1 = scan.next();
        System.out.print("Password: ");
        String input2 = scan.next();
            if (input1.contains(Username) && input2.contains(Password)){
                System.out.println("Login success! ");
                System.out.println("-------------------------");
                break;
            } else {
                System.out.println("Wrong username or password! Sorry ");
            }
        }
    }
}
