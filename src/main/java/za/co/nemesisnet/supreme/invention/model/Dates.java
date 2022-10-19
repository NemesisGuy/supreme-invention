/*
 *     
 * 
 */
package za.co.nemesisnet.supreme.invention.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Peter B
 */
public class Dates {
    
    public static void main(String args[]) {
        
        Dates dates = new Dates();
        System.out.println(dates.getFormattedStartDate());
        System.out.println(dates.getFormattedEndDate());
        System.out.println(dates.getDateObject("1989-04-13"));
        System.out.println(dates.getDateString(dates.getDateObject("1989-04-13")));
        System.out.println(dates.getDateString(dates.getDateObject(dates.getFormattedStartDate())));     
    }
    //getter that returns the date object from string parameter
    public Date getDateObject(String date) {
        Date date1 = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            date1 = (Date) formatter.parse(date);
        } catch (Exception e) {
            System.out.println("Exception :" + e);
        }
        return date1;
    }
    //getter that returns the formatted date string from date object parameter
    public String getDateString(Date date) {
        String formattedDate = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = formatter.format(date);
        } catch (Exception e) {
            System.out.println("Exception :" + e);
        }
        return formattedDate;
    }
    //getter get todays  date , returns date object
    public Date getTodayDate() {
        Date date = new Date();
        return date;
    }
    
    public String getFormattedCurrentDate() {
        LocalDate startingDate = LocalDate.now();
        return startingDate.toString();
        
    }
    public String getFormattedStartDate() {
        LocalDate startingDate = LocalDate.now();
        return startingDate.toString();
        
    }
    
    public String getFormattedEndDate() {
        LocalDate startingDate = LocalDate.now();
        LocalDate endingDate = startingDate.plusDays(7);
        return endingDate.toString();
        
    }
}
