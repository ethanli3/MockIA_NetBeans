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
     * 
     * @param type
     * @param day
     * @param month
     * @param year
     * @param value 
     */
    public Expenditures(String type, String day, String month, String year, double value)
    {
        this.type = type;
        this.day = day;
        this.month = month;
        this.year = year;
        this.value = value;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setDay(String day)
    {
        this.day = day;
    }

    public void setMonth(String month)
    {
        this.month = month;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public String getType()
    {
        return type;
    }

    public String getDay()
    {
        return day;
    }

    public String getMonth()
    {
        return month;
    }

    public String getYear()
    {
        return year;
    }

    public double getValue()
    {
        return value;
    }
}