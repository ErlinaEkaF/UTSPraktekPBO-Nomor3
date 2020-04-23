/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pbo3;


import java.awt.HeadlessException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class BankTest {
    public static void main(String[] args) { 
        double balance = 0; 
        double annualInterest = 0; 
        String output; 
        String input; 
        DecimalFormat df = new DecimalFormat("#0.00"); 

        do { 
        try { 
        output = "Enter your account balance $:"; 
        input = JOptionPane.showInputDialog(output); 

        balance = Double.parseDouble(input); 
        if (balance < 0) { 
            throw new NumberFormatException(); 
            } 
                 break; 
            }   catch (HeadlessException e) { 
                errorMsg(); 
            }   catch (NumberFormatException e) { 
                errorMsg(); 
            } 
        } while (true); 

        do { 
            try { 
                output = "Please enter your annual interest rate: \n" 
                + "EXAMPLE: A 4% interst rate is 0.04"; 
                input = JOptionPane.showInputDialog(output); 

                annualInterest = Double.parseDouble(input); 
                if (annualInterest < 0) { 
                throw new NumberFormatException(); 
                } 
                break; 
                } catch (HeadlessException e) { 
                    errorMsg(); 
                } catch (NumberFormatException e) { 
                    errorMsg(); 
                } 
            } while (true); 

    // Instantiate your object. 
    BankAccount savings = new SavingsAccount(balance, annualInterest); 

    do { 
        try { 
            output = "Enter the number of withdrawals:"; 
            input = JOptionPane.showInputDialog(output); 

            savings.numberOfWithdrawals = Integer.parseInt(input); 
            if (savings.numberOfWithdrawals < 0) { 
            throw new NumberFormatException(); 
            } 
            break; 
            } catch (HeadlessException e) { 
                errorMsg(); 
            } catch (NumberFormatException e) { 
            errorMsg(); 
            } 
        } while (true); 

        do { 
            try { 
                output = "Enter the number of deposits:"; 
                input = JOptionPane.showInputDialog(output); 

                savings.numberOfDeposits = Integer.parseInt(input); 
                if (savings.numberOfDeposits < 0) { 
                throw new NumberFormatException(); 
                } 
                    break; 
                } catch (HeadlessException e) { 
                    errorMsg(); 
                } catch (NumberFormatException e) { 
                    errorMsg(); 
                } 
            } while (true); 

    // Add the interest to the balance: 
    savings.calcInterest(); 

    output = "Account Balance with Interest: $" + df.format(savings.getBalance()); 
    output += "\nMonthly Charge that will be deducted: $" + df.format(savings.getMonthlyCharge()); 
    output += "\nAccount Status: "; 
    output += savings.getIsActive() ? "Is Active" : "Not Active"; 

    JOptionPane.showMessageDialog(null, output); 

    } 
    private static void errorMsg() { 
        String output; 
        output = "Error: There was an error with your entry"; 
        JOptionPane.showMessageDialog(null, output); 
    }
}
