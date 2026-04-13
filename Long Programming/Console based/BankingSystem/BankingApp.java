import java.util.*;

public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        Set<Transaction> transactions = new HashSet<>();
        while (true) {

            System.out.print("<---------------------------WELCOME TO ABINESH BANK------------------------> : ");
            System.out.println("\n1).Create Account \n 2).Deposit\n 3).Withdrawal\n 4).Transfer\n 5).Show History\n 6).Show Balance\n 7).Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.println("Enter Your Name:");
                String name = sc.nextLine();
                System.out.println("Enter Your Mobile No:");
                String mobileNo = sc.nextLine();
                while (mobileNo.length() != 10) {
                    System.out.println("Invalid Mobile No");
                    System.out.println("Enter Your Mobile No:");
                    mobileNo = sc.nextLine();
                }
                System.out.println("Enter Your Aathar Number:");
                String aatharNo = sc.nextLine();
                while (aatharNo.length() != 12) {
                    System.out.println("Invalid Aathar No");
                    System.out.println("Enter Your Aathar Number:");
                    aatharNo = sc.nextLine();
                }
                String accountNo = Integer.toString((int) (Math.random() * 1000) + 1);
                System.out.println("Your Account Number: " + accountNo);

                accounts.put(accountNo, new Account(name, mobileNo, aatharNo, accountNo));
                System.out.println("Your Account is Created ");


            } else if (choice == 2) {
                System.out.println("Enter Your Account No:");
                String accountNo = sc.nextLine();

                if (accounts.containsKey(accountNo)) {

                    System.out.println(" Enter Deposit Amount: ");
                    double deposit = sc.nextDouble();
                    Account account = accounts.get(accountNo);
                    account.Deposit(deposit);
                    System.out.println("Amount Deposited Successfully to Account " + accountNo);
                    System.out.println("Your Current Balance : " + account.getBalance());
                } else {
                    System.out.println("Account Not Found");
                }
            } else if (choice == 3) {
                System.out.println("Enter Your Account No:");
                String accountNo = sc.nextLine();
                if (!accounts.containsKey(accountNo)) {
                    System.out.println("Account Not Found");
                } else {
                    System.out.println(" Enter Withdrawal Amount: ");
                    double withdrawal = sc.nextDouble();
                    Account account = accounts.get(accountNo);
                    account.Withdrawal(withdrawal);
                    System.out.println("Your Current Balance : " + account.getBalance());
                }
            } else if (choice == 4) {
                System.out.println("Enter Sender Account No:");
                String SenderAccountNo = sc.nextLine();
                System.out.println("Enter Receiver Account Name:");
                String ReceiverAccountNo = sc.nextLine();
                if ((!accounts.containsKey(SenderAccountNo)) || (!accounts.containsKey(ReceiverAccountNo))) {
                    System.out.println("Account Not Found\nTry Again...........");
                } else {
                    Account a1 = accounts.get(SenderAccountNo);
                    Account a2 = accounts.get(ReceiverAccountNo);
                    System.out.println("Enter Amount  to Transfer");
                    double amount = sc.nextDouble();
                    transactions.add(new Transaction(a1, a2, amount));
                }
            } else if (choice == 5) {
                for (Transaction t : transactions) {
                    t.showHistory();
                }
            } else if (choice == 6) {
                System.out.println("Enter Your Account No:");
                String accountNo = sc.nextLine();
                Account account = accounts.get(accountNo);
                System.out.println("Account balance: " +account.getBalance() );
            } else if(choice == 7) {
                System.out.println("Thank you for using BankingApp........");
                break;
            }else{
                System.out.println("Invalid choice");
                System.out.println("try again");
            }


        }
    }
}
