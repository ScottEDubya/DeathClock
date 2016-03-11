/*
 Program: Gregorian Calendar Death Clock, DeathClock.java
 Created as my first Java project in Object Oriented Programming course, Fall 2015
 Contributor(s): Scott Williams
 Created on 9-15-15
 Last Modified: 3-11-16
 */

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DeathClassProg1 {
	//main class handles all needed execution
	//not an excellent object oriented approach to the problem
	public static void main(String[] args){
		
		//VARIABLE DECLARATIONS
		String gender;
		int month, day, year;
		double yearsLeft = 0;
		
		//INPUT FOR DEATH CLOCK USE
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your gender(m/f): ");
		gender = in.nextLine();
		System.out.print("Now enter your birthdate(MO DA YEAR): ");
		//month subtracts one for the month's index
		month = in.nextInt() - 1;
		day = in.nextInt();
		year = in.nextInt();
		
		// today’s date
		Calendar today = new GregorianCalendar();
		
		Calendar testbday = new GregorianCalendar(year, month, day);
		
		//GETS CURRENT AGE OF USER
		double age = TimeUnit.MILLISECONDS.toDays(today.getTimeInMillis() 
				- testbday.getTimeInMillis()) / 365.25;
		
		
		//calculation for how long a male has left to live
		if(gender.equalsIgnoreCase("m")) {
			yearsLeft = ((.005 * Math.pow(age,2)) - (1.265 * (age)) + 79.554);
		}
		//calculation for how long a female has left to live
		else if (gender.equalsIgnoreCase("f")) {
			yearsLeft = ((.005 * Math.pow(age,2)) - (1.292 * (age)) + 84.706);
		}
		//IF INPUT WAS INCORRECT
		//Not handling incorrect input thoroughly
		else System.out.println("Gender error.\n");
		
		double daysLeft = yearsLeft * 365.25;
		
		//ADD DAYS LEFT TO CURRENT CALENDAR
		//ADD 1 TO ACCOUNT FOR TRUNCATION OF PARTIAL DAYS
		today.add(Calendar.DATE, (int)daysLeft + 1);
		
		int deathday = today.get(Calendar.DAY_OF_MONTH);
		int deathmonth = today.get(Calendar.MONTH);
		int deathyear = today.get(Calendar.YEAR);
		int deathweekday = today.get(Calendar.DAY_OF_WEEK);
		
		//ASSIGNS NAME TO WEEKDAY
		String dayofweek = "";
		switch(deathweekday) {
		case 1:	dayofweek = "Sunday";
			break;
		case 2:	dayofweek = "Monday";
			break;
		case 3:	dayofweek = "Tuesday";
			break;
		case 4:	dayofweek = "Wednesday";
			break;
		case 5:	dayofweek = "Thursday";
			break;
		case 6:	dayofweek = "Friday";
			break;
		case 7: dayofweek = "Saturday";
			break;
		default:
			System.out.print("Invalid weekday.\n");
			break;
		}
		
		//ASSIGNS NAME TO MONTH
		String monthString = "";
        switch (deathmonth) {
            case 0:  monthString = "January";
                     break;
            case 1:  monthString = "February";
                     break;
            case 2:  monthString = "March";
                     break;
            case 3:  monthString = "April";
                     break;
            case 4:  monthString = "May";
                     break;
            case 5:  monthString = "June";
                     break;
            case 6:  monthString = "July";
                     break;
            case 7:  monthString = "August";
                     break;
            case 8:  monthString = "September";
                     break;
            case 9: monthString = "October";
                     break;
            case 10: monthString = "November";
                     break;
            case 11: monthString = "December";
                     break;
            default: System.out.print("Invalid Month.\n");
                     break;
        }

        System.out.println("Date of expected death: " + dayofweek + ", " + monthString + " " +
				deathday + ", " + deathyear);
	
		in.close();
	}
}
