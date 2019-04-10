/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mockia;

import mockia.calculations.Calculations;
import mockia.data.Database;
import gui.*;
import mockia.exchangeRates.ExchangeRates;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
/**
 *
 * @author ethanli
 */
public class MockIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception 
    {
        Database.createTable();
        guiFrame.main(null);
    }
}