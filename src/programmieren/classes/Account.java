package programmieren.classes;

public class Account {
    private int number;
    private String owner;
    private double money;
    private double limit;

    public Account(int number, String owner, double money, double limit) {
        this.number = number;
        this.owner = owner;
        this.money = money;
        this.limit = limit;
    }

    public String toString() {
        return String.format("Hello %s, your account with number %d has %f $ with the limit of %f $.",
                this.owner, this.number, this.money, this.limit);
    }

    private void deposit(int amount) {
        if (amount > 0) {
            this.money += amount;
            System.out.format("You successfully added %d to your account with number: %d",
                    amount, this.number);
        } else {
            System.out.println("You can't deposit a negative amount.");
        }
    }

    private void withdraw(int amount) {
        if (amount <= this.money) {
            this.money -= amount;
            System.out.format("You successfully withdrew %d from your account with number: %d",
                    amount, this.number);
        } else {
            System.out.format("You can't withdraw that much from your account, you only have %f", this.money);
        }

    }

    private void balance() {
        System.out.println(this.toString());
    }

    public static void main(String[] args) {
        Account account = new Account(4711, "Donald Duck", 500, 1000);
        System.out.println(account);
        account.deposit(200);
        System.out.println(account);
        account.withdraw(400);
        System.out.println(account);
        account.withdraw(2000);
        System.out.println(account);
    }
}
