/*
 *     
 * 
 */
package za.co.nemesisnet.supreme.invention.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.EmailValidator;

/**
 *
 * @author Peter Buckingham
 */
public class Validator {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Validator validator = new Validator();
        String emailAddress = "username@domain.com";
        System.out.println(validator.isEmailValid(emailAddress));
        System.out.println(validator.comparePasswords("hello", "hello"));
        System.out.println(validator.isValidPassword("test@1234"));
    }

    /**
     *
     * @param emailAddress
     * @return
     */
    public boolean isEmailValid(String emailAddress) {
        //  String emailAddress = "username@domain.com";

        /// return   this.isEmailValid(emailAddress) ;
        return EmailValidator.getInstance().isValid(emailAddress);

    }

    /**
     *
     * @param email
     * @param emailConfirm
     * @return
     */
    public boolean compareEmails(String email, String emailConfirm) {
        return email.equals(emailConfirm);
    }
    // Function to validate the password.

    /**
     *
     * @param password
     * @return
     */
    public boolean isValidPassword(String password) {

        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);

        // Return if the password
        // matched the ReGex
        return m.matches();
    }

    /**
     *
     * @param password
     * @param comfirmPassword
     * @return
     */
    public boolean comparePasswords(String password, String comfirmPassword) {
        if (password.equals(comfirmPassword)) {
            return true;
        } else {
            return false;
        }
    }

}
