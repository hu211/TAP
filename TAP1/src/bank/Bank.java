package bank;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.io.Serializable;

/**
 * Created by pedro on 9/14/15.
 */
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private List<Account> accounts = new LinkedList<Account>();
    private List<Customer> customers = new LinkedList<Customer>();

    /**
     * Constructor for Bank class.
     * @param name The name of the bank.
     */
    public Bank(String name) {
        this.name = name;
    }

    /**
     * Method to add a new account to the bank.
     * @param newAccount The account to add.
     */
    public void addAccount(Account newAccount){
        accounts.add(newAccount);
    }

    /**
     * Method to remove an account from the bank.
     * @param oldAccount The account to remove.
     */
    public void removeAccount(Account oldAccount){
        accounts.remove(oldAccount);
    }

    /**
     * Method to get the list of accounts.
     * @return The list of accounts.
     */
    public List<Account> getAccounts(){
        return accounts;
    }

    /**
     * Method to add a new customer to the bank.
     * @param newCustomer The customer to add.
     */
    public void addCustomer(Customer newCustomer){
        customers.add(newCustomer);
    }

    /**
     * Method to remove a customer from the bank.
     * @param oldCustomer The customer to remove.
     */
    public void removeCustomer(Customer oldCustomer){
        customers.remove(oldCustomer);
    }

    /**
     * Method to get the list of customers.
     * @return The list of customers.
     */
    public List<Customer> getCustomers(){
        return customers;
    }

    /**
     * Method to show the accounts of the bank.
     */
    public void showAccounts(){
        for (Account a:accounts)
            System.out.println(a);
    }

    /**
     * Method to show the customers of the bank.
     */
    public void revision(){
        for (Account acc:accounts)
            acc.revision();
    }

    /**
     * Method to perform a lottery.
     */
    public void lottery() {
        if(accounts.isEmpty()) {
            System.out.println("No accounts available for lottery.");
            return;

        }
        // Select a random account
        Random random = new Random();
        int randomIndex = random.nextInt(accounts.size());  // Get a random index
        Account winner = accounts.get(randomIndex);         // Select the winning account

        // Credit the account with 300 euros (assuming the Account class has a credit method)
        winner.deposit(300);
        // Announce the winner
        System.out.println("\nLottery Winner: " + winner.getOwner() + " has been credited with 300 euros.");
        System.out.println("New balance: " + winner.getBalance());
    }

    /**
     * Method to show the accounts of the bank ordered by balance.
     */
    public void showAccountsOrdered() {
        // Sort the accounts by balance
        accounts.sort((a1, a2) -> Double.compare(a1.getBalance(), a2.getBalance()));

        // Print the sorted accounts
        for (Account a : accounts) {
            System.out.println(a);
        }
    }
}
