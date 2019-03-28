/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mockia.expenditures;

/**
 *
 * @author ethanli
 */

public abstract class Expenditures
{

    private String type;
    private String day;
    private String month;
    private String year;
    private double value;

    /**
     * Initialization constructor for Expenditure objects
     * @param type Type of spending
     * @param day The given day
     * @param month The given month
     * @param year The given year
     * @param value The given value
     */
    public Expenditures(String type, String day, String month, String year, 
            double value)
    {
        this.type = type;
        this.day = day;
        this.month = month;
        this.year = year;
        this.value = value;
    }

    /**
     * Modifier method for type
     * @param type Type of spending
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Modifier method for the day
     * @param day Day
     */
    public void setDay(String day)
    {
        this.day = day;
    }

    /**
     * Modifier method for the month
     * @param month Month
     */
    public void setMonth(String month)
    {
        this.month = month;
    }

    /**
     * Modifier method for the year
     * @param year Year
     */
    public void setYear(String year)
    {
        this.year = year;
    }

    /**
     * Modifier method for the expenditure value
     * @param value Expenditure amount
     */
    public void setValue(int value)
    {
        this.value = value;
    }

    /**
     * Accessor method for the type of spending
     * @return Double Type of spending
     */
    public String getType()
    {
        return type;
    }

    /**
     * Accessor method for the day
     * @return String day
     */
    public String getDay()
    {
        return day;
    }

    /**
     * Accessor method for the month
     * @return String month
     */
    public String getMonth()
    {
        return month;
    }

    /**
     * Acessor method for the year
     * @return String year
     */
    public String getYear()
    {
        return year;
    }

    /**
     * Acessor method for the expenditure amount
     * @return Double value
     */
    public double getValue()
    {
        return value;
    }
}