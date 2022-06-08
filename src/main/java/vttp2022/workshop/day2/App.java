package vttp2022.workshop.day2;

import vttp2022.workshop.day2.BankAccount;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My ATM machine" );
        BankAccount bkAcc = new BankAccount ("JP's Bank Account");
        bkAcc.deposit("1000");
        System.out.println("My new account balance >" + bkAcc.getBalance());

        bkAcc.withdraw("500");
        System.out.println("My new account balance >" + bkAcc.getBalance());
    }
}
