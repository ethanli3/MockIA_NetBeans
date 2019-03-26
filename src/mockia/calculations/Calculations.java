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

    public static double calculateDay
            (ArrayList<Expenditures> expenditures, String day, String month, String year, String type)
    {
        double total = 0;
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

    public static int calculateMonth(ArrayList<Expenditures> expenditures, String month, String year, String type)
    {
        int total = 0;
        if (!type.equals("all"))
        {
            for(Expenditures e : expenditures)
            {
                if (e.getMonth().equals(month) && e.getYear().equals(year) && e.getType().equals(type))
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
    
    public static int calculateYear(ArrayList<Expenditures> expenditures, String year, String type)
    {
        int total = 0;
        if (!type.equals("all"))
        {
            for(Expenditures e : expenditures)
            {
                if ( e.getYear().equals(year) && e.getType().equals(type))
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