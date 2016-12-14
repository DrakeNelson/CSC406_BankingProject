package DatabaseObjects;

/**
 * Created by user on 12/10/2016.
 */
public abstract class Account {
    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    double currentBalance;

}
