public class Account {
    private String name;
    private String mobileNo;
    private String aatharNo;
    private String accountNo;
    private double balance;

     Account(String name,String mobileNo,String aatharNo,String accountNo) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.aatharNo = aatharNo;
        this.accountNo = accountNo;
     }
    void Deposit(double amount) {
         this.balance += amount;
    }
    void Withdrawal(double amount) {
        if (this.balance - amount >= 0) {
            this.balance -= amount;
            System.out.println("Amount Withdrawal Successfully to Account " + accountNo);
        }else{
            System.out.println("Insufficient Balance");
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAatharNo() {
        return aatharNo;
    }

    public void setAatharNo(String aatharNo) {
        this.aatharNo = aatharNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
