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
public class SavingsAccount extends BankAccount{
    protected boolean isActive = (super.balance > 25); 

    // Constructors 
    public SavingsAccount() { 
        super(); 
    } 
    public SavingsAccount(double balance, double annualInterest) { 
        super(balance, annualInterest); 
    } 

    public double getMonthlyCharge() { 
        this.monthlyProcess(); 
        return monthlyCharge; 
    } 

    // Monthly charge process. 
    public void monthlyProcess() { 
        if (super.numberOfWithdrawals > 4) { 
        super.monthlyCharge += super.numberOfWithdrawals - 4; 
            if (super.balance < 25) { 
                this.isActive = false; 
            } 
        } 
    }   

    // Withdraw. 
    public boolean withdraw(double amount) { 
        if (isActive) { 
            return super.withdraw(amount); 
        } else { 
            return false; 
        } 
    } 

    // Deposit 
    public boolean deposit(double amount) { 
        super.deposit(amount); 
        if ((!this.isActive) && super.balance > 25) { 
            this.isActive = true; 
            return true; 
        } else { 
        return false; 
        } 

    } 

    public boolean getIsActive() { 
        return isActive; 
    } 
    public void setActive(boolean isActive) { 
        this.isActive = isActive; 
    }
}
