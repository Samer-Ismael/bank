import java.util.ArrayList;
public class Statement {
    static ArrayList <String> statement = new ArrayList<>();
    public static void addToList (String text, double amount){
        //HashMap can also work here !
        statement.add(String.valueOf(amount));
        statement.add(String.valueOf(text));
    }
    public static void printStatement(Account account, Credit credit){
        // This will print every 2 items in one line :)
        // it will work because we are adding two items to the list at the time(text and amount).
        System.out.println("----------------------");
        for (int i = 0; i < statement.size(); i += 2){ // To skip one item in the loop (AI)
            String item1 = statement.get(i);
            String item2 = statement.get(i + 1);
            System.out.println(item2 + " --> " + item1);
        }
        Account.seeBalance(account,credit);
        System.out.println("----------------------");
    }
}
