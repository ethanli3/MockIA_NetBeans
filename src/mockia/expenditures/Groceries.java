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
public class Groceries extends Expenditures
{

     /**
     * Initialization constructor that passes all the methods to parent class
     * Expenditures
     * @param type Type of Spending
     * @param day Given Day
     * @param month Given Month
     * @param year Given Year
     * @param value Given Value
     */
    public Groceries(String type, String day, String month, String year, double value)
    {
        super(type, day, month, year, value);
    }
}