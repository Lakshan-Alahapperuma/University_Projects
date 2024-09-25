/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication9;

import java.util.Scanner;

/**
 *
 * @author lakshanalahapperuma
 */
public class OnlineBankingApplication {

    private String username = "Lakshan";
    private String password = "Nadun@2002";
    private double account_balance = 500000.00;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }

    
}

class BankManagement {

    void authenticate() {

        Scanner in = new Scanner(System.in);

        OnlineBankingApplication obj = new OnlineBankingApplication();

        BankManagement obj1 = new BankManagement();

        System.out.print("Enter the User name :");
        String name = in.nextLine().trim();

        System.out.print("Enter the Password : ");
        String pass = in.nextLine();

        if (name.equals(obj.getUsername())) {

            if (pass.equals(obj.getPassword())) {

                System.out.print("Select an operation : ");

                System.out.println("\n1.Check Balance\n2.Deposite Money\n3.Withdraw Money");

                System.out.print("Enter Your Choice : ");
                
                String option = in.nextLine();

                switch (option) {

                    case "1":
                        obj1.getbalance();
                        break;

                    case "2":
                        obj1.Deposite();
                        break;
                        
                    case "3" :
                        

                }

            }

        } else {

            System.out.println("Access denide..!");

        }

    }

    void getbalance() {

        OnlineBankingApplication obj = new OnlineBankingApplication();

        System.out.println(obj.getAccount_balance());
    }

    void Deposite() {

        Scanner in = new Scanner(System.in);

        OnlineBankingApplication obj = new OnlineBankingApplication();

        System.out.print("Enter the Deposite Money : ");

        double depo = in.nextDouble();

        double newtot = obj.getAccount_balance() + depo;

        obj.setAccount_balance(newtot);
        
        System.out.println("New Balance is : " + obj.getAccount_balance());

    }
    
    void Withdraw(){
        
        Scanner in = new Scanner(System.in);

        OnlineBankingApplication obj = new OnlineBankingApplication();
        
        

        System.out.print("Enter the Withdraw Money : ");

        double with = in.nextDouble();

        if(obj.getAccount_balance() > with){
        
           double newbal = obj.getAccount_balance() - with;
           
           obj.setAccount_balance(newbal);
            
        }
        
    }

    public static void main(String[] args) {

        BankManagement obj1 = new BankManagement();

        obj1.authenticate();

    }
}
