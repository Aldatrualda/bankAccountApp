package functionality;

import java.security.SecureRandom;

public class Saving extends Account {
    //List properties specific to a saving account
    private final String safetyDepositBox;
    private final String safetyDepositBoxKey;

    //Constructor to initialize saving account properties
    public Saving(String firstName, String socialSecurityNumber, double initDeposit) {
        super(firstName, socialSecurityNumber, initDeposit);
        //Set an account number
        accountNumber = "2" + accountNumber;
        this.safetyDepositBox = setSafetyDepositBox();
        this.safetyDepositBoxKey = setSafetyDepositBoxKey();
    }

    //Set a bank rate
    @Override
    public double setRate() {
        return getRate() - .25;
    }

    //List any methods specific to the saving account
    //set a digital number of a safe deposit box and  length of box is 3
    public String setSafetyDepositBox() {

        final String chars = "0123456789";

        //Create the object to use methods of java.security.SecureRandom package
        SecureRandom random = new SecureRandom();
        //Create the variable of StringBuilder adding random char symbols to there
        StringBuilder safetyDepositBox = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            //Create the variable to choose a random index not more than a length of Char
            int randomIndex = random.nextInt(chars.length());
            //Add the char to safetyDepositBox
            safetyDepositBox.append(chars.charAt(randomIndex));
        }
        return safetyDepositBox.toString();
    }

    //set a digital number of a safe deposit box and length of box is 4
    public String setSafetyDepositBoxKey() {
        final String chars = "0123456789";

        //Create the object to use methods of java.security.SecureRandom package
        SecureRandom random = new SecureRandom();
        //Create the variable of StringBuilder adding random char symbols to there
        StringBuilder safetyDepositBoxKey = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            //Create the variable to choose a random index not more than a length of Char
            int randomIndex = random.nextInt(chars.length());
            //Add the char to safetyDepositBox
            safetyDepositBoxKey.append(chars.charAt(randomIndex));
        }
        return safetyDepositBoxKey.toString();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        super.compound();
        String accountType = "savings";
        System.out.println("ACCOUNT TYPE: " + accountType +
                "\nSafe deposit box: " + safetyDepositBox +
                "\nSafe deposit box key: " + safetyDepositBoxKey +
                "\nBank rate: " + setRate() + "%"
        );
    }
}
