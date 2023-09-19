public class BankAccountTest {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount();
        account1.depositMoney(450, "checking");
        account1.depositMoney(600, "savings");

        System.out.println("Checking Balance: " + account1.getCheckingBalance());
        System.out.println("Savings Balance: " + account1.getSavingsBalance());
        System.out.println("Total Balance: " + account1.totalMoney);
        System.out.println("Number of accounts: " + account1.numberOfAccounts);

        account1.withdrawMoney(300, "savings");
        System.out.println("Savings Balance: " + account1.getSavingsBalance());
        System.out.println("Total Balance: " + account1.totalMoney);

    }
}