package functionality;

import java.security.SecureRandom;

public class Checking extends Account {
    //List properties specific to a checking account
    //12-digit code
    private final String debitCardNumber;
    //4-digit code
    private final String debitCardPIN;

    //Constructor to initialize checking account properties
    public Checking(String firstName, String socialSecurityNumber, double initDeposit) {
        super(firstName, socialSecurityNumber, initDeposit);
        //set an account number
        accountNumber = "1" + accountNumber;
        this.debitCardNumber = setDebitCardNumber();
        this.debitCardPIN = setNumberPIN();
    }

    //set a bank rate
    @Override
    public double setRate() {
        return getRate() * .15;
    }

    //List any methods specific to the checking account
    //Set random card number
    private String setDebitCardNumber() {
        final String chars = "0123456789";

        StringBuilder cardNumber = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < 8; i++) {
            //add a random number using the class random
            int randomIndex = random.nextInt(chars.length());
            //Add the char to cardNumber
            cardNumber.append(chars.charAt(randomIndex));
        }
        //set a special number of a bank
        String specialNumberOfCBank = "5555";
        return specialNumberOfCBank + cardNumber;
    }

    //Set random card PIN
    private String setNumberPIN() {
        final String chars = "0123456789";

        StringBuilder cardPIN = new StringBuilder();

        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < 4; i++) {
            int randomIndex = secureRandom.nextInt(chars.length());
            cardPIN.append(chars.charAt(randomIndex));
        }
        return cardPIN.toString();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        super.compound();
        String accountType = "checking";
        System.out.println(
                "ACCOUNT TYPE: " + accountType +
                        "\nCARD NUMBER: " + debitCardNumber +
                        "\nPIN CODE: " + debitCardPIN +
                        "\nBANK RATE: " + setRate() + "%"
        );
    }
}
