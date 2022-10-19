/*
 *     
 * 
 */
package za.co.nemesisnet.supreme.invention.model;

import java.awt.*;
import java.util.Date;

/**
 *
 * @author Peter B
 *  Load object, used to work with loan data.
 */
public class Loan {
    private String loanId;
    private String userId;
    private String ISBN;
    private String loanFromDate;
    private String dueOnDate;
    private String returnedDate;

    public Loan(User user, Book book) {
        userId = user.getUserId();
        ISBN = String.valueOf(book.getISBN());
        Dates dates = new Dates();

        loanFromDate = dates.getFormattedStartDate();
        dueOnDate = dates.getFormattedEndDate();
    }

    public Loan(String loanId, String userId, String ISBN, String loanFromDate, String dueOnDate, String returnedDate) {
        this.loanId = loanId;
        this.userId = userId;
        this.ISBN = ISBN;
        this.loanFromDate = loanFromDate;
        this.dueOnDate = dueOnDate;
        this.returnedDate = returnedDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getLoanFromDate() {
        return loanFromDate;
    }

    public void setLoanFromDate(String loanFromDate) {
        this.loanFromDate = loanFromDate;
    }

    public String getDueOnDate() {
        return dueOnDate;
    }

    public void setDueOnDate(String dueOnDate) {
        this.dueOnDate = dueOnDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }


    public String isOverdue(Date dueOnDate) {
        Dates dates = new Dates();
        Date today = dates.getTodayDate();
        if (today.after(dueOnDate)) {
            return "Overdue";
        } else {
            return "Not Overdue";
        }
    }

    public int getDaysOverdue() {
        Dates dates = new Dates();
        Date today = dates.getTodayDate();
        Date dueOn = dates.getDateObject(dueOnDate);
        long diff = today.getTime() - dueOn.getTime();
        long days = diff / (24 * 60 * 60 * 1000);
        return (int) days;
    }

    public int getLoanNumber() {
        return Integer.parseInt(loanId);
    }

    public Book getBook() {
        Book book = new Book();

        return null;
    }

    public int getCurrentPenaltyCost() {
        //totalPenaltyCost is calculated as follows: Every book on loan must be returned within 7 days. R0.50 penalty is
        //charged for every day after the 7 days.
        int totalPenaltyCost = 0;
        int daysOverdue = getDaysOverdue();
        if (daysOverdue > 7) {
            totalPenaltyCost = (daysOverdue - 7) * 50;
        } else {
            totalPenaltyCost = 0;
        } //
        return totalPenaltyCost;
    }
}

