/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication7;

import java.util.Scanner;

/**
 *
 * @author lakshanalahapperuma
 */
abstract class Bank {

    abstract double deposit();

    abstract double withdraw();

    abstract void getBalance(double balance);
}

class SavingsAccount extends Bank {

    private final Scanner in = new Scanner(System.in);

    @Override
    double deposit() {
        System.out.print("Enter the Deposit Amount: ");
        double depo = in.nextDouble();
        return depo > 0 ? depo : 0; // Ensuring deposit amount is positive
    }

    @Override
    double withdraw() {
        System.out.print("Enter the Withdraw Amount: ");
        double with = in.nextDouble();
        return with > 0 ? with : 0; // Ensuring withdrawal amount is positive
    }

    @Override
    void getBalance(double balance) {
        System.out.println("Your current balance is: " + balance);
    }
}

public class Bank12 {

    public static void main(String[] args) {
        double balance = 250000.50;
        final String USERNAME = "Lakshan";
        final String PASSWORD = "Lakshan@2002";
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the Username: ");
        String user = in.next();

        System.out.print("Enter the Password: ");
        String passw = in.next();

        // Check for valid login
        if (user.equalsIgnoreCase(USERNAME) && passw.equals(PASSWORD)) {
            SavingsAccount obj = new SavingsAccount();
            String work = "";

            do {
                System.out.print("\nWhat action would you like to perform? (deposit, withdraw, getbalance, exit): ");
                work = in.next().toLowerCase();

                switch (work) {
                    case "deposit":
                        double newDepo = obj.deposit();
                        if (newDepo > 0) {
                            balance += newDepo;
                            System.out.println("Deposit successful! New balance: " + balance);
                        } else {
                            System.out.println("Invalid deposit amount.");
                        }
                        break;

                    case "withdraw":
                        double newWith = obj.withdraw();
                        if (newWith > 0 && newWith <= balance) {
                            balance -= newWith;
                            System.out.println("Withdrawal successful! New balance: " + balance);
                        } else if (newWith > balance) {
                            System.out.println("Insufficient balance!");
                        } else {
                            System.out.println("Invalid withdrawal amount.");
                        }
                        break;

                    case "getbalance":
                        obj.getBalance(balance);
                        break;

                    case "exit":
                        System.out.println("Exiting the system. Have a nice day!");
                        break;

                    default:
                        System.out.println("Invalid action. Please try again.");
                }

            } while (!work.equals("exit")); // Terminate loop when "exit" is entered

        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
