import java.util.*;
public class ATM{
    private static ArrayList<String> transactions = new ArrayList();
    static Scanner s = new Scanner(System.in);
    static User currentuser;
    public static void main(String[] args) {
        transactions.add("-1000");
        transactions.add("+10000");
        transactions.add("-782");
        transactions.add("+500");
        transactions.add("-362"); 
        System.out.printf("Please register yourself:\n");
        regitsterUser();
        System.out.printf("Please login\n");
        if (authenticateUser()) {
            System.out.printf("Login successful!\n");
            menu();
        } else {
            System.out.printf("Invalid credentials!\n");
        }
    }
    static void regitsterUser(){
        System.out.printf("Enter Name:\n");
        String name = s.nextLine();
        System.out.printf("Enter Pin:\n");
        String pin = s.nextLine();
        currentuser = new User(name, pin);
    }

    static boolean authenticateUser(){
        System.out.printf("Enter User ID:\n");
        String userid = s.nextLine();
        System.out.printf("Enter PIN:\n");
        String userpin = s.nextLine();
        return userid.equals(currentuser.getname()) && userpin.equals(currentuser.getpin());

    }
    private static void withdraw(){
        System.out.printf("Enter the amount to be withdrawn:\n");
        int amount = s.nextInt();
        if(amount <= currentuser.balance){
            currentuser.balance -= amount;
            System.out.println("Transaction successful. Withdrawn amount: " + amount);
            System.out.println("Current balance: " + currentuser.getbalance()); 
            transactions.add("-" + amount);        
        }
        else{
            System.out.printf("Insufficient balance.\n");
        }
    }
    private static void deposit(){
        System.out.printf("Enter the amount to be deposited:\n");
        int amount = s.nextInt();
        if(amount > 0){
            currentuser.balance += amount;
            System.out.println("Transaction successful. Deposited amount: " + amount);
            System.out.println("Current balance: " + currentuser.getbalance());
            transactions.add("+" + amount);          
        }
        else{
            System.out.printf("Invalid amount entered.\n");
        }
    }
    private static void transfer() {
        System.out.printf("Enter the account number (consisting of 12 digits):\n");
        String account = s.next();  
        int length = account.length();
        if (length == 12) {
            System.out.println("Enter amount to be transferred:");
            int amount = s.nextInt();
            if (amount > 0 && amount <= currentuser.balance) { 
                currentuser.balance -= amount;
                System.out.println("Transfer successful. Transferred amount: " + amount);
                System.out.println("Current balance: " + currentuser.getbalance());
                transactions.add("-" + amount); 

            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        } else {
            System.out.println("Invalid Account Number entered.");
        }
    }
    private static void transaction(){
        System.out.println("Transaction history:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
    static void menu(){
        int option;
        do {
        System.out.printf("-----------ATM-----------\n");
        System.out.printf("Please enter your choice\n");
        System.out.printf("1.Display Transaction History\n");
        System.out.printf("2.Withdraw Money\n");
        System.out.printf("3.Deposit Money\n");
        System.out.printf("4.Transfer Money\n");
        System.out.printf("5.Exit\n");
        option = s.nextInt();

            switch (option) {
                case 1-> transaction();
                case 2-> withdraw();
                case 3-> deposit();
                case 4-> transfer();
                case 5-> System.out.println("Thank you for using the ATM.");
                default-> System.out.println("Invalid option. Please try again.");
            }
          }while (option != 5);  
        }
}


class User{
    String name;
    String pin;
    double balance;
    public User(String name, String pin){
        this.name = name;
        this.pin = pin;
        this.balance = 8782;
    }
    public String getname(){
        return name;
    }
    public String getpin(){
        return pin;
    }
   public double getbalance(){
    return balance;
   }
}