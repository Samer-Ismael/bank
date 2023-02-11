import java.util.Scanner;
public class Bank {
    public static void main(String[] args) {

        Account account = new Account();
        Credit credit = new Credit();
        MasterCard card = new MasterCard();
        SavingAccount saving = new SavingAccount();

        Account.login();
        try {
            startAsking(account, credit, card, saving);
        } catch (Exception e){
            //This will not allow writing letters instead of numbers and will start the program over.
            System.out.println("Please enter a number!");
            System.out.println("----------------------");
            startAsking(account, credit, card, saving);
        }
    }
    public static void startAsking (Account account, Credit credit, MasterCard card, SavingAccount saving){
        System.out.println("Welcome to SAM Bank");
        System.out.println("----------------------");
        while (true){
            System.out.println("What do you want to do ? ");
            System.out.println("1- MasterCard Payment:");
            System.out.println("2- Manage your account");
            System.out.println("3- Print account statement. ");
            System.out.println("4- Exit the program.");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();

            if (answer == 1){
                MasterCard.cardPayment(account, credit, card);
            } else if (answer == 2) {
                Account.moneyManagement(account, credit, saving);
            } else if (answer == 3) {
                Statement.printStatement(account,credit);
            } else if (answer == 4) {
                System.out.println("See ya!");
                break;
            }
        }
    }
}
