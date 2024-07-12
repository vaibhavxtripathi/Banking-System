import java.util.*;

public class Bank {
    Scanner sc = new Scanner(System.in);
    public static ArrayList<Accounts> acc_info = new ArrayList<>();

    public void addAccount(Accounts account) {
        acc_info.add(account);
    }

    public Accounts findAccount(int id, int pass) {
        for (Accounts account : acc_info) {
            if (account.id == id && account.pass == pass) {
                return account;
            }
        }
        return null;
    }

    public Accounts findAccountforTransfer(String name, int id) {
        for (Accounts account : acc_info) {
            if (account.id == id && account.name.equals(name)) {
                return account;
            }
            else{
                System.out.println("User does not exist!");
                break;
            }
        }
        return null;
    }


    public void use(Accounts ac) {
        while (true) {
            System.out.println("Choice:");
            System.out.println("1. Transfer Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Fetch Current balance");
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the account holder: ");
                    String name_ch = sc.nextLine();
                    System.out.print("Enter the ID of the account holder: ");
                    int id_ch = sc.nextInt();
                    sc.nextLine();
                    Accounts account = findAccountforTransfer(name_ch, id_ch);
                    System.out.print("Enter the amount of money to transfer: ");
                    double money = sc.nextDouble();
                    
                    if (money > ac.money){

                    System.out.println("Itna to hai bhi nahi bhai!");
                    }
                    else{
                        ac.money-=money;
                        account.money+=money;
                        System.out.println("Transferred " + money + " to " + name_ch + " (" + id_ch + ")");
                        System.out.println("Your updated balance is "+ ac.money);
                    }
                    
                    break;

                case 2:
                    System.out.print("Enter the amount of money: ");
                    double mon = sc.nextDouble();
                    sc.nextLine();  
                    ac.money += mon;
                    System.out.println("Your updated balance is: " + ac.money);
                    break;

                case 3:
                    System.out.print("Enter the amount of money to withdraw: ");
                    double mon1 = sc.nextDouble();
                    sc.nextLine();  
                    if (mon1 > ac.money) {
                        System.out.println("Insufficient balance!");
                    } else {
                        ac.money -= mon1;
                        System.out.println(mon1 + " withdrawn successfully!");
                        System.out.println("Your updated balance is: " + ac.money);
                    }
                    break;

                case 4:
                    System.out.println("Your current balance is: " + ac.money);
                    break;
                    
                case 5:
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public void update(Accounts ac) {
        System.out.println("Your current information is: \nAccount " + ac.id + "\n1. Name: " + ac.name + "\n2. Password: " + ac.pass);
        System.out.print("What do you want to update? : ");
        int choice = sc.nextInt();
        sc.nextLine();  
        switch (choice) {
            case 1:
                System.out.print("Enter a new name: ");
                String name = sc.nextLine();
                ac.name = name;
                break;
            case 2:
                System.out.print("Enter a new password: ");
                int pass = sc.nextInt();
                sc.nextLine();  
                ac.pass = pass;
                break;
            default:
                System.out.println("Invalid Choice!");
        }
        System.out.println("Your updated information is: \nAccount: " + ac.id + "\n1. Name: " + ac.name + "\n2. Password: " + ac.pass);
    }

    public void deleteAccount(Accounts ac) {
        acc_info.remove(ac);
        System.out.println("Account " + ac.id + " has been deleted successfully!");
    }
}
