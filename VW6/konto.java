class Account {
    double balance;

    double currentBalance() {
        return this.balance;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    boolean withdraw(double amount) {
        if(amount <= this.balance) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    static boolean isValidAmount(double amount) {
        //Am besten man rechnet den Amount nicht in €, sondern in ct, also mit long's
        return true;
    }

    @Override
    public String toString() {
        return String.format("%+.2f€", this.balance);
    }
}