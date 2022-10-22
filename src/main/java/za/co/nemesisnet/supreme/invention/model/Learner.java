/*
 *     
 * 
 */
package za.co.nemesisnet.supreme.invention.model;

import java.io.Serializable;

/**
 *
 * @author Peter B
 */
public class Learner implements Serializable{
    private int studentNumber;
    private String firstName;
    private String lastName;
    private boolean canBorrow;

    public Learner(int studentNumber, String firstName, String lastName,  boolean canBorrow) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.canBorrow = canBorrow;
    }

    public Learner() {

    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isCanBorrow() {
        return canBorrow;
    }

    public void setCanBorrow(boolean canBorrow) {
        this.canBorrow = canBorrow;
    }

    @Override
    public String toString() {
        return "Learner{" +
                "studentNumber=" + studentNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", canBorrow=" + canBorrow +
                '}';
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }

}
