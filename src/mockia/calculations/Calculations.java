package mockia.calculations;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ethanli
 */
import mockia.expenditures.*;
import java.util.ArrayList;

public class Calculations
{

    /**
     * Method that uses an ArrayList of expenditures to calculate the total
     * spent in a given day given the type of expenditure
     * @param expenditures ArrayList of expenditure objects
     * @param day The given day
     * @param month The given month
     * @param year The given year
     * @param type The type of expenditure
     * @return A double of the total spending of the given date and type
     */
    public static double calculateDay
            (ArrayList<Expenditures> expenditures, String day, String month, 
                    String year, String type)
    {
        double total = 0;
        //Checks if the type is NOT equal to all
        //True - Runs a for loop that checks for all the expenditure objects
        //within the ArrayList expenditures with the specificied date AND TYPE
        //and adds up the total values of the objects.
        //
        //False - Runs a for loop that checks for all the expenditure objects
        //within the ArrayList expenditures with the specificied date and adds
        //up the total values of the objects. 
        if (!type.equals("all"))
        {
            for(Expenditures e : expenditures)
            {
                if (e.getDay().equals(day)
                        && e.getMonth().equals(month)
                        && e.getYear().equals(year)
                        && e.getType().equals(type))
                {
                    total += e.getValue();
                }
            }
        }
        else
        {
            for(Expenditures e : expenditures)
            {
                if (e.getDay().equals(day)
                        && e.getMonth().equals(month)
                        && e.getYear().equals(year))
                {
                    total += e.getValue();
                }
            }
        }
        return total;
    }

    /**
     * Method that uses an ArrayList of expenditures to calculate the total
     * spent in a given month given the type of expenditure
     * @param expenditures ArrayList of expenditures
     * @param month The given month
     * @param year The given year
     * @param type The expenditure type
     * @return A double of the total spending of the given date and type
     */
    public static double calculateMonth(ArrayList<Expenditures> expenditures, 
            String month, String year, String type)
    {
        double total = 0;
        //Checks if the type is NOT equal to all
        //True - Runs a for loop that checks for all the expenditure objects
        //within the ArrayList expenditures with the specificied month AND TYPE
        //and adds up the total values of the objects.
        //
        //False - Runs a for loop that checks for all the expenditure objects
        //within the ArrayList expenditures with the specificied month and adds
        //up the total values of the objects. 
        if (!type.equals("all"))
        {
            for(Expenditures e : expenditures)
            {
                if (e.getMonth().equals(month) 
                        && e.getYear().equals(year) 
                        && e.getType().equals(type))
                {
                    total += e.getValue();
                }
            }
        }
        else
        {
            for(Expenditures e : expenditures)
            {
                if (e.getMonth().equals(month) && e.getYear().equals(year))
                {
                    total += e.getValue();
                }
            }
        }
        return total;
    }
    
    /**
     * Method that uses an ArrayList of expenditures to calculate the total
     * spent in a given year given the type of expenditure
     * @param expenditures ArrayList of expenditures
     * @param year The given year
     * @param type The expenditure type
     * @return A double of the total spending of the given date and type
     */
    public static double calculateYear(ArrayList<Expenditures> expenditures, 
            String year, String type)
    {
        double total = 0;
        //Checks if the type is NOT equal to all
        //True - Runs a for loop that checks for all the expenditure objects
        //within the ArrayList expenditures with the specificied year AND TYPE
        //and adds up the total values of the objects.
        //
        //False - Runs a for loop that checks for all the expenditure objects
        //within the ArrayList expenditures with the specificied year and adds
        //up the total values of the objects. 
        if (!type.equals("all"))
        {
            for(Expenditures e : expenditures)
            {
                if (e.getYear().equals(year) && e.getType().equals(type))
                {
                    total += e.getValue();
                }
            }
        }
        else
        {
            for(Expenditures e : expenditures)
            {
                if (e.getYear().equals(year))
                {
                    total += e.getValue();
                }
            }
        }
        return total;
    }
}