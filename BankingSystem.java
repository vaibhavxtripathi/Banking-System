import java.util.*;

public class BankingSystem {
    static Scanner sc = new Scanner(System.in);
    static int id = 1;

    public static void main(String[] args) {
        Accounts myacc = null;
        Bank bank = new Bank();
        while (true) {
            System.out.println();
            System.out.println("Banking System");
            System.out.println("Choice:");
            System.out.println("1. Create account");
            System.out.println("2. Use account");
            System.out.println("3. Update account");
            System.out.println("4. Delete account");
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Create a Password: ");
                    int pass = sc.nextInt();
                    sc.nextLine();
                    myacc = new Accounts(name, id, pass);
                    bank.addAccount(myacc);
                    System.out.println("Welcome " + name + " (" + id + "), your account has been created successfully!");
                    System.out.println();
                    id++;
                    break;
                case 2:
                    System.out.print("Enter your ID: ");
                    int id_check = sc.nextInt();
                    System.out.print("Enter your Password: ");
                    int pass_check = sc.nextInt();
                    sc.nextLine();
                    myacc = bank.findAccount(id_check, pass_check);
                    if (myacc != null) {
                        System.out.println("Welcome " + myacc.name + "!");
                        bank.use(myacc);
                    } else {
                        System.out.println("Invalid Details!");
                    }
                    break;
                case 3:
                    System.out.print("Enter your ID: ");
                    int id_check1 = sc.nextInt();
                    System.out.print("Enter your Password: ");
                    int pass_check1 = sc.nextInt();
                    sc.nextLine();
                    myacc = bank.findAccount(id_check1, pass_check1);
                    if (myacc != null) {
                        bank.update(myacc);
                    } else {
                        System.out.println("Invalid Details!");
                    }
                    break;
                case 4:
                    System.out.print("Enter your ID: ");
                    int id_check2 = sc.nextInt();
                    System.out.print("Enter your Password: ");
                    int pass_check2 = sc.nextInt();
                    sc.nextLine();
                    myacc = bank.findAccount(id_check2, pass_check2);
                    if (myacc != null) {
                        bank.deleteAccount(myacc);
                    } else {
                        System.out.println("Invalid Details!");
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
