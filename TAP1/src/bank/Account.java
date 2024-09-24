package bank;

import java.io.Serializable;

/**
 * Created by pedro on 9/14/15.
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    protected double balance;
    private Customer owner;

    /**
     * Setter for property 'interest'.
     * @param interest Value to set for property 'interest'.
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }

    /**
     * Interest
     */
    protected double interest;

    /**
     * Constructor for Account class.
     * @param balance The initial balance.
     * @param owner The owner of the account.
     */
    public Account(double balance, Customer owner) {
        this.balance = balance;
        this.owner = owner;
    }

    /**
     * Deposit money in the account.
     * @param amount The amount to deposit.
     */
    public void deposit(double amount){
        balance = balance + amount;
    }

    /**
     * Withdraw money from the account.
     * @param amount The amount to withdraw.
     * @throws NoMoney
     */
    public void withdraw(double amount) throws NoMoney{
        if (amount>balance)
            throw new NoMoney("No money enough");
        else
            balance = balance - amount;
    }

    /**
     * Getter for property 'balance'.
     * @return Value for property 'balance'.
     */
    public double getBalance(){
        return balance;
    }

    /**
     * toString method.
     */
    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", owner=" + owner +
                '}';
    }

    /**
     * Getter for property 'owner'.
     * @return
     */
    public Customer getOwner() {
        return owner;
    }

    /**
     * Setter for property 'owner'.
     * @param owner
     */
    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    /**
     * Getter for property 'interest'.
     * @return
     */
    public double getInterest(){
        return interest;
    }

    /**
     * Getter for property 'comission'.
     * @return
     */
    public double getComission(){
        return 1;
    }

    /**
     * Revision method.
     */
    public void revision(){
        balance = balance + balance*getInterest()-getComission();

    }

}
