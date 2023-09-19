public class BankAccount {
    private double checkingBalance;
    private double savingBalance;
    public static int numberOfAccounts = 0;
    public static double totalMoney = 0;

    public BankAccount(){
        this.checkingBalance = 0.0;
        this.savingBalance = 0.0;
        numberOfAccounts++;
    }

    public BankAccount(double checking, double savings){
        this.checkingBalance = checking;
        this.savingBalance = savings;
        numberOfAccounts++;
    }

    // Getters
    public double getCheckingBalance() {
        return checkingBalance;
    }
    
    public double getSavingsBalance() {
        return savingBalance;
    }

    // Setters
    public void setCheckingBalance(double balance){
        this.checkingBalance = balance;
    }
    
    public void setSavingsBalance(double balance){
        this.savingBalance = balance;
    }

    public void depositMoney(double deposit, String account){
        if(account.equals("checking")){
            this.checkingBalance += deposit;
            totalMoney += deposit;
        }else{
            this.savingBalance += deposit;
            totalMoney += deposit;
        }
    }

    public void withdrawMoney(double withdraw, String account){
        if(account.equals("checking")){
            if(this.checkingBalance - withdraw < 0){
                System.out.println("Insufficient funds.");
            }else{
                this.checkingBalance -= withdraw;
                totalMoney -= withdraw;
            }
        }else{
            if(this.savingBalance - withdraw < 0){
                System.out.println("Insufficient funds.");
            }else{
                this.savingBalance -= withdraw;
                totalMoney -= withdraw;
            }
        }
    }

    public void getTotalBalance() {
        System.out.println("Total amount: " + totalMoney);
    }
    
}