/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pbo3;

/**
 *
 * @author User
 */
public abstract class BankAccount {
     protected double balance; 
        protected int numberOfDeposits; 
        protected int numberOfWithdrawals; 
        protected double annualInterest; 
        protected double monthlyCharge; 

// Constructor accepts annual interest and 
// the balance. 
    public BankAccount(double balance, double annualInterest) { 
        this.setAnnualInterest(annualInterest);
        this.setBalance(balance); 
    } 
// Default constructor. 
    public BankAccount() {} 

// Monthly charge process.  
    public void monthlyProcess() { 
        this.balance -= this.monthlyCharge; 
        this.calcInterest(); 
        this.monthlyCharge = 0; 
        this.numberOfDeposits = 0; 
        this.numberOfWithdrawals = 0; 
    } 

// Calculate the interest. 
    public void calcInterest() { 
        double monthlyInterestRate; 
        double monthlyInterest; 

        monthlyInterestRate = this.annualInterest / 12; 
        monthlyInterest = this.balance * monthlyInterestRate; 
        this.balance = this.balance + monthlyInterest;  
    } 

// Withdraw. 
    public boolean withdraw(double amount) { 
        if ((this.balance > amount) && (amount > 0)) 
        { 
            this.balance -= amount; 
            this.numberOfWithdrawals++; 
            return true; 
        } else { 
        return false; 
        } 
    } 

// Deposit 
    public boolean deposit(double amount) { 
        if (amount > 0) 
        { 
            this.balance += amount; 
            this.numberOfDeposits++; 
            return true; 
        } else { 
        return false; 
        } 
    } 

// Accessors and mutators. 
    public double getBalance() { 
        return balance; 
    } 

    public void setBalance(double balance) { 
        this.balance = balance; 
    } 

    public int getNumDepositsThisMonth() { 
        return numberOfDeposits; 
    } 

    public void setNumDepositsThisMonth(int numDepositsThisMonth) { 
        this.numberOfDeposits = numDepositsThisMonth; 
    } 

    public double getAnnualInterest() { 
        return annualInterest; 
    } 

    public void setAnnualInterest(double annualInterest) { 
        this.annualInterest = annualInterest; 
    } 

    public double getMonthlyCharge() { 
        return monthlyCharge; 
    } 

    public void setMonthlyCharge(double monthlyCharge) { 
        this.monthlyCharge = monthlyCharge; 
    } 
    public boolean getIsActive() { 
// TODO Auto-generated method stub 
    return (Boolean) null; 
    } 
    
}
