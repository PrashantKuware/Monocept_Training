package assignment1.AccountManagementSystem;

class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(int accNo, String name, double balance, double overdraftLimit) {

        super(accNo, name, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {

        double possibleBalance = balance - amount;

        if (possibleBalance >= -overdraftLimit) {
            balance -= amount;
        } else {
            System.out.println("Overdraft limit exceeded");
        }
    }

    @Override
    public void displayAccountDetails() {

        super.displayAccountDetails();
        System.out.println("Account Type   : Current");
        System.out.println("Overdraft Limit: " + overdraftLimit);
        System.out.println("-----------------------------");
    }
}