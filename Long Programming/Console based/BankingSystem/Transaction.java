public class Transaction {
      String accountNo;
      Double deposit;
      Double balance;
      Account a1;
      Account a2;
      public Transaction(Account a1,Account a2,double deposit) {
          this.a1=a1;
          this.a2=a2;
          this.deposit=deposit;
          transact(a1,a2,deposit);
      }
          void transact(Account a1,Account a2,double deposit) {
              if (a1.getBalance()-deposit >=0) {
                  a1.setBalance(a1.getBalance() - deposit);
                  a2.setBalance(a2.getBalance() + deposit);
                  System.out.println("Transaction Successful");
//                  System.out.println("Sender Balance : "+a1.getBalance());
//                  System.out.println("Receiver : "+a2.getBalance());
              }else{
                  System.out.println("Insufficient Balance");
              }
          }
          void showHistory() {
          System.out.println("Sender Account No : "+a1.getAccountNo() + " Receiver Account No : "+a2.getAccountNo()+" Deposit Amount : "+deposit);
          }
    public String getaccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
