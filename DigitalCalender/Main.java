
/* Name: M.Hassaan Atif
Roll no: 0147-BSCS-19
SECTION: C
 */
 import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

/*DECLARING FIELDS HERE */
        int date, year, hours, seconds, minutes, timer;
         String monthName = "";
         String dayName = "";
        boolean leapYear;
        var scanner = new Scanner (System.in);

        /* FEATURES DOCUMENTATION*/
     System.out.println("----DIGITAL CALCULATOR----");
     System.out.println("Features: 1: Can handle leap year based on a boolean value");
     System.out.println("2: Subscripts may vary based on the day number");
     System.out.println("3: Works just like a real calculator i.e months with 30 days will have 30 days, and months with 31 days will have 31 days (unless specified differently by the user)");
     System.out.println("4. Capable of handling many edge cases (such as d,t,s,h exceeding their limits, higher number of days in feb during the leap year or even wrong DayName/MonthName)");
     Thread.sleep(2000);

     /*TAKING INPUTS */
     System.out.println();
     System.out.print("Please enter the speed of the calculator in milliseconds: ");
     timer = scanner.nextInt();
        System.out.print("Please enter the year (ex: 2002) : ");
        year = scanner.nextInt();

        System.out.print("Please enter month name (ex: February) : " );
        monthName = scanner.next();
        System.out.print("Please enter date from 0 to 31 (depending on the month): ");
        date = scanner.nextInt();
        System.out.print("Please enter day name (ex: Tuesday) : ");
        dayName = scanner.next();
        System.out.print("Please enter any minutes value from 0 to 59: ");
        minutes = scanner.nextInt();
        System.out.print("Please enter any seconds value from 0 to 59: ");
        seconds = scanner.nextInt();
        System.out.print("Please enter any hours value from 0 to 23: ");
        hours = scanner.nextInt();
        System.out.print("Is this a leap year? (answer true or false): ");
        leapYear = scanner.nextBoolean();
        System.out.println();

        //FOR HANDLING EDGE CASES:
        if(minutes >= 60) {
            minutes = 59;
        }
        if(hours > 23) {
            hours = 23;
        }
        if(seconds >= 60) {
            seconds = 59;
        }
        if (date > 31) {
            date = 31;
        }
        if(minutes < 0 || hours < 0 || seconds < 0 || date < 0 || timer < 0)
            throw new IllegalArgumentException("Time cannot be a negative value!");

        //You can un-comment the following block of code if you wish for the program to automatically take you back to the 29th of February in case it's a leap AND your date exceed the number 29
       /*
       if(monthName.equals("February") && leapYear == true && date > 29)
            date = 29; */
        /*

        INSTANCE OF THE CALENDER CLASS*/
         DigitalCalender calender = new DigitalCalender( leapYear, minutes, hours, seconds, date, year, monthName, dayName);

         /*DISPLAYING TIME*/
        for(int i = 0; i<61; i++) {
         /* Un-comment the following line if you wanna clear the console on each iteration */  
         // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            calender.displayTime();
            Thread.sleep(timer);
            calender.timeTick();
        }
    }

}




