/*
* Author: Zach Graham
*
* Date: 09/06/2012
*
* Course: COMP 2243-01 Fall 2012
*
* Assignment: PGM2
*
* Description: This program takes the input of an employee name and gross pay and
*              calculates the total tax and pension payments and net pay.
*
*/
package paycheckcalc;

import java.io.*;
import java.util.*;

/**
 *
 * @author Zach
 */
public class PaycheckCalc
    {
    //Declare constants for tax rates, percentages, etc.
    static final double FED_TAX = .15;
    static final double STATE_TAX = .035;
    static final double SOC_SEC_TAX = .0575;
    static final double MEDICARE_MEDICAID_TAX = .0275;
    static final double PENSION_PLAN = .05;
    static final double HEALTH_INSURANCE = 75.00; //Flat fee in Dollars
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
                            throws FileNotFoundException
    {
        //Create input and output objects
        Scanner console = new Scanner(System.in); //Create scanner object for input
        PrintWriter outFile = new PrintWriter("paycheck.txt");
        
        //Prompt user for input of employee name and gross pay
        System.out.print("Please enter the employee name: ");
        String employeeName = console.nextLine();
        System.out.print("Please enter the gross pay: ");
        double grossPay = console.nextDouble();
        
        //Declare variables and calculate totals for taxes etc.
        double fedTax = grossPay * FED_TAX;
        double stateTax = grossPay * STATE_TAX;
        double socSecTax = grossPay * SOC_SEC_TAX;
        double mediCareCaidTax = grossPay * MEDICARE_MEDICAID_TAX;
        double pensionPlan = grossPay * PENSION_PLAN;
        double netPay = (grossPay - fedTax - stateTax - socSecTax - mediCareCaidTax 
                         - pensionPlan - HEALTH_INSURANCE);
        
        //Generate the output for the paycheck calculation
        String outputStr = String.format("%s%n" +
                               "Gross Amount:               $%.2f %n" +
                               "Federal Tax:                $%.2f %n" +
                               "State Tax:                  $%.2f %n" +
                               "Social Security Tax:        $%.2f %n" +
                               "Medicare/Medicaid Tax:      $%.2f %n" +
                               "Pension Plan:               $%.2f %n" + 
                               "Health Insurance:           $%.2f %n" +
                               "Net Pay:                    $%.2f %n", 
                               employeeName, grossPay, fedTax, stateTax,
                               socSecTax, mediCareCaidTax,pensionPlan, 
                               HEALTH_INSURANCE, netPay);
        
        System.out.println(outputStr); //Output to console
          
        outFile.println(outputStr); //Write the output to file
        
        outFile.close(); //Close the file
    } //End main()
} //End class PaycheckCalc
