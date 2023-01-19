package functionality;

import utilities.ReaderFiles;

import java.util.ArrayList;
import java.util.List;

public class BankApplication {
    public static void main(String[] args) {
        //Create a list of accounts
        List<Account> accounts = new ArrayList<>();

        //Read a txt file then create new accounts based on that data
        String file = "C:\\Users\\PADC\\Desktop\\Test\\NewBankAccounts.txt";
        //Read list of string array from ReaderFile's method and put it into newAccountHolders
        List<String[]> newAccountHolders = ReaderFiles.read(file);

        //Be sure that a file's line has not more than 4 words. Launch loop to read newAccountHolders list.
        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String socialSecurityNumber = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            //Separate saving and checking account by using if-else. Create account use constructor directly look at type of account.
            if (accountType.equals("Saving")) {
                accounts.add(new Saving(name, socialSecurityNumber, initDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, socialSecurityNumber, initDeposit));
            } else {
                System.out.println("In developing");
            }
        }
        //Print all accounts on screen
        for (int i = 0; i < accounts.size(); i++) {
            accounts.get(i).showInfo();
            System.out.println("\n*****************************");
        }
    }
}
